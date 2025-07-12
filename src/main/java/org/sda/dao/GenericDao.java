package org.sda.dao;

import java.util.List;

public interface GenericDao<T> {
    public  void save(T t);

    public  T getById(Long id);

    public  List<T> getAll();

    public  void merge(T t);

    public  void delete(Long id);
}
