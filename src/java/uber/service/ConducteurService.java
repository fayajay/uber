
package uber.service;

import java.util.List;
import uber.dao.ConducteurDAO;
import uber.entity.Conducteur;


public class ConducteurService {
    
    public List<Conducteur> lister() {
        return new ConducteurDAO().lister();
    }
    
    public Conducteur rechercherConducteurParId(long conducteurId) {
        return new ConducteurDAO().rechercherConducteurParId(conducteurId);
    }
    
    public void enregistrerConducteur(Conducteur c) {
        new ConducteurDAO().enregistrerConducteur(c);
    }

    public Conducteur connexion(String login, String mdp) {
                ConducteurDAO dao = new ConducteurDAO();

        return dao.connexion(login, mdp);
    }
    
}
