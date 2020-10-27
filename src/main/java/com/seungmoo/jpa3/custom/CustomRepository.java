package com.seungmoo.jpa3.custom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    boolean contains(T entity);
}
