package uber.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.entity.Historique;
import uber.service.HistoriqueService;


@WebServlet(name = "PriseEnChargeServlet", urlPatterns = {"/prise_en_charge"})
public class PriseEnChargeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        long idConducteur = Long.parseLong( req.getParameter("idConducteur") );
        String nomConducteur = req.getParameter("nomConducteur") ;
        req.setAttribute("idConducteur", idConducteur);
        req.setAttribute("nomConducteur", nomConducteur);
        
        req.getRequestDispatcher("priseEnCharge.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        Historique h = new Historique();
        
        
        h.setDepart(req.getParameter("depart"));
        h.setArrivee(req.getParameter("arrivee"));
        h.setPrix(Float.parseFloat (req.getParameter("prix")));
        h.setNbPassager(Integer.parseInt (req.getParameter("nbPassager")));
        h.setModePaiement(req.getParameter("modePaiement"));
        
        HistoriqueService hs = new HistoriqueService(); 
        
        hs.enregistrerHistorique(h);
        
        resp.sendRedirect("paiement");
    }
}
