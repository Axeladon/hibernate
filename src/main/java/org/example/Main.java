package org.example;

import org.example.dao.ClientCrudService;
import org.example.dao.PlanetCrudService;
import org.example.dao.TicketCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.utils.GenericValidator;
import org.example.utils.HibernateUtils;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource(
                "jdbc:h2:./test",
                "admin",
                "admin"
        ).load();
        flyway.migrate();

        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            //ClientCrudService ccs = new ClientCrudService(session);
            //createClient(ccs, "John Galt4");
            //System.out.println(getClient(ccs, 11L).toString());
            //updateClient(ccs, 11L, "Updated client");
            //deleteClient(ccs, getClientById(ccs, 11L));
            //System.out.println(ccs.getAll().toString());

            //PlanetCrudService pcs = new PlanetCrudService(session);
            //createPlanet(pcs, "V52D", "Pandora");
            //System.out.println(getPlanetById(pcs, "B2").toString());
            //updatePlanet(pcs, "V52D", "New Name");
            //deletePlanet(pcs, getPlanetById(pcs, "V52D"));
            //System.out.println(pcs.getAll().toString());

            //TicketCrudService tcs = new TicketCrudService(session);
            //createTicket(session);
            //System.out.println(tcs.getById(11L).toString());
            //updateTicket(session, 12L, "B2");
            //tcs.delete(tcs.getById(11L));
            //System.out.println(tcs.getAll().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createClient(ClientCrudService ccs, String name) {
        Client newClient = new Client();
        newClient.setName(name);

        List<String> errors = new GenericValidator().validate(newClient);
        if (errors.isEmpty()) {
            ccs.create(newClient);
        } else {
            System.out.println(errors);
        }
    }

    private static Client getClientById(ClientCrudService ccs, Long id) {
        return ccs.getById(id);
    }

    private static void updateClient(ClientCrudService ccs, Long id, String name) {
        Client updateClient = new Client();
        updateClient.setId(id);
        updateClient.setName(name);

        List<String> errors = new GenericValidator().validate(updateClient);
        if (errors.isEmpty()) {
            ccs.update(updateClient);
        } else {
            System.out.println(errors);
        }
    }

    private static void deleteClient(ClientCrudService ccs, Client client) {
        ccs.delete(client);
    }

    public static void createPlanet(PlanetCrudService pcs, String id, String name) {
        Planet newPlanet = new Planet();
        newPlanet.setId(id);
        newPlanet.setName(name);

        List<String> errors = new GenericValidator().validate(newPlanet);
        if (errors.isEmpty()) {
            pcs.create(newPlanet);
        } else {
            System.out.println(errors);
        }
    }

    private static Planet getPlanetById(PlanetCrudService pcs, String id) {
        return pcs.getById(id);
    }

    private static void updatePlanet(PlanetCrudService pcs, String id, String name) {
        Planet updatePlanet = new Planet();
        updatePlanet.setId(id);
        updatePlanet.setName(name);

        List<String> errors = new GenericValidator().validate(updatePlanet);
        if (errors.isEmpty()) {
            pcs.update(updatePlanet);
        } else {
            System.out.println(errors);
        }
    }

    private static void deletePlanet(PlanetCrudService pcs, Planet planet) {
        pcs.delete(planet);
    }

    public static void createTicket(Session session) {
        TicketCrudService tcs = new TicketCrudService(session);
        ClientCrudService ccs = new ClientCrudService(session);
        PlanetCrudService pcs = new PlanetCrudService(session);

        Ticket newTicket = new Ticket();
        newTicket.setClient(ccs.getById(1L));
        newTicket.setFromPlanet(pcs.getById("C3"));
        newTicket.setToPlanet(pcs.getById("A1"));

        List<String> errors = new GenericValidator().validate(newTicket);
        if (errors.isEmpty()) {
            tcs.create(newTicket);
        } else {
            System.out.println(errors);
        }
    }

    public static void updateTicket(Session session, Long id, String toPlanetId) {
        TicketCrudService tcs = new TicketCrudService(session);
        PlanetCrudService pcs = new PlanetCrudService(session);
        Ticket updateTicked = tcs.getById(id);
        updateTicked.setToPlanet(pcs.getById(toPlanetId));

        List<String> errors = new GenericValidator().validate(updateTicked);
        if (errors.isEmpty()) {
            tcs.create(updateTicked);
        } else {
            System.out.println(errors);
        }
    }
}


