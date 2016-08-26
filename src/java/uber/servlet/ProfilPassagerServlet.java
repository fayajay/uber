/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        
        //2- appel le service pour recup passager apartir de l ID
        
        //3 ajouter un atribut de requet avec cette passager
        
        
        request.getRequestDispatcher("modifier_profil.jsp").forward(request, response);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Passager p = new Passager();
        p.setLoginPassager(request.getParameter("loginPassager"));
        p.setMdpPassager(request.getParameter("mdpPassager"));
        p.setMailPassager(request.getParameter("emailPassager"));
        p.setTelPassager(request.getParameter("telPassager"));
        
        PassagerService ps = new PassagerService();
        
        ps.modifierProfil(p);
        
        response.sendRedirect("map");
        
    }


}
