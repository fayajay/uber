
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Passager</title>
    </head>
    <body>
        <h1>Inscription Passager</h1>
        
            <a href="homePage.jsp">Home Page</a>
        
            <form method="POST">
                Identifiant : <input type="text" name="loginPassager"/><br/>
                Mot de Passe : <input type="password" name="mdpPassager"/><br/>
                Email : <input type="text" name="emailPassager"/><br/>
                Tel : <input type="text" name="telPassager"/></br>
                <input type="submit" value="inscription"/>
                <input type="reset" value="annuler"/>
            </form>
    </body>
</html>
