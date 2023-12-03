/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletError extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletError</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletError at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer CodigoEstado = (Integer)request.getAttribute("jakarta.servlet.error.status_code");
        String nombreServlet = (String) request.getAttribute("jakarta.servlet.error.status_name");
        String peticionUrl = (String)request.getAttribute("jakarta.servlet.error.request_ur1");
        
        switch(CodigoEstado){
            case 404:{
                request.getRequestDispatcher("/error404.html").forward(request, response);
            }break;
            
            case 500:{
                request.getRequestDispatcher("/error500.html").forward(request, response);
            }break;
            
            default:{
                request.getRequestDispatcher("/error500.html").forward(request, response);
            }break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
