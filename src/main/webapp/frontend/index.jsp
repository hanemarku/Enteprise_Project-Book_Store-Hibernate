<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/3/2023
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADRION Library - Online Book Store</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

    <div align="center">
        <h3>This is main content</h3>
        <h3>New books</h3>
        <h3>Best-Selling Books</h3>
        <h3>Most-favored books</h3>
    </div>

    <div>
        <c:forEach var="category" items="${listCategory}">
            <a href="view_category?id=${category.categoryId}">
                <c:out value="${category.name}" />
            </a>
            <c:if test="${not status.last}">
                &nbsp; | &nbsp;
            </c:if>
        </c:forEach>
    </div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
