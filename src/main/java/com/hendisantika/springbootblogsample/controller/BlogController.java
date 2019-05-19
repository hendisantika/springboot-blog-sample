package com.hendisantika.springbootblogsample.controller;

import com.hendisantika.springbootblogsample.domain.BlogForm;
import com.hendisantika.springbootblogsample.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

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

    //Create New Post
    @GetMapping("/edit")
    public String editNew(Model model) {

        BlogForm blogForm = new BlogForm();

        blogForm.setBlogId(0);
        blogForm.setPostDate(LocalDate.now());

        model.addAttribute("blogForm", blogForm);

        return "edit";

    }
}
