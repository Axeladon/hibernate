package org.example.dao;

import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientCrudService implements GenericDao<Client, Long> {
    private final Session session;
    public ClientCrudService(Session session) {
        this.session = session;
    }

    @Override
    public void create(Client client) {
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
    }

    @Override
    public Client getById(Long id) {
        return session.find(Client.class, id);
    }

    @Override
    public void update(Client client) {
        session.beginTransaction();
        session.merge(client);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Client client) {
        session.beginTransaction();
        session.remove(client);
        session.getTransaction().commit();
    }

    @Override
    public List getAll() {
        Query<Client> query = session.createQuery("FROM Client", Client.class);
        return query.getResultList();
    }
}
