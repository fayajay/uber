package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import uber.entity.Conducteur;
import uber.service.ConducteurService;

@WebServlet(name = "MapServlet", urlPatterns = {"/map"})
public class MapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.setAttribute("lchauffeur", new ConducteurService().lister());
        //req.setAttribute("chauffeur1", new ConducteurService().rechercherConducteurParId(2));
        req.getRequestDispatcher("map.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Conducteur> lconducteur = new ConducteurService().lister();

        //out.print(lconducteur);
        //out.print("[");
        for (Conducteur c : lconducteur) {
            PrintWriter out = resp.getWriter();
            JSONObject obj = new JSONObject();

            obj.put("nom", c.getLoginConducteur());
            obj.put("immat", c.getImmatriculation());
            obj.put("lat", c.getLatitude());
            obj.put("lng", c.getLongitude());
            obj.put("nbplaces", c.getNbPlaces());
            obj.put("vehicule", c.getTypeVehicule());

            //StringWriter out = new StringWriter();
            //obj.writeJSONString(out);
            //out.print(c);
            System.out.println("**********************************************");
            System.out.println(obj);

            out.print(obj);
            out.close();
        }
        //out.print("]");

        //System.out.println(out);
    }

}
