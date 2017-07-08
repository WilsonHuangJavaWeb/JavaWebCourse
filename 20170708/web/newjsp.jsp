<%@ page import="java.util.List" %>
<%@ page import="com.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Nobody
  Date: 2017/7/8
  Time: 上午 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New JSP</title>
</head>
<body>
<%
    List<Employee> list = new ArrayList<Employee>();
    list.add(new Employee(1, "AAA"));
    list.add(new Employee(2, "BBB"));
%>
<%
    String employeeID = request.getParameter("id");
    int id = Integer.parseInt(employeeID);
    int index = list.indexOf(new Employee(id, null));
    if (index < 0) {
%>
NOT FOUND!!!
<%
} else {
    Employee emp = list.get(index);
%>
<table border="1">
    <tr>
        <td>ID</td>
        <td>NAME</td>
    </tr>
    <tr>
        <td><%=emp.getId()%>
        </td>
        <td><%=emp.getName()%>
        </td>
    </tr>
</table>
<%
    }
%>

</body>
</html>
