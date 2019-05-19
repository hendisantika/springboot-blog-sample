package com.hendisantika.springbootblogsample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
     * Do bulk upload
     *
     * @param multipartFile
     * @param fileType
     * @return
     */
    @PostMapping
    public Object postData(
            @RequestParam("upload_file") MultipartFile multipartFile,
            @RequestParam("filetype") String fileType) {

        logger.info("fileType1 : " + fileType);
        try {
            logger.info("fileType2 : " + URLDecoder.decode(fileType, "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            // TODO Automatically generated catch block
            e1.printStackTrace();
        }


        // Abnormal termination if file is empty
        if (multipartFile.isEmpty()) {
            // Abnormal termination processing
        }

        // Set the value determined from the file type
        StringBuffer filePath = new StringBuffer("/uploadfile");   //File Path

        // Create a directory to store upload files
        File uploadDir = mkdirs(filePath);

        try {
            // Put upload file
            File uploadFile =
                    new File(uploadDir.getPath() + "/" + fileType);
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream uploadFileStream =
                    new BufferedOutputStream(new FileOutputStream(uploadFile));
            uploadFileStream.write(bytes);
            uploadFileStream.close();

            return "You successfully uploaded.";
        } catch (Exception e) {
            return "error!";
        } catch (Throwable t) {
            return "error!";
        }
    }

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
