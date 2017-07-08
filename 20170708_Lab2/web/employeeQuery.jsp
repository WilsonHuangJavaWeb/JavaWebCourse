<%@ page import="com.model.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: Nobody
  Date: 2017/7/8
  Time: 下午 02:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employeeQuery</title>
</head>
<body>
<%
    Employee employee = (Employee) request.getAttribute("emp");
    if (employee == null) {
%>
NOT FOUND!!!!

<%
} else {
%>
<table border="1">
    <tr>
        <td>ID</td>
        <td>NAME</td>
    </tr>
    <tr>
        <td><%=employee.getId()%>
        </td>
        <td><%=employee.getName()%>
        </td>
    </tr>
</table>
<%
    }
%>
</body>
</html>
