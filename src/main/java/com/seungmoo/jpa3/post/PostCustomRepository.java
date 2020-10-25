package com.seungmoo.jpa3.post;

import java.util.List;

/**
 * 커스텀 리포지토리를 만들어보자
 * PostCustomRepositoryImpl 클래스로 구현
 * Impl은 default naming-rule이다.
 * @param <T>
 */
public interface PostCustomRepository<T> {
    List<Post> findMyPost();

    /**
     * Custom 구현체가 우선 순위를 갖는다.
     * @param entity
     */
    void delete(T entity);
}
