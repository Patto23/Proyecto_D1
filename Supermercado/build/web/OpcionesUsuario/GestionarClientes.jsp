<%-- 
    Document   : GestionarClientes
    Created on : 1 dic 2023, 14:57:33
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Clientes</title>
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
        <h1>Gestion de Clientes</h1>
        <h2>Lista de Clientes</h2>
        <h3>Conexion: $(mensaje_conexion)</h3>
        
        <a href="/Supermercado?accion=AgregarCliente">Agregar Cliente</a><br><br>
        
        <table border="1">
            <thead>
                <tr>
                    <th>IdCliente</th>
                    <th> Nombre</th>
                    <th>Apellido</th>
                    <th>Direccion</th>
                    <th>Dui</th>
                    <th>NumeroTelefonico</th>
                    <th>email</th>
                    
                    <th>Acciones</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaClientes}" var="item">
                    <tr>
                        <td><c:out value="${item.idCliente}"/></td>
                        <td><c:out value="${item.nombre}"/></td>
                        <td><c:out value="${item.apellido}"/></td>
                        <td><c:out value="${item.direccion}"/></td>
                        <td><c:out value="${item.dui}"/></td>
                        <td><c:out value="${item.numeroTelefonico}"/></td>
                        <td><c:out value="${item.email}"/></td>
                    </tr>
                    
                    <td>
                            <form method="POST" action="/Supermercado/OpcionesUsuario/ModificarCliente.jsp" >
                                <input type="hidden" name="IdCliente" value="${item.idCliente}" />
                                <input type="hidden" name="Nombre" value="${item.nombre}" />
                                <input type="hidden" name="Apellido" value="${item.apellido}" />
                                <input type="hidden" name="Direccion" value="${item.direccion}" />
                                <input type="hidden" name="Dui" value="${item.dui}" />
                                <input type="hidden" name="NumeroTelefonico" value="${item.numeroTelefonico}" />
                                <input type="hidden" name="email" value="${item.email}" />
                                <input type="submit" value="Modificar" />
                            </form>
                                <form method="POST" action="/Supermercado/OpcionesUsuario/EliminarCliente.jsp" >
                                <input type="hidden" name="IdCliente" value="${item.idCliente}" />
                                <input type="hidden" name="Nombre" value="${item.nombre}" />
                                <input type="hidden" name="Apellido" value="${item.apellido}" />
                                <input type="hidden" name="Direccion" value="${item.direccion}" />
                                <input type="hidden" name="Dui" value="${item.dui}" />
                                <input type="hidden" name="NumeroTelefonico" value="${item.numeroTelefonico}" />
                                <input type="hidden" name="email" value="${item.email}" />
                                <input type="submit" value="Modificar" />
                                </form>
                     </td>
                </tr>
                </c:forEach>
            <tbody>
        </table>
    </body>
</html>
