
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion Conducteur</title>
    </head>
    <body>
        <h1>Connexion Conducteur</h1>
        
        <a href="homePage.jsp">Home Page</a>
        

            
        <a href="inscription_conducteur">Inscription</a>
        
        
            <form method="POST">
                Identifiant : <input type="text" name="loginConducteur"/>
                Mot de Passe : <input type="password" name="mdpConducteur"/><br/>

                <input type="submit" value="connexion"/>
                <input type="reset" value="annuler"/>
            </form>    
    </body>
</html>
