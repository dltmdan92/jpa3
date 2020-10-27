package com.seungmoo.jpa3;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 모든 Repository에 공통적으로 적용되는 기본 repository customize해보자.
 * 이 Repository를 상속 받으면 어느 Repository에서도 사용이 가능하다.
 */
@NoRepositoryBean // 중간에 들어가능 Repository는 @NoRepositoryBean 선언해야 한다. (안 그러면 이것에 대해서 또한 Jpa 구현체 만들려고 함)
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    // entity가 persistent context에 들어있는지 없는지를 체크하는 custom method
    boolean contains(T entity);
}
