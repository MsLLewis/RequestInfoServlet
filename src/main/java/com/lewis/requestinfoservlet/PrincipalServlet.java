package com.lewis.requestinfoservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PrincipalServlet", value = "/principalServlet")
public class PrincipalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Set an Attribute in the ServletContext
        ServletContext context = getServletContext();
        context.setAttribute("myAttribute", "Java is Amazing!");

        //Forward request to another servlet - /forwardServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/forwardServlet");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
