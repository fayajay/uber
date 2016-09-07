/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import uber.entity.Historique;

/**
 *
 * @author cherg
 */
public class HistoriqueDAO {
    
    public List<Historique> lister() {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    return em.createQuery("SELECT h FROM Historique h ").getResultList();
}
        
public void enregistrerHistorique (Historique h) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    em.getTransaction().begin();
    em.persist(h);
    em.getTransaction().commit();
    } 
    
}
