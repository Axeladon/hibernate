package org.example.dao;

import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetCrudService implements GenericDao<Planet, String> {
    private final Session session;
    public PlanetCrudService(Session session) {
        this.session = session;
    }

    @Override
    public void create(Planet planet) {
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
    }

    @Override
    public Planet getById(String id) {
        return session.find(Planet.class, id);
    }

    @Override
    public void update(Planet planet) {
        session.beginTransaction();
        session.merge(planet);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Planet planet) {
        session.beginTransaction();
        session.remove(planet);
        session.getTransaction().commit();
    }

    @Override
    public List getAll() {
        Query<Planet> query = session.createQuery("FROM Planet", Planet.class);
        return query.getResultList();
    }
}
