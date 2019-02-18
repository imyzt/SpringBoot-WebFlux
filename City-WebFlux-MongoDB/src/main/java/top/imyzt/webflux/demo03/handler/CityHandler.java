package top.imyzt.webflux.demo03.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.imyzt.webflux.demo03.domain.City;
import top.imyzt.webflux.demo03.repository.CityRepository;

/**
 * @author imyzt
 * @date 2019/2/16 17:59
 * @description CityHandler
 */
@Component
public class CityHandler {

    private final CityRepository cityRepository;

    @Autowired
    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<City> save(City city) {
        return cityRepository.save(city);
    }

    public Mono<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public Flux<City> findAllCity() {
        return cityRepository.findAll();
    }

    public Mono<City> modifyCity(City city) {
        return cityRepository.save(city);
    }

    public Mono<Long> deleteCity(Long id) {
        cityRepository.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }
}
