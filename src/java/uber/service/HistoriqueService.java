/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.service;

import java.util.List;
import uber.dao.HistoriqueDAO;
import uber.entity.Historique;

/**
 *
 * @author cherg
 */
public class HistoriqueService {
    public List<Historique> listerParPassagerId(long id) {
        return new HistoriqueDAO().listerParPassagerId(id);
    }
    
    public void enregistrerHistorique(Historique h) {
        new HistoriqueDAO().enregistrerHistorique(h);
    }
    
}
