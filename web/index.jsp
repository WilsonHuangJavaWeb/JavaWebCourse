<%--
  Created by IntelliJ IDEA.
  User: Nobody
  Date: 2017/7/1
  Time: 下午 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>

<form action="servlet/NewServlet" method="get">
    <table border="1">
        <tr>
            <td>Employee ID</td>
            <td><input type="text" name="employeeID"></td>
            <td><input type="submit" value="送出"></td>
        </tr>
    </table>
</form>
</body>
</html>
