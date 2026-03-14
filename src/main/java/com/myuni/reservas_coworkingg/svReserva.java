/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myuni.reservas_coworkingg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.claseReserva;
import logica.controladora;

/**
 *
 * @author Alejandra
 */
@WebServlet(name = "svReserva", urlPatterns = {"/svReserva"})
public class svReserva extends HttpServlet {

    //Instancia de la clase controladora de manera global
    controladora control = new controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<claseReserva> listaReserva = new ArrayList<>();
        //Ya no simulamos una lista de base de datos si no que la traemos por jpa de la bd
        listaReserva = control.traerReserva();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaReserva", listaReserva);

        response.sendRedirect("mostrarReserva.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre_usuario = request.getParameter("nombre_usuario");
        String fecha_reserva = request.getParameter("fecha_reserva");
        String espacio_trabajo = request.getParameter("espacio_trabajo");
        String duracion = request.getParameter("duracion");

        // Validacion de campos
        if (nombre_usuario == null || nombre_usuario.isEmpty()
                || fecha_reserva == null || fecha_reserva.isEmpty()
                || espacio_trabajo == null || espacio_trabajo.isEmpty()
                || duracion == null || duracion.isEmpty()) {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<h2>Error: Todos los campos son obligatorios</h2>");
            out.println("<a href='index.jsp'>Volver</a>");

            return; // detiene el servlet para que no guarde datos
        }

        // Objetos
        claseReserva res = new claseReserva();
        res.setNombre_usuario(nombre_usuario);
        res.setFecha_reserva(fecha_reserva);
        res.setEspacio_trabajo(espacio_trabajo);
        res.setDuracion(duracion);

        control.crearReserva(res);

        //prueba de que llego el valor 
        //System.out.pintln("Id es: " + id);
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
