
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Passager</title>
    </head>
    <body>
        <h1>Inscription Conducteur</h1>
        
            <a href="homePage.jsp">Home Page</a>
        
            <form method="POST">
                Identifiant : <input type="text" name="loginConducteur"/><br/>
                Mot de Passe : <input type="password" name="mdpConducteur"/><br/>
                Email : <input type="text" name="emailConducteur"/><br/>
                Tel : <input type="text" name="telConducteur"/></br>
                Immatriculation : <input type="text" name="immatConducteur"/></br>
                <input type="submit" value="inscription"/>
                <input type="reset" value="annuler"/>
            </form>
    </body>
</html>
