package top.imyzt.webflux.demo7.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author imyzt
 * @date 2019/2/19 15:39
 * @description Book
 */
@Data
public class Book {

    @Id
    private Long id;

    private String bookName;

    private String author;

    private String bookType;

    private Long price;

    private String description;

}
