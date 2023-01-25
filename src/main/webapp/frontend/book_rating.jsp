<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/25/2023
  Time: 1:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Title</title>
</head>
<body>
<c:forTokens items="${book.ratingStars} " delims="," var="star">
  <c:if test="${star eq 'on'}">
    <img style="width: 20px; height: 20px;" src="images/rating_on.png">
  </c:if>
  <c:if test="${star eq 'off'}">
    <img style="width: 20px; height: 20px;"  src="images/rating_off.png">
  </c:if>
  <c:if test="${star eq 'half'}">
    <img style="width: 20px; height: 20px;"  src="images/rating_half.png">
  </c:if>
</c:forTokens>

</body>
</html>
