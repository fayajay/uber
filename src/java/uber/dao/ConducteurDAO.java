
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
    
    public Conducteur connexion(String login, String mdp) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Query query = em.createQuery("SELECT c FROM Conducteur u WHERE c.login=:monLogin AND c.mdp=:monMdp");

        query.setParameter("monLogin", login);
        query.setParameter("monMdp", mdp);

        return (Conducteur) query.getSingleResult();

    }
}
