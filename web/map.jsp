
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MAP</h1>
        
            <c:if test="${utilConnecte.login==null}">
                <a class="menu" href="connexion_passager">Connexion</a>
            </c:if>
            <c:if test="${utilConnecte.login!=null}">
                <a class="menu" href="deconnexion">Déconnexion</a>
            </c:if>
    </body>
</html>
