package org.example.dao;

import java.util.List;

public interface GenericDao<T, ID> {
    void create(T entity);

    T getById(ID id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();
}
