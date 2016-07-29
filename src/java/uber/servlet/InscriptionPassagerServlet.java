
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


@WebServlet(name = "InscriptionPassagerServlet", urlPatterns = {"/inscription_passager"})
public class InscriptionPassagerServlet extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("inscriptionPassager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Passager p = new Passager();
        
        p.setLoginPassager(req.getParameter("login"));
        p.setMdpPassager(req.getParameter("mdp"));
        p.setMailPassager(req.getParameter("email"));
        p.setTelPassager(req.getParameter("tel"));
        
        PassagerService ps = new PassagerService();
        
        ps.enregistrerPassager(p);
        
        resp.sendRedirect("connexion_passager");
    }
}
