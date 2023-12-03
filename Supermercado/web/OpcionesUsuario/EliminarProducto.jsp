<%-- 
    Document   : EliminarProducto
    Created on : 2 dic 2023, 18:40:28
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Producto</title>
    </head>
    <body>
        <h1>Eliminar Producto</h1>

        <form method="POST" action="/Supermercado/ServletPrincipal?accion=EliminarProducto">
            <div>
                <label>IdProductoo: ${param.idProducto}</label><br>
                <label>nombreProducto: ${param.nombreProducto}</label><br>
                <label>idCategoria ${param.idCategoria}</label><br>
                <label>IdProveedor ${param.IdProveedor}</label><br>
                <label>precio ${param.precio}</label><br>
                <label>categoriaNombre ${param.categoriaNombre}</label><br>
                <input type="hidden" name="IdProducto" id="IdProducto" value="${param.idProducto}" /><br><br>
                <input type="submit" value="Eliminar" onclick="return confirm('¿Desea eliminar el empleado?')" /><br><br>
            </div>
            <div>
                <a href="/Supermercado/?accion=GestionarProductos">Regresar</a><br><br>
            </div>             
        </form>
    </body>
</html>