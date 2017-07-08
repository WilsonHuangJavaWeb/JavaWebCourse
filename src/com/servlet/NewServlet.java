package com.servlet;

import com.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nobody on 2017/7/1.
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/servlet/NewServlet"})
public class NewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        work(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        work(request, response);
    }

    private void work(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        try {


            List<Employee> list = new ArrayList<>();
            list.add(new Employee(2, "BBB"));
            list.add(new Employee(1, "AAA"));
            list.add(new Employee(3, "CCC"));

            String employeeID = request.getParameter("employeeID");
            int id = Integer.parseInt(employeeID);

            int idx = list.indexOf(new Employee(id, null));

            if (idx < 0) {
                out.println("NOT FOUND!!!");
                out.println("<input type='button' value='返回' onclick='history.back()'>");
            } else {
                Employee employee = list.get(idx);
                out.println("<html>\n" +
                        "<head>\n" +
                        "    <title>index.jsp</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "<form action=\"servlet/NewServlet\" method=\"post\">\n" +
                        "    <table border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <td>Employee ID</td>\n" +
                        "            <td>Employee Name</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>" + employee.getId() + "</td>\n" +
                        "            <td>" + employee.getName() + "</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td></td>\n" +
                        "            <td><input type='button' value='返回' onclick='history.back()'></td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>");
            }
        } catch (Exception e) {
            out.println("EmployeeID是整數。");
            out.println("<input type='button' value='返回' onclick='history.back()'>");
        } finally {
            out.close();
        }
    }
}
