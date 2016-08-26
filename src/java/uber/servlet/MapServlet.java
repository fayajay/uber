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

        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
       // System.out.println(lconducteur);
        //out.print("[");
        //obj.put("tabConducteurs", "[");

        //obj.putAll((Map)lconducteur);
        String str = "[";

        for (Conducteur c : lconducteur) {
            str += "{";
            //out.print("{");
            //obj.put("", "{");
            //JSONObject obj = new JSONObject();

            /*obj.put("nom", c.getLoginConducteur());
            obj.put("immat", c.getImmatriculation());
            obj.put("lat", c.getLatitude());
            obj.put("lng", c.getLongitude());
            obj.put("nbplaces", c.getNbPlaces());
            obj.put("vehicule", c.getTypeVehicule());*/
            //*****JSON A LA MAIN *****
            str += "\"nom\":\"" + c.getLoginConducteur() + "\",";
            str += "\"immat\":\"" + c.getImmatriculation() + "\",";
            str += "\"lat\":\"" + c.getLatitude() + "\",";
            str += "\"lng\":\"" + c.getLongitude() + "\",";
            str += "\"nbplaces\":\"" + c.getNbPlaces() + "\",";
            str += "\"vehicule\":\"" + c.getTypeVehicule() + "\"";

            //StringWriter out = new StringWriter();
            //obj.writeJSONString(out);
            //out.print(c);
            //System.out.println("**********************************************");
            //System.out.println(obj);

            //obj.writeJSONString(out);
            str += "},";

            /*System.out.println("-----------------------------------------------");
            System.out.println(c.getLoginConducteur());
            System.out.println("-----------------------------------------------");
             */
            //obj.put("", "}");
            //out.print("}");
        }
        str = str.substring(0, str.length() - 1);
        str += "]";
        //out.print("]");

        //obj.put("", "]");
        //out.print(obj);
        out.print(str);
        System.out.println(str);

        //out.print("je te survivrais !");
        out.close();

        //System.out.println(out);
    }

}
