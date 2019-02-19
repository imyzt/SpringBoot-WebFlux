package top.imyzt.webflux.demo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import top.imyzt.webflux.demo7.domain.Book;
import top.imyzt.webflux.demo7.service.BookService;

/**
 * @author imyzt
 * @date 2019/2/19 15:42
 * @description BookController
 */
@Controller
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getBookList")
    public Mono<String> getBookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return Mono.create(monoSink -> monoSink.success("bookList"));
    }

    @GetMapping("getById/{id}")
    public Mono<String> getById(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return Mono.create(monoSink -> monoSink.success("bookDetail"));
    }

    @PostMapping("updateById")
    public Mono<String> updateById(Book book, Model model) {
        model.addAttribute("book", bookService.update(book));
        return Mono.create(monoSink -> monoSink.success("bookDetail"));
    }

    @GetMapping("deleteById/{id}")
    public Mono<String> deleteById(@PathVariable Long id, Model model) {
        bookService.deleteById(id);
        return Mono.create(monoSink -> monoSink.success("redirect:/book/getBookList"));
    }

    @GetMapping("create")
    public Mono<String> create(Model model) {
        model.addAttribute("book", new Book());
        return Mono.create(monoSink -> monoSink.success("bookDetail"));
    }
    @PostMapping("create")
    public Mono<String> create(Book book) {
        bookService.save(book);
        return Mono.create(monoSink -> monoSink.success("redirect:/book/getBookList"));
    }

}
