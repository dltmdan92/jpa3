package com.seungmoo.jpa3.post;

import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PostRepositoryTestConfig {
    /*
    @Bean
    public PostListener postListener() {
        return new PostListener();
    }
     */

    // 위의 방식 대신, 그냥 메소드 Bean을 만들어보자
    // 굳이 클래스를 안만들어도 되는 편리함
    @Bean
    public ApplicationListener<PostPublishedEvent> postListener() {
        return event -> {
            log.info("----------------------");
            log.info(event.getPost().getTitle() + " is published!!");
            log.info("----------------------");
        };
    }

}
