<%-- 
    Document   : mostrarReserva
    Created on : 14/03/2026, 12:13:24 a. m.
    Author     : Alejandra
--%>

<%@page import="java.util.List"%>
<%@page import="logica.claseReserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <div class="reserva">
            <h1>Lista de Reservas</h1>

            <%
                List<claseReserva> listaReserva = (List) request.getSession().getAttribute("listaReserva");
                int cont = 1;
                for (claseReserva res : listaReserva) {

            %>

            <p><b>Reserva N° <%=cont%></b></p>
            <p><b>Nombre de Usuario: <%=res.getNombre_usuario()%></b></p>
            <p><b>Fecha de Reserva: <%=res.getFecha_reserva()%></b></p>
            <p><b>Espacio de trabajo: <%=res.getEspacio_trabajo()%></b></p>
            <p><b>Duración <%=res.getDuracion()%></b></p>
            <p>--------------------------------------------------------------</p>
            <a href="svEliminarReserva?id=<%=res.getId()%>">
                <button>Eliminar</button>
            </a>

            <%                        cont = cont + 1;
                }

            %>
        </div>
    </body>
</html>
