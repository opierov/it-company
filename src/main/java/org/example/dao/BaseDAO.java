package org.example.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    void insert(T entity);
    Optional<T> getById(Long id);
    List<T> getAll();
    void update(T entity);
    void delete(Long id);

}