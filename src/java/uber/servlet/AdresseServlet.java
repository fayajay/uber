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

/**
 *
 * On passe les adresses et le prix pour stocker temporariement sur le serveur car les cookies ne prennent pas d'espaces
 */
@WebServlet(name = "AdresseServlet", urlPatterns = {"/adresse"})
public class AdresseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getSession().setAttribute("adrDep", req.getParameter("adrDep"));
        req.getSession().setAttribute("adrArr", req.getParameter("adrArr"));
        req.getSession().setAttribute("distance", req.getParameter("distance"));
    }
    
}
