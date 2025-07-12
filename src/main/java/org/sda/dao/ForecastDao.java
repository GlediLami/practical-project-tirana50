package org.sda.dao;

import org.sda.entity.Forecast;

import java.util.List;

public class ForecastDao implements GenericDao<Forecast> {
    @Override
    public void save(Forecast forecast) {

    }

    @Override
    public Forecast getById(Long id) {
        return null;
    }

    @Override
    public List<Forecast> getAll() {
        return List.of();
    }

    @Override
    public void merge(Forecast forecast) {

    }

    @Override
    public void delete(Long id) {

    }
}
