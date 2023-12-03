<%-- 
    Document   : PanelAdministrador
    Created on : 31 oct 2023, 10:09:27
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Panel del Administrador</title>
</head>
<body>
    <div><h1>Sistema Supermercado</h1></div>
    <% String usuario = request.getParameter("tfUsuario"); %>
    <div><h2><strong>
        ¡Bienvenido,
        <c:choose>
            <c:when test="${usuario eq 'gerente'}">
                gerente
            </c:when>
            <c:otherwise>
                <%= usuario %>
            </c:otherwise>
        </c:choose>!
    </strong></h2></div>

    <div><h3>Menú de opciones</h3></div>
    <div>
        <%@include file="MenuAdministrador.jsp" %>
    </div>
    <div>
        <%@include file="Footer.html" %>
    </div>
</body>
</html>

