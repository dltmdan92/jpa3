package com.seungmoo.jpa3.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crud() {
        //postRepository.findMyPost();
        Post post = new Post();
        post.setTitle("hibernate");

        // 이렇게 하면 insert, delete 쿼리 안실행 됨
        // 로그가 찍히는 거로 봐서 jpa method는 수행되긴 한다.
        // BUT JPA에서 DML을 DB에 굳이 호출하지 않는다.
        postRepository.save(post);
        postRepository.delete(post);
    }

    @Test
    public void crud2() {
        Post post = new Post();
        post.setTitle("hibernate");

        // Transient 상태(JPA에서 미추적) 이므로 False
        assertThat(postRepository.contains(post)).isFalse();

        postRepository.save(post);
        // Persistent 상태(JPA에서 추적 중) 이므로 True
        assertThat(postRepository.contains(post)).isTrue();
        postRepository.findMyPost();
        // 이렇게 하면 save(INSERT)는 실행이 된다. (findMyPost 때문에)

        // 하지만 delete(DELETE) DML은 실행하지 않는다. (Transaction의 롤백 정책 때문에)
        postRepository.delete(post);
        postRepository.flush(); // flush()로 강제로 JPA가 DML을 실행시키게 할 수 있다.
    }
}