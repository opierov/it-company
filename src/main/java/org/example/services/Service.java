package org.example.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    void add(T entity);
    Optional<T> getById(Long id);
    List<T> getAll();
    void update(T entity);
    void delete(Long id);

}