
package uber.service;

import java.util.List;
import uber.dao.PassagerDAO;
import uber.entity.Passager;


public class PassagerService {
    
    public List<Passager> lister() {
        return new PassagerDAO().lister();
    }
    
    public Passager rechercherPassagerParId(long passagerId) {
        return new PassagerDAO().rechercherPassagerParId(passagerId);
    }
    
    public void enregistrerPassager(Passager p) {
        new PassagerDAO().enregistrerPassager(p);
    }
    
    public Passager connexion(String loginPassager, String mdpPassager) {
        PassagerDAO dao = new PassagerDAO();

        return dao.connexion(loginPassager, mdpPassager);
    }
    public  void modifierProfil(Passager p){
          new PassagerDAO().modifierProfil(p);
    }
}
