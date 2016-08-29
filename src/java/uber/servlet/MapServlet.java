package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
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
        PrintWriter out = resp.getWriter();
        List<Conducteur> lconducteur = new ConducteurService().lister();

        String str = "[";//début du tableau d'objets json

        for (Conducteur c : lconducteur) {
            str += "{";//nouvel objet json
            
            //*****JSON A LA MAIN *****
            str += "\"id\":\"" + c.getId() + "\",";
            str += "\"nom\":\"" + c.getLoginConducteur() + "\",";
            str += "\"immat\":\"" + c.getImmatriculation() + "\",";
            str += "\"lat\":\"" + c.getLatitude() + "\",";
            str += "\"lng\":\"" + c.getLongitude() + "\",";
            str += "\"nbplaces\":\"" + c.getNbPlaces() + "\",";
            str += "\"vehicule\":\"" + c.getTypeVehicule() + "\"";
            
            str += "},";//fin d'objet + virgule de séparation
        }
        str = str.substring(0, str.length() - 1); // on enleve la derniere virgule avant la fin du tableau
        str += "]";
        
        out.print(str);//envoi du tableau vers la jsp
        out.close();
    }

}
