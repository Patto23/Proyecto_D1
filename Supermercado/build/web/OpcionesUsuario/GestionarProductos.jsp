<%-- 
    Document   : GestionarProductos
    Created on : 29 nov 2023, 22:47:45
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Productos</title>
                <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1, h2, h3 {
            color: #333;
        }

        a {
            text-decoration: none;
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border-radius: 5px;
            margin-bottom: 15px;
            display: inline-block;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        form {
            display: inline-block;
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    </head>
    <body>
        <h1>Gestion de Productos</h1>
        <h2>Lista de Productos</h2>
        <h3>Conexion: $(mensaje_conexion)</h3>
        
         <a href="/Supermercado?accion=AgregarProducto">Agregar Producto</a><br><br>
         
         <table border="1">
            <thead>
                <tr>
                    <th>IdProducto</th>
                    <th>nombreProducto</th>
                    <th>idcategoria</th>
                    <th>IdProveedor</th>
                    <th>precio</th>
                    <th>categoriaNombre</th>
                    
                    <th>Acciones</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaProducto}" var="item">
                    <tr>
                        <td><c:out value="${item.idProducto}"/></td>
                        <td><c:out value="${item.nombreProducto}"/></td>
                        <td><c:out value="${item.idCategoria}"/></td>
                        <td><c:out value="${item.IdProveedor}"/></td>
                        <td><c:out value="${item.precio}"/></td>
                        <td><c:out value="${item.categoriaNombre}"/></td>

                    
                    <td>
                            <form method="POST" action="/Supermercado/OpcionesUsuario/ModificarProducto.jsp" >
                                <input type="hidden" name="IdProducto" value="${item.idProducto}" />
                                <input type="hidden" name="nombreProducto" value="${item.nombreProducto}" />
                                <input type="hidden" name="idCategoria" value="${item.idCategoria}" />
                                <input type="hidden" name="IdProveedor" value="${item.IdProveedor}" />
                                <input type="hidden" name="precio" value="${item.precio}" />
                                <input type="hidden" name="categoriaNombre" value="${item.categoriaNombre}" />
                                <input type="submit" value="Modificar" />
                            </form>
                                <form method="POST" action="/Supermercado/OpcionesUsuario/ModificarProducto.jsp" >
                                <input type="hidden" name="IdProducto" value="${item.idProducto}" />
                                <input type="hidden" name="nombreProducto" value="${item.nombreProducto}" />
                                <input type="hidden" name="idCategoria" value="${item.idCategoria}" />
                                <input type="hidden" name="IdProveedor" value="${item.IdProveedor}" />
                                <input type="hidden" name="precio" value="${item.precio}" />
                                <input type="hidden" name="categoriaNombre" value="${item.categoriaNombre}" />
                                <input type="submit" value="Eliminar" />
                            </form>
                     </td>
                     </tr>
                </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>
