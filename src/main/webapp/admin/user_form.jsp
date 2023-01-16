<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/14/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User</title>


</head>
<body>

<jsp:directive.include file="header.jsp"></jsp:directive.include>

<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">

                <c:if test="${user != null}">
                    <h2>Edit User</h2>
                </c:if>
                <c:if test="${user == null}">
                    <h2 class="title">Create New User</h2>
                </c:if>


                <c:if test="${user != null}">
                    <form action="update_user" method="POST" id="form">
                        <input type="hidden" name="userId" value="${user.userId}">
                </c:if>
                    <c:if test="${user == null}">
                    <form action="create_user" method="POST" id="form">
                    </c:if>
                    <div class="input-group">
                        <input class="input--style-2" id="email" type="email" placeholder="Email" name="email" value="${user.email}">
                        </label><span class="error" id='message3'></span></span>
                    </div>
                    <div class="input-group">
                        <input class="input--style-2" type="text" id="fullname" placeholder="Full Name" name="fullname" value="${user.fullName}" required>
                        </label><span class="error" id='message6'></span></span>

                    </div>
                    <div class="input-group">
                        <input class="input--style-2" type="password" id="password" placeholder="Password" name="password" value="${user.password}"  required>
                        </label><span class="error" id='message1'></span></span>
                    </div>
                    <div class="input-group">
                        <input class="input--style-2" type="password" id="confirm_pass" placeholder="Confirm Password" name="password" required>
                        </label><span class="error" id='message'></span></span>
                    </div>
                    <div class="p-t-30">
                        <button class="btn btn--radius btn--green" type="submit" value="Save">Add</button>
                        <button class="btn btn--radius btn--green">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:directive.include file="footer.jsp"></jsp:directive.include>


</body>
</html>
