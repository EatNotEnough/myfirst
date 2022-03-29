<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2022/3/28
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<:c:forEach var="i" begin="1" end="10" step="2">
    ${i}
</:c:forEach>
</body>
</html>
