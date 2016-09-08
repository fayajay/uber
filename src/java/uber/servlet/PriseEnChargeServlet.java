package uber.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.entity.Conducteur;
import uber.entity.Historique;
import uber.entity.Passager;
import uber.entity.Reservation;
import uber.service.ConducteurService;
import uber.service.HistoriqueService;
import uber.service.PassagerService;
import uber.service.ReservationService;


@WebServlet(name = "PriseEnChargeServlet", urlPatterns = {"/prise_en_charge"})
public class PriseEnChargeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        long idConducteur = Long.parseLong( req.getParameter("idConducteur") );
        
        Conducteur c = new ConducteurService().rechercherConducteurParId(idConducteur);
        float tarif = c.getPrixAuKm();
        float dist = Float.parseFloat((String) req.getSession().getAttribute("distance"));
        String adrDepart = (String) req.getSession().getAttribute("adrDep");
        String adrArrivee = (String) req.getSession().getAttribute("adrArr");
        
        req.getSession().setAttribute("idConducteur", idConducteur);
        req.setAttribute("nomConducteur", c.getLoginConducteur());
        
        // calcul total
        tarif = tarif * dist/1000;
        req.setAttribute("total", tarif);
        
        req.setAttribute("adrArr", adrArrivee);
        req.setAttribute("adrDep", adrDepart);
        
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
        h.setConducteur(new ConducteurService().rechercherConducteurParId((long) req.getSession().getAttribute("idConducteur")));
        h.setPassager((Passager) req.getSession().getAttribute("utilConnecteP"));
        
        
        HistoriqueService hs = new HistoriqueService();      
        hs.enregistrerHistorique(h);
        
        Reservation r = new Reservation();
        r.setAdrArr(h.getArrivee());
        r.setAdrDep(h.getDepart());
        r.setConducteurId(h.getConducteur().getId());
        r.setPassagerId(h.getPassager().getId());
        
        ReservationService rs = new ReservationService();
        rs.enregistrerReservation(r);
        
        
        
        resp.sendRedirect("paiement");
    }
}
