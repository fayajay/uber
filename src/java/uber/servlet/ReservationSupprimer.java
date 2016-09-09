/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.entity.Conducteur;
import uber.entity.Reservation;
import uber.service.ReservationService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ReservationSupprimer", urlPatterns = {"/suppr_res"})
public class ReservationSupprimer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ReservationService rs = new ReservationService();
        Conducteur c = (Conducteur) req.getSession().getAttribute("utilConnecteC");
        rs.supprimerReservationByConducteurId(c.getId());
    }
    
}
