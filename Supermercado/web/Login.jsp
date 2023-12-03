
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <style>
        body {
            background-color: #91266c;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            margin: 20px auto;
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }
    </style>
    
    <body>
        <form method="POST" action="/Supermercado/ServletPrincipal?accion=Login" id="formLogin">
            <div id="resultLogin"></div>
            <div><h1>Bienvenido al Sistema del Supermercado</h1></div>
            
           <c:set var="fechaHoraActual" value="<%= new java.util.Date() %>" />
            <fmt:formatDate value="${fechaHoraActual}" pattern="dd/MM/yyyy HH:mm:ss" var="fechaHoraFormateada" />
             
            <div><label><strong>
                        <p>Fecha y Hora Actual: ${fechaHoraFormateada}</p>
            </strong></label></div><br>
            <div><label>Usuario:</label></div>
            <div><input type="text" name="tfUsuario" id="idtfUsuario"></div><br>
            <div><label>Contraseña:</label></div>
            <div><input type="password" name="tfContrasenia" id="tfContrasenia"></div><br>
            <div><input type="submit" value="Iniciar Sesi&oacute;n"></div>
        </form>
    </body>
</html>
