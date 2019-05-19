package com.hendisantika.springbootblogsample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-blog-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-19
 * Time: 11:49
 */
@RestController
@RequestMapping("file/upload")
public class FileUploadRestController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadRestController.class);
}
