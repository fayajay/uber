
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
        
        
        resp.sendRedirect("attente");
 
    }
}
