package com.hendisantika.springbootblogsample.controller;

import com.hendisantika.springbootblogsample.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-blog-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-19
 * Time: 11:41
 */
@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

}
