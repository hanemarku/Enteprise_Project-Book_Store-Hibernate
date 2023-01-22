<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/14/2023
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adrion Bookstore</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>



<%--<c:if test="${message != null}">--%>
    <div class="alert alert-warning center m-2" role="alert">
            ${message}
    </div>
<%--</c:if>--%>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
