package org.sda.dao;

import java.util.List;

public interface GenericDao {
    public <T> void save(T t);

    public <T> T getById(Long id);

    public <T> List<T> getAll();

    public <T> void merge(T t);

    public <T> void delete(Long id);
}
