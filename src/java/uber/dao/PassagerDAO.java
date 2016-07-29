
package uber.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import uber.entity.Passager;

public class PassagerDAO {
    
    public List<Passager> lister() {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    return em.createQuery("SELECT p FROM Passager p").getResultList();
}
    
    public Passager rechercherPassagerParId(long passagerId) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    return em.find(Passager.class, passagerId);
    }
    
    public void enregistrerPassager (Passager p) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
    } 
    
    public Passager connexion(String login, String mdp) {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Query query = em.createQuery("SELECT p FROM Passager p WHERE p.login=:monLogin AND p.mdp=:monMdp");

        query.setParameter("monLogin", login);
        query.setParameter("monMdp", mdp);

        return (Passager) query.getSingleResult();

    }
}
