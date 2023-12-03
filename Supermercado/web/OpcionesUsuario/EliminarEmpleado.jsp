<%-- 
    Document   : EliminarEmpleado
    Created on : 2 dic 2023, 00:30:11
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Empleado</title>
    </head>
    <body>
        <h1>Eliminar empleado</h1>

        <form method="POST" action="/Supermercado/ServletPrincipal?accion=EliminarEmpleado">
            <div>
                <label>IdEmpleado: ${param.idEmpleado}</label><br>
                <label>nombresEmpleados: ${param.nombresEmpleados}</label><br>
                <label>apellidosEmpleados: ${param.apellidosEmpleados}</label><br>
                <label>fechaNacEmpleados: ${param.fechaNacEmpleados}</label><br>
                <label>telefono: ${param.telefono}</label><br>
                <label>correo: ${param.correo}</label><br>
                <input type="hidden" name="ID_Empleado" id="ID_Empleado" value="${param.ID_Empleado}" /><br><br>
                <input type="submit" value="Eliminar" onclick="return confirm('¿Desea eliminar el empleado?')" /><br><br>
            </div>
            <div>
                <a href="/Supermercado/?accion=GestionarEmpleados">Regresar</a><br><br>
            </div>             
        </form>
    </body>
</html>

