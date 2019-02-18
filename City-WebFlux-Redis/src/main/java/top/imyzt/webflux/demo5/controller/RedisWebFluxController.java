package top.imyzt.webflux.demo5.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import top.imyzt.webflux.demo5.domain.City;

import java.util.concurrent.TimeUnit;

/**
 * @author imyzt
 * @date 2019/2/18 11:13
 * @description RedisWebFluxController
 */
@RestController
@RequestMapping("city")
public class RedisWebFluxController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("{id}")
    public Mono<City> findById(@PathVariable Long id) {
        String key = "city_" + id;
        if (redisTemplate.hasKey(key)) {
            String city = redisTemplate.opsForValue().get(key);
            return Mono.create(cityMonoSink -> cityMonoSink.success(JSON.parseObject(city, City.class)));
        }
        return Mono.create(cityMonoSink -> cityMonoSink.success(null));
    }

    @PostMapping()
    public Mono<City> saveCity(@RequestBody City city) {
        String key = "city_" + city.getId();
        redisTemplate.opsForValue().set(key, JSON.toJSONString(city), 60, TimeUnit.SECONDS);
        return Mono.create(monoSink -> monoSink.success(city));
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        String key = "city_" + id;
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
        return Mono.create(monoSink -> monoSink.success(id));
    }

}
