package com.seungmoo.jpa3.post;

import com.seungmoo.jpa3.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * JpaRepository의 기능을 사용하면서, 동시에 PostCustomRepository (커스텀 Repository)의 기능도 사용!
 * 추가로 Querydsl도 적용해보자.
 */
public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post>, MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {
}
