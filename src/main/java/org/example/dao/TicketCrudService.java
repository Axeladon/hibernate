package org.example.dao;

import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class TicketCrudService implements GenericDao<Ticket, Long> {
    private final Session session;
    public TicketCrudService(Session session) {
        this.session = session;
    }

    @Override
    public void create(Ticket ticket) {
        Transaction transaction = session.beginTransaction();
        session.persist(ticket);
        transaction.commit();
    }

    @Override
    public Ticket getById(Long id) {
        return session.find(Ticket.class, id);
    }

    @Override
    public void update(Ticket ticket) {
        session.beginTransaction();
        session.merge(ticket);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Ticket ticket) {
        session.beginTransaction();
        session.remove(ticket);
        session.getTransaction().commit();
    }

    @Override
    public List getAll() {
        Query<Ticket> query = session.createQuery("FROM Ticket", Ticket.class);
        return query.getResultList();
    }
}
