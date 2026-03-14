<%-- 
    Document   : index
    Created on : 13/03/2026, 6:47:53 p. m.
    Author     : Alejandra
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
        <style>
            body{
                font-family: Arial, sans-serif;
                background: #f4f6f9;
                text-align: center;
            }

            h1{
                color: #333;
            }

            form{
                background: white;
                padding: 20px;
                margin: auto;
                width: 350px;
                border-radius: 10px;
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            }

            input, select{
                width: 90%;
                padding: 8px;
                margin: 8px 0;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            button{
                background: #4CAF50;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:hover{
                background: #45a049;
            }

            .reserva{
                background: white;
                margin: 15px auto;
                padding: 15px;
                width: 400px;
                border-radius: 10px;
                box-shadow: 0px 0px 5px rgba(0,0,0,0.1);
            }

            .eliminar{
                background: #e74c3c;
            }

            .eliminar:hover{
                background: #c0392b;
            }
        </style>
    </head>
    <body>
        <h1>Datos de reserva</h1>
        <%-- 
        Formulario inicial reserva campos solicitados en bd
        --%>
        <form action="svReserva" method="POST">
            <p><label>Nombre de Usuario</label><input type="text" name="nombre_usuario"></p>
            <p><label>Fecha de Reserva</label><input type="date" name="fecha_reserva"></p>
            <p><label>Espacio de trabajo</label><input type="text" name="espacio_trabajo"></p>
            <p><label>Duración</label><input type="text" name="duracion"></p>  
            <p><button type="submit">Reservar</button></p>
        </form>     
        <%-- 
        Alerta de correcto envio del formulario, o completar campos correctos, envio de confirmacion de la reserva con uso de JS para las alertas
        --%>
        <%-- 
        Con el metodo get trae la lista de reservas
        --%>
        <h1>Ver lista de reservas</h1>
        <p>Para ver los datos cargados haga click en el siguiente boton</p>
        <form action="svReserva" method="GET">
            <button type="submit">Mostrar Reservas</button>
        </form>
        <%--Historial de reservas y eliminar reserva, implementacion de botones desde html--%> 
    </body>
</html>