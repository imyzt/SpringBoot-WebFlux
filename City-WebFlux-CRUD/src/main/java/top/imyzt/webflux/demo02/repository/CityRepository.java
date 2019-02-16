package top.imyzt.webflux.demo02.repository;

import org.springframework.stereotype.Repository;
import top.imyzt.webflux.demo02.domain.City;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author imyzt
 * @date 2019/2/16 16:58
 * @description 城市服务的数据访问类
 */
@Repository
public class CityRepository {

    private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>();

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    public Long save(City city) {
        Long id = ID_GENERATOR.incrementAndGet();
        city.setId(id);
        repository.put(id, city);
        return id;
    }

    public Collection<City> findAll() {
        return repository.values();
    }

    public City findCityById(Long id) {
        return repository.get(id);
    }

    public Long updateCity(City city) {
        if (repository.containsKey(city.getId())) {
            repository.put(city.getId(), city);
        }
        return city.getId();
    }

    public Long deleteCity(Long id) {
        repository.remove(id);
        return id;
    }

}
