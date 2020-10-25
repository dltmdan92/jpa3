package com.seungmoo.jpa3.post;

import com.seungmoo.jpa3.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository의 기능을 사용하면서, 동시에 PostCustomRepository (커스텀 Repository)의 기능도 사용!
 */
public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post>, MyRepository<Post, Long> {
}
