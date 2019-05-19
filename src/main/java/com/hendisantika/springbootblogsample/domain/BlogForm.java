package com.hendisantika.springbootblogsample.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-blog-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-19
 * Time: 10:53
 */
@Data
public class BlogForm implements Serializable {

    private Integer blogId;

    @NotBlank(message = "Title Required")
    private String title;

    @NotBlank(message = "Content Required")
    private String contents;

    @NotNull(message = "Post Date Required")
    @DateTimeFormat(pattern = "yyyy/M/d")
    private LocalDate postDate;


}
