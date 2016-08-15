
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Inscription Passager</title>
    </head>
    <body>
        <h1>Cousin Huber</h1>
        <h2>Inscription Conducteur</h2>
        
            <a class="lien1" href="homePage.jsp">Home Page</a>
        
            <form method="POST">
                Identifiant : <input type="text" name="loginConducteur"/><br/>
                Mot de Passe : <input type="password" name="mdpConducteur"/><br/>
                Email : <input type="text" name="emailConducteur"/><br/>
                Tel : <input type="text" name="telConducteur"/></br>
                Immatriculation : <input type="text" name="immatConducteur"/></br>
                <input class="button_connexion" type="submit" value="inscription"/>
                <input class="button_reset" type="reset" value="annuler"/>
            </form>
    </body>
</html>
