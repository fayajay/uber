
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Connexion Conducteur</h1>
        
        <a href="homePage.jsp">Home Page</a>
        <c:if test="${utilConnecte.login==null}">
            <a class="menu" href="connexion_conducteur">Connexion</a>
        </c:if>
        <c:if test="${utilConnecte.login!=null}">
            <a class="menu" href="deconnexion">Déconnexion</a>
        </c:if>
        <a href="inscriptionConducteur.jsp">Inscription</a>
        
        
            <form method="POST">
                Identifiant : <input type="text" name="login"/>
                Mot de Passe : <input type="password" name="mdp"/><br/>

                <input type="submit" value="connexion"/>
                <input type="reset" value="annuler"/>
            </form>    
    </body>
</html>
