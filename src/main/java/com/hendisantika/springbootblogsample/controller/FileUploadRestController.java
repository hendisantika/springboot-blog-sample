package com.hendisantika.springbootblogsample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * Create a directory to store upload files
     *
     * @param filePath
     * @return
     */
    private File mkdirs(StringBuffer filePath) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        File uploadDir = new File(filePath.toString(), sdf.format(now));
        // Add a prefix if it already exists
        int prefix = 0;
        while (uploadDir.exists()) {
            prefix++;
            uploadDir =
                    new File(filePath.toString() + sdf.format(now) + "-" + prefix);

        }

        // Create folder
        uploadDir.mkdirs();

        return uploadDir;
    }
}
