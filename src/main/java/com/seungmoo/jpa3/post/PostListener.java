package com.seungmoo.jpa3.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * 도메인 Event의 Listener
 * 별도 Bean 등록해줘야 한다.
 * BUT 이렇게 클래스를 만들기 보다는... Config class에서 메서드 Bean을 만들어주는게 훨씬 낫다. (클래스 만들어야 하는 불편)
 */
@Slf4j
public class PostListener implements ApplicationListener<PostPublishedEvent> {

    // 스프링의 Listener 등록 메소드 --> PostListener가 Bean으로 등록 후, @EventListener 셋팅
    // BUT!! @DataJpaTest는 slicing test 이기 때문에 일반 Bean으로 등록 시, Event 발생하지 않는다. (@Repository로 설정하면 되나 비추)
    //@EventListener
    @Override
    public void onApplicationEvent(PostPublishedEvent event) {
        log.info("----------------------");
        log.info(event.getPost().getTitle() + " is published!!");
        log.info("----------------------");
    }
}
