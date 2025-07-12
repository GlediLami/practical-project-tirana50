package org.sda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sda.assembler.ForecastAssembler;
import org.sda.dto.forecast.ForecastCityDto;
import org.sda.entity.Forecast;
import org.sda.service.ForecastService;

import java.util.List;

public class ForecastDao implements GenericDao<Forecast> {

    private Session session;

    public ForecastDao() {
        session = new Configuration()
                .configure()
                .addAnnotatedClass(Forecast.class)
                .buildSessionFactory()
                .openSession();
    }

    @Override
    public void save(Forecast forecast) {
        Transaction transaction = session.beginTransaction();
        session.persist(forecast);  // Hibernate's save operation
        transaction.commit();
    }

    @Override
    public Forecast getById(Long id) {
        return session.get(Forecast.class, id);
    }

    @Override
    public List<Forecast> getAll() {
        return session.createQuery("FROM Forecast", Forecast.class).list();
    }

    @Override
    public void merge(Forecast forecast) {
        Transaction transaction = session.beginTransaction();
        session.merge(forecast); // Hibernate's update operation
        transaction.commit();
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();
        Forecast forecast = session.get(Forecast.class, id);
        if (forecast != null) {
            session.remove(forecast);
        }
        transaction.commit();
    }

    public void close() {
        session.close();
    }

    public static void main(String[] args) {
        ForecastService forecastService = new ForecastService();
        ForecastAssembler assembler = new ForecastAssembler();
        ForecastDao forecastDao = new ForecastDao();

        ForecastCityDto cityDto = forecastService.getForecastForOneDay("4553");
        Forecast forecast = assembler.assemble(cityDto);

        forecastDao.save(forecast);

        System.out.println(forecast);
    }
}
