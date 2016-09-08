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
import uber.service.ReservationService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AttenteServlet", urlPatterns = {"/attente"})
public class AttenteServlet extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
          try {
              Conducteur c = (Conducteur) req.getSession().getAttribute("utilConnecteC");
              System.out.println("/*********************");
              System.out.println(new ReservationService().rechercherReservationParConducteurId(c.getId()));
              
              Thread.sleep(10000);
          } catch (InterruptedException ex) {
              Logger.getLogger(AttenteServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        req.getRequestDispatcher("attente.jsp").forward(req, resp);
    }
}
