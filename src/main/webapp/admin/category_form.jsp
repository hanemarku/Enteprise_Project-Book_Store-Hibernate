<%--
  Created by IntelliJ IDEA.
  category: DELL
  Date: 1/15/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login V16</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:directive.include file="header.jsp"></jsp:directive.include>
</head>
<body>

<div class="limiter ">
  <div class="container-login100" style="background-image: url('../images/libraryHorizontal.jpg');">
    <div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
                  <c:if test="${category != null}">
                    Edit Category
                  </c:if>
                  <c:if test="${category == null}">
                    Create New category
                  </c:if>
				</span>
          <c:if test="${category != null}">
            <form action="update_category" method="POST" id="formCategory" class="login100-form validate-form p-2">
            <input type="hidden" name="categoryId" value="${category.categoryId}">
          </c:if>
          <c:if test="${category == null}">
            <form action="create_category" method="POST" id="formCategory" class="login100-form validate-form p-2">
          </c:if>
                <div class="wrap-input100 validate-input" data-validate = "Enter category name">
                  <input class="input100" type="text" id="name" name="name" placeholder="Name" value="${category.name}">
                    </label><span class="error" id="message"></span></span>
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>

                </div>
                <div class="container-login100-form-btn m-t-32">
                  <button class="login100-form-btn m-3">
                    Create
                  </button>
                </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>

