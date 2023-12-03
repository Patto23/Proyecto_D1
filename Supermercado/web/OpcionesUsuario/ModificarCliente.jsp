<%-- 
    Document   : ModificarCliente
    Created on : 2 dic 2023, 08:06:26
    Author     : User
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Cliente</title>
    </head>
    <body>   
        <h1>Modificar Cliente</h1>
        <form method="POST" action="/Supermercado/ServletPrincipal?accion=ModificarCliente">
            <div>
                <label>Id Cliente:</label>
                <input type="text" name="IdCliente" id="IdCliente" value="${param.idCliente}" readonly /><br>
                <label>Nombre:</label>
                <input type="text" name="Nombre" id="Nombre" value="${param.nombre}" required /><br>
                <label>Apellido:</label>
                <input type="text" name="Apellido" id="Apellido" value="${param.apellido}" required /><br>
                <label>Direccion:</label>
                <input type="text" name="Direccion" id="Direccion" value="${param.direccion}" required /><br>
                <label>Dui:</label>
                <input type="text" name="Dui" id="Dui" value="${param.dui}" required /><br>
                <label>NumeroTelefonico:</label>
                <input type="text" name="NumeroTelefonico" id="NumeroTelefonico" value="${param.numeroTelefonico}" required /><br>
                <label>email:</label>
                <input type="text" name="email" id="email" value="${param.email}" required /><br>
                <input type="submit" value="Modificar" onclick="return confirm('¿Desea modificar el empleado?')" /><br><br> 
            </div>
            <div>
                <a href="/Supermercado/?accion=GestionarClientes">Regresar</a><br><br>
            </div>             
        </form>
    </body>
</html>