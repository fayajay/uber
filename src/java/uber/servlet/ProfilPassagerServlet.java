/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.entity.Historique;
import uber.entity.Passager;
import uber.service.HistoriqueService;
import uber.service.PassagerService;


/**
 *
 * @author cherg
 */
@WebServlet(name = "ProfilPassagerServlet", urlPatterns = {"/modifier_profil"})
public class ProfilPassagerServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1 je recup les id passager en sission web
        
        Passager p = (Passager) request.getSession().getAttribute("utilConnecte");
        
        
        HistoriqueService hs = new HistoriqueService();
        List<Historique> historique = hs.lister();
        
        request.setAttribute("historique", historique);
        
        
        request.getRequestDispatcher("modifier_profil.jsp").forward(request, response);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //merge en base 
        Passager pInit =(Passager) request.getSession().getAttribute("utilConnecteP");
        
        Passager p = new Passager();
        p.setId(pInit.getId());
        p.setLoginPassager(request.getParameter("login"));
        p.setMdpPassager(request.getParameter("mdp"));
        p.setMailPassager(request.getParameter("email"));
        p.setTelPassager(request.getParameter("tel"));
        
        PassagerService ps = new PassagerService();
        
        ps.modifierProfil(p);
        
        //mise a jour de la session
        request.getSession().setAttribute("utilConnecteP", p);
        
        response.sendRedirect("map");
        
    }


}
