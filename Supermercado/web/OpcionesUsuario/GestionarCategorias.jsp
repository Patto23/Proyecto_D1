<%-- 
    Document   : GestionarCategorias
    Created on : 1 dic 2023, 10:14:46
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Categorias</title>
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
        <h1>Gestion de Categorias</h1>
        <h2>Lista de Categorias</h2>
        <h3>Conexion: $(mensaje_conexion)</h3>
        
         <a href="/Supermercado?accion=AgregarCategoria">Agregar Categoria</a><br><br>
         
          <table border="1">
            <thead>
                <tr>
                    <th>idCategoria</th>
                    <th>Categoria</th>
                   
                    <th>Acciones</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaCategorias}" var="item">
                    <tr>
                        <td><c:out value="${item.idCategoria}"/></td>
                        <td><c:out value="${item.categoria}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>
