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
import uber.service.PassagerService;
import uber.service.ReservationService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AttentePassagerServlet", urlPatterns = {"/attenteP"})
public class AttentePassagerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ReservationService rs = new ReservationService();
        Passager p = (Passager) req.getSession().getAttribute("utilConnecteP");
        
        Reservation r = rs.rechercherReservationParPassagerId(p.getId());
        
        if(r.isEtat()==true){
             String str = "";//début du tableau d'objets json

            str += "{";//nouvel objet json

            //*****JSON A LA MAIN *****
            str += "\"id\":\"" + r.getId() + "\",";
            str += "\"statut\":\"" + r.isEtat() + "\"";
            
            str += "}";//fin d'objet + virgule de séparation

            out.print(str);
        }
            
           
       
            
        
        out.close();
    }
    
}
