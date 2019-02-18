package top.imyzt.webflux.demo03.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import top.imyzt.webflux.demo03.domain.City;

/**
 * @author imyzt
 * @date 2019/2/16 17:46
 * @description CityRepository
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {
}
