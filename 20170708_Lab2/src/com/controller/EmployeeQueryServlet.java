package com.controller;

import com.model.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nobody on 2017/7/8.
 */
@WebServlet(name = "EmployeeQueryServlet", urlPatterns = {"/EmployeeQueryServlet"})
public class EmployeeQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<body>");

        //        List<Employee> list = new ArrayList<>();
        //        list.add(new Employee(1, "AAA"));
        //        list.add(new Employee(2, "BBB"));
        //
        //        String employeeID = request.getParameter("id");
        //        int id = Integer.parseInt(employeeID);
        //        int index = list.indexOf(new Employee(id, null));
        //
        //        if (index < 0) {
        //            request.setAttribute("emp", null);
        //        } else {
        //            Employee emp = list.get(index);
        //            request.setAttribute("emp", emp);
        //        }

        String empID = request.getParameter("id");
        int id = Integer.parseInt(empID);

        try {
            Class.forName("com.mysql.jdbc.Driver");//先載入MySQL驅動
            Connection con = DriverManager.getConnection(//取得與資料庫的連結
                    "jdbc:mysql://114.33.246.89:3306/user1",//連結資料庫的URL
                    "user",//資料庫的登入帳號
                    "user"//資料庫的登入密碼
            );

            PreparedStatement selectStatement = con.prepareStatement("select * FROM user1.emp WHERE id=?");
            selectStatement.setInt(1, id);
            ResultSet rs = selectStatement.executeQuery();

            Employee emp = null;
            while (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("cname"));
            }
            request.setAttribute("emp", emp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employeeQuery.jsp");
        requestDispatcher.forward(request, response);

        out.println("</body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
