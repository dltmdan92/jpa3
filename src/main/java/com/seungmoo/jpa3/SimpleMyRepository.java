package com.seungmoo.jpa3;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 이거는 naming-rule이 없다.
 *
 * SimpleJpaRepository : JpaRepository의 구현 클래스
 *  Custom Repository의 구현클래스는 SimpleJpaRepository를 상속받게 된다.
 */
public class SimpleMyRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

    private EntityManager entityManager;

    public SimpleMyRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        // entityManager를 통해 persistent context에 있는지 없는지를 체크한다.
        return entityManager.contains(entity);
    }
}
