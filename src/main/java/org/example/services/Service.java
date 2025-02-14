package org.example.services;

import java.util.List;

public interface Service<T> {
    void add(T entity);
    T getById(Long id);
    List<T> getAll();
    void update(T entity);
    void delete(Long id);
}
