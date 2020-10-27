package com.seungmoo.jpa3.post;

import org.springframework.context.ApplicationEvent;

/**
 * 도메인 이벤트 (스프링의 기능, JPA ㄴㄴ)
 */
public class PostPublishedEvent extends ApplicationEvent {
    private final Post post;

    public PostPublishedEvent(Object source) {
        super(source);
        this.post = (Post) source;
    }

    public Post getPost() {
        return post;
    }
}
