
package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.entity.Conducteur;
import uber.service.ConducteurService;

@WebServlet(name = "InscriptionConducteurServlet", urlPatterns = {"/inscription_conducteur"})
public class InscriptionConducteurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("inscriptionConducteur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Conducteur c = new Conducteur();
        
        c.setLoginConducteur(req.getParameter("loginConducteur"));
        c.setMdpConducteur(req.getParameter("mdpConducteur"));
        c.setMailConducteur(req.getParameter("emailConducteur"));
        c.setTelConducteur(req.getParameter("telConducteur"));
        c.setImmatriculation(req.getParameter("immatConducteur"));
        c.setPrixAuKm(Float.parseFloat(req.getParameter("prixAuKm")));
        c.setVehicule(req.getParameter("vehicule"));
        c.setNbPlaces(Integer.parseInt (req.getParameter("nbPlaces")));
        
        ConducteurService cs = new ConducteurService();
        
        cs.enregistrerConducteur(c);
        
        resp.sendRedirect("connexion_conducteur");
    }
}
