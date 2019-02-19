package top.imyzt.webflux.demo7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.imyzt.webflux.demo7.domain.Book;
import top.imyzt.webflux.demo7.repository.BookRepository;

/**
 * @author imyzt
 * @date 2019/2/19 15:43
 * @description BookService
 */
@Component
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<Book> save(Book book) {
        book.setId(null);
        return bookRepository.save(book);
    }

    public Mono<Void> deleteById(Long id) {
        return bookRepository.deleteById(id);
    }

    public Mono<Book> update(Book book) {
        return bookRepository.save(book);
    }

    public Mono<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }
}
