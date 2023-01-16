<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/16/2023
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
  <jsp:include page="header.jsp"></jsp:include>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script type="text/javascript" src="../js/login.js"></script>

</head>
<body>
  <h1 class="text-center mt-5 mb-3">Login</h1>
  <div class="container w-25">
      <h3>Admin Store Administration</h3>
      <p>Admin Login</p>

<%--    <div class="alert alert-danger" id="validations" role="alert"></div>--%>

    <form id="formLogin" method="Post" action="login">
      <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="email" placeholder="email@example.com" name="email">
        </label><span class="error" id="message3"></span></span>

      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Password" name="password">
        </label><span class="error" id="message1"></span></span>

      </div>

      <button type="submit" class="btn btn-danger btn-block">Login</button>
      <div class="dropdown-divider"></div>
    </form>
    <a class="dropdown-item" href="/signup">New around here? Sign up</a>
    <a class="dropdown-item" href="#">Forgot password?</a>
  </div>

</body>
</html>
