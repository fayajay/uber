
package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.entity.Passager;
import uber.service.PassagerService;


@WebServlet(name = "ConnexionPassagerServlet", urlPatterns = {"/connexion_passager"})
public class ConnexionPassagerServlet extends HttpServlet {


        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("connexionPassager.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");
        
        Passager p = new PassagerService().connexion(login, mdp);
        
        // je suis logué correctement = session
        req.getSession().setAttribute("utilConnecte", p);
        
        
        resp.sendRedirect("map");
 
    }
}
