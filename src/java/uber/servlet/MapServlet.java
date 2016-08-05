package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.service.ConducteurService;

@WebServlet(name = "MapServlet", urlPatterns = {"/map"})
public class MapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.setAttribute("lchauffeur", new ConducteurService().lister());
        
        //req.setAttribute("chauffeur1", new ConducteurService().rechercherConducteurParId(2));

        req.getRequestDispatcher("map.jsp").forward(req, resp);
    }

}
