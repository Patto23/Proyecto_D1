<%-- 
    Document   : MenuAdministrador
    Created on : 21 nov 2023, 15:14:30
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        nav {
            background-color: #333;
            color: white;
            padding: 10px;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        li {
            display: inline-block;
            margin-right: 20px;
        }

        a {
            text-decoration: none;
            color: white;
            padding: 10px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #555;
        }
    </style>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="/Supermercado">Inicio Supermercado</a></li>
                <li><a href="/Supermercado?accion=Login">Login</a></li>
                <li><a href="/Supermercado?accion=GestionarEmpleados">Gestionar Empleados</a></li>
                <li><a href="/Supermercado?accion=GestionarProductos">Gestionar Productos</a></li>
                <li><a href="/Supermercado?accion=GestionarProveedor">Gestionar Proveedores</a></li>
                <li><a href="/Supermercado?accion=GestionarFacturas">Gestionar Facturas</a></li>
                <li><a href="/Supermercado?accion=GestionarUsuarios">Gestionar Usuarios</a></li>
                <li><a href="/Supermercado?accion=GestionarCategorias">Gestionar Categorias</a></li>
                <li><a href="/Supermercado?accion=GestionarAsignacionRolesOpciones">Gestionar Asigancion de Roles</a></li>
                <li><a href="/Supermercado?accion=GestionarClientes">Gestionar Clientes</a></li>

            </ul>
        </nav>
    </body>
</html>
