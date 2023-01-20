<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/21/2023
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"></jsp:include>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <style>
        img{
            height:150px;
            width:100%;
        }

        div [class^="col-"]{
            padding-left:5px;
            padding-right:5px;
        }
        .card{
            transition:0.5s;
            cursor:pointer;
        }
        .card-title{
            font-size:15px;
            transition:1s;
            cursor:pointer;
        }
        .card-title i{
            font-size:15px;
            transition:1s;
            cursor:pointer;
            color:#ffa710
        }
        .card-title i:hover{
            transform: scale(1.25) rotate(100deg);
            color:#18d4ca;

        }
        .card:hover{
            transform: scale(1.05);
            box-shadow: 10px 10px 15px rgba(0,0,0,0.3);
        }
        .card-text{
            height:80px;
        }

        .card::before, .card::after {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            transform: scale3d(0, 0, 1);
            transition: transform .3s ease-out 0s;
            background: rgba(255, 255, 255, 0.1);
            content: '';
            pointer-events: none;
        }
        .card::before {
            transform-origin: left top;
        }
        .card::after {
            transform-origin: right bottom;
        }
        .card:hover::before, .card:hover::after, .card:focus::before, .card:focus::after {
            transform: scale3d(1, 1, 1);
        }
    </style>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mt-2">
    <div class="row">
        <c:forEach items="${listBooks}" var="book">
        <div class="col-md-3 col-sm-6">
                <div class="card card-block">
                    <h4 class="card-title text-right"><i class="material-icons">${book.author}</i></h4>
                    <img  src="data:image/jpg;base64,${book.base64Image}"  alt="photo">
                    <h5 class="card-title mt-3 mb-3">${book.title}</h5>
                    <p class="card-text">${book.description}</p>
                </div>
        </div>
        </c:forEach>

    </div>

</div>

</body>
</html>
