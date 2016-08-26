
package uber.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import uber.entity.Conducteur;

public class ConducteurDAO {
    
    public List<Conducteur> lister() {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    return em.createQuery("SELECT c FROM Conducteur c").getResultList();
}
    
    public Conducteur rechercherConducteurParId(long conducteurId) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    return em.find(Conducteur.class, conducteurId);
    }
    
    public void enregistrerConducteur (Conducteur c) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    em.getTransaction().begin();
    em.persist(c);
    em.getTransaction().commit();
    }
    
    public Conducteur connexion(String loginConducteur, String mdpConducteur) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Query query = em.createQuery("SELECT c FROM Conducteur c WHERE c.loginConducteur=:monLogin AND c.mdpConducteur=:monMdp");

        query.setParameter("monLogin", loginConducteur);
        query.setParameter("monMdp", mdpConducteur);

        return (Conducteur) query.getSingleResult();
    }
    
    public List<Conducteur.TypeVehicule> listerVehicule() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT c.typeVehicule FROM Conducteur c ").getResultList();     
    }
}
