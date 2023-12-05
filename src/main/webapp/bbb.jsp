<%--
  Created by IntelliJ IDEA.
  User: maple
  Date: 2023/12/4
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
bbbbb

<br>
--------------------------------------
<br>>

${list}

<br>
--------------------------------------
<br>

<c:forEach items="${requestScope.list}" var="item">
	item:${item}
</c:forEach>

<br>
--------------------------------------
<br>
<ul>
	<c:forEach var="item" items="${requestScope.list}">
		<li>${item}</li>
	</c:forEach>
</ul>


</body>
</html>
