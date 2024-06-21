package com.lewis.requestinfoservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "requestInfoServlet", value = "/request-info")
public class RequestInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Set response content type
            response.setContentType("text/html");

            //Get writer to send response back to client
            PrintWriter out = response.getWriter();

            //Get and print request method
            String method = request.getMethod();
            out.println("<h3>Request Method: " + method + "</h3>");

            //Get and print request URL
            String requestURL = request.getRequestURL().toString();
            out.println("<h3>Request URL: " + requestURL + "</h3>");

            //Get and print request headers
            out.println("<h3>Request Headers:</h3>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println(headerName + ": " + headerValue + "<br>");
        }

        // Get and print request parameters (for form data)
        out.println("<h3>Request Parameters:</h3>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            out.println(paramName + ": " + String.join(", ", paramValues) + "<br>");
        }

        // Get and print request body (for JSON or other raw data)
        out.println("<h3>Request Body:</h3>");
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            requestBody.append(line).append("\n");
        }
        out.println("<pre>" + requestBody.toString() + "</pre>");
    }

}
