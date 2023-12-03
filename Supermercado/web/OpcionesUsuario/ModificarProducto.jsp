<%-- 
    Document   : ModificarProducto
    Created on : 2 dic 2023, 18:25:26
    Author     : User
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Producto</title>
    </head>
    <body>   
        <h1>Modificar Producto</h1>
        <form method="POST" action="/Supermercado/ServletPrincipal?accion=ModificarProducto">
            <div>
                <label>IdProducto:</label>
                <input type="text" name="IdProducto" id="IdProducto" value="${param.idProducto}" readonly /><br>
                <label>nombresProducto:</label>
                <input type="text" name="nombreProducto" id="nombreProducto" value="${param.nombreProducto}" required /><br>
                <label>Categoria:</label>
                <input type="text" name="idCategoria" id="idCategoria" value="${param.idCategoria}" required /><br>
                <label> IdProveedor:</label>
                <input type="text" name="IdProveedor" id="IdProveedor" value="${param.IdProveedor}" required /><br>
                <label>precio: </label>
                <input type="text" name="precio" id="precio" value="${param.precio}" required /><br>
                <label>categoriaNombre </label>
                <input type="text" name="categoriaNombre" id="categoriaNombre" value="${param.categoriaNombre}" required /><br>
                <input type="submit" value="Modificar" onclick="return confirm('¿Desea modificar el empleado?')" /><br><br> 
            </div>
            <div>
                <a href="/Supermercado/?accion=GestionarProductos">Regresar</a><br><br>
            </div>             
        </form>
    </body>
</html>