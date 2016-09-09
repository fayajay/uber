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
import uber.entity.Passager;
import uber.entity.Reservation;
import uber.service.PassagerService;
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
        Passager p;
        Reservation r = rs.rechercherReservationParConducteurId(c.getId());
        
                 
           
            
            p = new PassagerService().rechercherPassagerParId(r.getPassagerId());
            
            String str = "";//début du tableau d'objets json

            str += "{";//nouvel objet json

            //*****JSON A LA MAIN *****
            str += "\"id\":\"" + r.getId() + "\",";
            str += "\"nom\":\"" + p.getLoginPassager() + "\",";
            str += "\"adrArr\":\"" + r.getAdrArr() + "\",";
            str += "\"adrDep\":\"" + r.getAdrDep() + "\"";
            
            str += "}";//fin d'objet + virgule de séparation

            out.print(str);
       
            
        
        out.close();
    }
    
}
