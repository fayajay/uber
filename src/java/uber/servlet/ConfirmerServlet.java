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
import uber.entity.Passager;
import uber.entity.Reservation;
import uber.service.ReservationService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ConfirmerServlet", urlPatterns = {"/confirmer"})
public class ConfirmerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ReservationService rs = new ReservationService();
        Passager p = (Passager) req.getSession().getAttribute("utilConnecteP");

        Reservation r = rs.rechercherReservationParPassagerId(p.getId());
        r.setEtat(true);
        rs.modifierReservation(r);
    }

}
