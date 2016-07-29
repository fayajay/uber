<%-- 
    Document   : connexionPassager
    Created on : 28 juil. 2016, 16:09:53
    Author     : kellyleclerc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Connexion Passager</h1>
        
            <form method="POST">
                Identifiant : <input type="text" name="login"/>
                Mot de Passe : <input type="password" name="mdp"/><br/>

                <input type="submit" value="connexion"/>
                <input type="reset" value="annuler"/>
            </form>
            
        <a href="inscriptionPassager.jsp">Inscription</a>
    </body>
</html>
