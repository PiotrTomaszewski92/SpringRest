<%--
  Created by IntelliJ IDEA.
  User: tomaszewski
  Date: 2019-04-02
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REST Project - Home Page</title>
</head>
<body>
<h2>REST Project - Home Page</h2>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello Page</a><br>
<a href="${pageContext.request.contextPath}/api/students">List of Students</a><br>
<a href="${pageContext.request.contextPath}/api/customers">Show All Customers</a><br>
</body>
</html>
