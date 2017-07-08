package com.servlet;

import com.pojo.ExampleModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nobody on 2017/7/8.
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("fullView.jsp");
        ExampleModel model = new ExampleModel();
        String name = request.getParameter("name");
        if (name == null) {
            name = "Secret";
        }
        model.setName(name);

        request.setAttribute("model", model);

        requestDispatcher.forward(request, response);
    }
}
