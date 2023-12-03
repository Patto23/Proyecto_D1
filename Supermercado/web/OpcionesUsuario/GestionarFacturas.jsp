<%-- 
    Document   : GestionarFacturas
    Created on : 1 dic 2023, 09:07:08
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestinar Facturas</title>
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
        <body>
        <h1>Gestion de Facturas</h1>
        <h2>Lista de Facturas</h2>
        <h3>Conexion: $(mensaje_conexion)</h3>
        
        <a href="/Supermercado?accion=AgregarFactura">Agregar Factura</a><br><br>
        
        <table border="1">
            <thead>
                <tr>
                    <th>IdFactura</th>
                    <th>IDFormadePago</th>
                    <th>IdCliente</th>
                    <th>IdUsuario</th>
                    <th>totalCompra</th>
                   
                    <th>Acciones</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaFacturas}" var="item">
                    <tr>
                        <td><c:out value="${item.idFactura}"/></td>
                        <td><c:out value="${item.IDFormadePago}"/></td>
                        <td><c:out value="${item.idCliente}"/></td>
                        <td><c:out value="${item.idUsusario}"/></td>
                        <td><c:out value="${item.totalCompra}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>
