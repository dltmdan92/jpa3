package com.seungmoo.jpa3.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Custom Repository의 구현체는 Naming-Convention이 존재
 * interface 뒤에 Impl을 붙여 준다.
 * 커스텀 메소드를 구현해서 SpringData Repository에 기능을 추가하거나
 * SpringData Repository의 기본 기능을 Override한다.
 */
@Slf4j
@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository {

    @Autowired
    EntityManager entityManager;

    /**
     * JPA 커스텀 메소드를 구현해보자.
     * @return
     */
    @Override
    public List<Post> findMyPost() {
        log.info("custom findMyPost");
        return entityManager.createQuery("SELECT p FROM Post AS p", Post.class)
                .getResultList();
    }

    // Custom 구현체가 우선 순위를 갖는다.
    @Override
    public void delete(Object entity) {
        log.info("custom delete");
        entityManager.remove(entity); // 본 예제에서는 SpringData JPA에서 삭제하는 것과 동일하게 구현했음
    }
}
