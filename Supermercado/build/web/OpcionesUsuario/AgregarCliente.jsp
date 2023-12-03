<%-- 
    Document   : AgregarCliente
    Created on : 2 dic 2023, 07:34:49
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Cliente</title>
                   <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        a {
            text-decoration: none;
            color: #4caf50;
        }

        a:hover {
            text-decoration: underline;
        }

        .message {
            margin-top: 10px;
            padding: 10px;
            border-radius: 4px;
        }

        .success {
            background-color: #d4edda;
            border-color: #c3e6cb;
            color: #155724;
        }

        .error {
            background-color: #f8d7da;
            border-color: #f5c6cb;
            color: #721c24;
        }
    </style>
    </head>
    <body>
        <c:if test="${exito!=null}">
            <c:if test="${exito}">
                <p><strong style="color: darkgreen;">La información se guardó correctamente</strong></p>
            </c:if>
            <c:if test="${!exito}">
                <p><strong style="color: red;">No se guardó la información</strong></p>
            </c:if>
        </c:if>   
        <h1>Agregar nuevo Cliente</h1>

        <form method="POST" action="/Supermercado/ServletPrincipal?accion=AgregarCliente">
            <div>
                <!-- El ID de los empleados es autoincrementable -->
                <label>Nombre:</label>
                <input type="text" name="Nombre" id="Nombre" required /><br>
                <label>Apellido:</label>
                <input type="text" name="Apellido" id="Apellido" required /><br>
                <label>Direccion:</label>
                <input type="text" name="Direccion" id="Direccion" required /><br>
                <label>Dui:</label>
                <input type="text" name="Dui" id="Dui" required /><br>
                <label>NumeroTelefonico:</label>   
                <input type="text" name="NumeroTelefonico" id="NumeroTelefonico" required /><br>
                <label>email:</label>   
                <input type="text" name="email" id="email" required /><br>
                <input type="submit" value="Registrar" onclick="return confirm('¿Desea registrar el empleado?')" /><br><br>
            </div><br>
            <div>
                <a href="/Supermercado/?accion=GestionarClientes">Regresar</a>
            </div>            
        </form>
    </body>
</html>
