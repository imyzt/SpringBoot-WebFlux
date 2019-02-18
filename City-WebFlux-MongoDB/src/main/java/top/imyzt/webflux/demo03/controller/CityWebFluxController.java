package top.imyzt.webflux.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.imyzt.webflux.demo03.domain.City;
import top.imyzt.webflux.demo03.handler.CityHandler;

/**
 * @author imyzt
 * @date 2019/2/16 18:04
 * @description CityWebFluxController
 */
@RestController
@RequestMapping("/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping()
    public Flux<City> findAllCity() {

        return cityHandler.findAllCity();
    }

    @PostMapping()
    public Mono<City> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @PutMapping()
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }
}
