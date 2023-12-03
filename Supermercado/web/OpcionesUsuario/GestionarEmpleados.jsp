<%-- 
    Document   : GestionarEmpleados
    Created on : 18 nov 2023, 10:56:38
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Empleados</title>
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
        <h1>Gestion de Empleados</h1>
        <h2>Lista de Empleados</h2>
        <h3>Conexion: $(mensaje_conexion)</h3>
        
        <a href="/Supermercado?accion=AgregarEmpleado">Agregar Empleado</a><br><br>
        
        <table border="1">
            <thead>
                <tr>
                    <th>IdEmpleado</th>
                    <th>nombresEmpleados</th>
                    <th>apellidosEmpleados</th>
                    <th>fechaNacEmpleados</th>
                    <th>telefono</th>
                    <th>correo</th>
                    
                    <th>Acciones</th>

                </tr>
            </thead>
            
                <c:forEach items="${listaEmpleados}" var="item">
                    <tr>
                        <td><c:out value="${item.idEmpleado}"/></td>
                        <td><c:out value="${item.nombresEmpleados}"/></td>
                        <td><c:out value="${item.apellidosEmpleados}"/></td>
                        <td><c:out value="${item.fechaNacEmpleados}"/></td>
                        <td><c:out value="${item.telefono}"/></td>
                        <td><c:out value="${item.correo}"/></td>
                    </tr>
                                
                     <td>
                            <form method="POST" action="/Supermercado/OpcionesUsuario/ModificarEmpleado.jsp" >
                                <input type="hidden" name="IdEmpleado" value="${item.idEmpleado}" />
                                <input type="hidden" name="nombresEmpleados" value="${item.nombresEmpleados}" />
                                <input type="hidden" name="apellidosEmpleados" value="${item.apellidosEmpleados}" />
                                <input type="hidden" name="fechaNacEmpleadoso" value="${item.fechaNacEmpleados}" />
                                <input type="hidden" name="telefono" value="${item.telefono}" />
                                <input type="hidden" name="correo" value="${item.correo}" />
                                <input type="submit" value="Modificar" />
                            </form>
                                <form method="POST" action="/Supermercado/OpcionesUsuario/EliminarEmpleado.jsp">
                                <input type="hidden" name="IdEmpleado" value="${item.idEmpleado}" />
                                <input type="hidden" name="nombresEmpleados" value="${item.nombresEmpleados}" />
                                <input type="hidden" name="apellidosEmpleados" value="${item.apellidosEmpleados}" />
                                <input type="hidden" name="fechaNacEmpleadoso" value="${item.fechaNacEmpleados}" />
                                <input type="hidden" name="telefono" value="${item.telefono}" />
                                <input type="hidden" name="correo" value="${item.correo}" />
                                <input type="submit" value="Eliminar" />
                            </form>
                     </td>
                </tr>
                </c:forEach>
            <tbody>
        </table>
    </body>
</html>
