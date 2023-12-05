<% List<String> list = new ArrayList<>(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World!</h2>

<%
	list.add("1");
	list.add("2");
	list.add("3");
	request.setAttribute("list", list);
%>


JSTL示例
<c:forEach items="${requestScope.list}" var="item">
	item:${item}
</c:forEach>


</body>
</html>
