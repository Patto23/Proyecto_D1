<%-- 
    Document   : ModificarEmpleado
    Created on : 1 dic 2023, 21:39:45
    Author     : User
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Empleado</title>
    </head>
    <body>   
        <h1>Modificar empleado</h1>
        <form method="POST" action="/Supermercado/ServletPrincipal?accion=ModificarEmpleado">
            <div>
                <label>ID Empleado:</label>
                <input type="text" name="IdEmpleado" id="IdEmpleado" value="${param.idEmpleado}" readonly /><br>
                <label>nombresEmpleados:</label>
                <input type="text" name="nombresEmpleados" id="nombresEmpleados" value="${param.nombresEmpleados}" required /><br>
                <label>apellidos Empleados:</label>
                <input type="text" name="apellidosEmpleados" id="apellidosEmpleados" value="${param.apellidosEmpleados}" required /><br>
                <label>fecha de Naccimiento del Empleados:</label>
                <input type="text" name="fechaNacEmpleados" id="fechaNacEmpleados" value="${param.fechaNacEmpleados}" required /><br>
                <label>telefono:</label>
                <input type="text" name="telefono" id="telefono" value="${param.telefono}" required /><br>
                <label>correo electronico:</label>
                <input type="text" name="correo" id="correo" value="${param.correo}" required /><br>           
                <input type="submit" value="Modificar" onclick="return confirm('¿Desea modificar el empleado?')" /><br><br> 
            </div>
            <div>
                <a href="/Supermercado/?accion=GestionarEmpleados">Regresar</a><br><br>
            </div>             
        </form>
    </body>
</html>
