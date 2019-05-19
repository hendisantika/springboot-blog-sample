package com.hendisantika.springbootblogsample.repository;

import com.hendisantika.springbootblogsample.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-blog-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-05-19
 * Time: 10:55
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}