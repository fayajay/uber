/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.service;

import java.util.List;
import uber.dao.ReservationDAO;
import uber.entity.Reservation;

/**
 *
 * @author admin
 */
public class ReservationService {
    
    public List<Reservation> lister() {
        
        return new ReservationDAO().lister();
    }

    public Reservation rechercherReservationParPassagerId(long passagerId) {
        
        return new ReservationDAO().rechercherReservationParPassagerId(passagerId);
    }

    public Reservation rechercherReservationParConducteurId(long conducteurId) {
        return new ReservationDAO().rechercherReservationParConducteurId(conducteurId);
    }

    public void supprimerReservation(Reservation r) {
        new ReservationDAO().supprimerReservation(r);
    }
    
    public void supprimerReservationByConducteurId(long id){
        new ReservationDAO().supprimerReservationByConducteurId(id);
    }

    public Reservation getReservationById(long id) {
        return new ReservationDAO().getReservationById(id);
    }

    public void enregistrerReservation(Reservation r) {
        new ReservationDAO().enregistrerReservation(r);
    }

    public void modifierReservation(Reservation r) {
        new ReservationDAO().modifierReservation(r);
    }
    
}
