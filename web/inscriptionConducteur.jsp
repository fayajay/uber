
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inscription Conducteur</h1>
        
            <a href="homePage.jsp">Home Page</a>
        
            <form method="POST">
                Identifiant : <input type="text" name="login"/><br/>
                Mot de Passe : <input type="password" name="mdp"/><br/>
                Email : <input type="text" name="email"/><br/>
                Tel : <input type="text" name="tel"/></br>
                Immatriculation : <input type="text" name="immat"/></br>
                <input type="submit" value="inscription"/>
                <input type="reset" value="annuler"/>
            </form>
    </body>
</html>
