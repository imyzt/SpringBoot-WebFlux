package top.imyzt.webflux.demo7.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import top.imyzt.webflux.demo7.domain.Book;

/**
 * @author imyzt
 * @date 2019/2/19 15:41
 * @description BookRepository
 */
@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Long> {
}
