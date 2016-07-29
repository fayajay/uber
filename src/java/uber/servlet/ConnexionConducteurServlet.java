
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
        
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");
        
        Conducteur c = new ConducteurService().connexion(login, mdp);
        
        // je suis logué correctement = session
        req.getSession().setAttribute("utilConnecte", c);
        
        
        resp.sendRedirect("map");
 
    }
}
