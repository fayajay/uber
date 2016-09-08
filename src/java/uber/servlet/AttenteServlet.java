/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AttenteServlet", urlPatterns = {"/attente"})
public class AttenteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
        req.getRequestDispatcher("attente.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();        
        ReservationService rs = new ReservationService();
        Conducteur c = (Conducteur) req.getSession().getAttribute("utilConnecteC");
        Reservation r;
        
        System.out.println("/**************");
        System.out.println(rs.rechercherReservationParConducteurId(c.getId()));
        while(rs.rechercherReservationParConducteurId(c.getId()).getConducteurId() != c.getId()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AttenteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        r = rs.rechercherReservationParConducteurId(c.getId());
        
        out.print(r);
        out.close();
    }
    
    
}
