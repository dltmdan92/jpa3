package com.seungmoo.jpa3.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

/**
 * AbstractAggregateRoot --> '스프링 데이터'의 Event Publisher 클래스
 */
@Entity
@Getter
@Setter
public class Post extends AbstractAggregateRoot<Post> {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    public Post publish() {
        // registerEvent : 이벤트 등록
        this.registerEvent(new PostPublishedEvent(this));
        return this;
    }
}
