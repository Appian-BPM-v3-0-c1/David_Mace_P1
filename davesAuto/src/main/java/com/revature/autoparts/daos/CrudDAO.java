package com.revature.autoparts.daos;

import com.revature.autoparts.models.Item;

import java.util.List;

public interface CrudDAO <T> {
    int save(T obj);

    List<T> findAll();

    T findById(int id);

    List<T> findAllById();

    boolean update(T updatedObj);

    boolean removeById(int id);
}
