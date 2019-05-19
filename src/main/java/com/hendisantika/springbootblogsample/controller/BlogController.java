package com.hendisantika.springbootblogsample.controller;

import com.hendisantika.springbootblogsample.domain.Blog;
import com.hendisantika.springbootblogsample.domain.BlogForm;
import com.hendisantika.springbootblogsample.repository.BlogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Optional;

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

    private static Logger logger = LogManager.getLogger(BlogController.class);

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

    // Get Data
    @GetMapping(value = "/edit/{id}")
    public String editData(Model model, @PathVariable int id) {

        Optional<Blog> blogData = blogRepository.findById(id);

        Blog blog = blogData.get();

        BlogForm blogForm = new BlogForm();

        blogForm.setBlogId(blog.getBlogId());
        blogForm.setTitle(blog.getTitle());
        blogForm.setContents(blog.getContents());
        blogForm.setPostDate(blog.getPostDate());

        model.addAttribute("blogForm", blogForm);

        return "edit";

    }

    //Delete Data
    @PostMapping(value = "/edit", params = "delete")
    public String delete(Model model, BlogForm blogform) {


        blogRepository.deleteById(blogform.getBlogId());

        return "redirect:/";

    }

    //Preservation
    @PostMapping(value = "/edit", params = "edit")
    public String editPost(@Validated BlogForm blogform, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            //In case of an error, the reservation screen remains

            logger.info("It is an error");

            return "edit";
        }

        logger.info("Not an error");


        Blog blog = new Blog();

        blog.setBlogId(blogform.getBlogId());
        blog.setTitle(blogform.getTitle());
        blog.setContents(blogform.getContents());
        blog.setPostDate(blogform.getPostDate());

        blogRepository.save(blog);

        //model.addAttribute("blogForm", blogForm);

        return "redirect:/";

    }
}
