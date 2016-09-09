
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
import uber.service.ConducteurService;
import uber.service.ReservationService;


@WebServlet(name = "ConnexionConducteurServlet", urlPatterns = {"/connexion_conducteur"})
public class ConnexionConducteurServlet extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("connexionConducteur.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String loginConducteur = req.getParameter("loginConducteur");
        String mdpConducteur = req.getParameter("mdpConducteur");
        
        Conducteur c = new ConducteurService().connexion(loginConducteur, mdpConducteur);
        
        // je suis logué correctement = session
        req.getSession().setAttribute("utilConnecteC", c);
        
        
        //supprimer les éventuelles réservations précédentes
        ReservationService rs = new ReservationService();        
        rs.supprimerReservationByConducteurId(c.getId());
        
        
        resp.sendRedirect("attente");
 
    }
}
