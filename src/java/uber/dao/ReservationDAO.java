/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import uber.entity.Reservation;

/**
 *
 * @author admin
 */
public class ReservationDAO {

    public List<Reservation> lister() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT r FROM Reservation r").getResultList();
    }

    public Reservation rechercherReservationParPassagerId(long passagerId) {
        long tmp = passagerId;
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return (Reservation) em.createQuery("SELECT r FROM Reservation r WHERE r.passagerId=:tmp").getSingleResult();
    }

    public Reservation rechercherReservationParConducteurId(long conducteurId) {
        long tmp = conducteurId;
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return (Reservation) em.createQuery("SELECT r FROM Reservation r WHERE r.conducteurId=:tmp").setParameter("tmp", tmp).getSingleResult();
    }

    public void supprimerReservation(Reservation r) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.remove(r);        
        em.getTransaction().commit();
    }
    
    public void supprimerReservationByConducteurId(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.createQuery("DELETE FROM Reservation r WHERE r.conducteurId=:id").setParameter("id", id);        
    }

    public Reservation getReservationById(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Reservation.class, id);
    }

    public void enregistrerReservation(Reservation r) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
    }

    public void modifierReservation(Reservation r) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();

    }
}
