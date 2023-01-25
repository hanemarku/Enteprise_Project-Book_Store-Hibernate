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
    <jsp:include page="header.jsp"></jsp:include>
    <title>ADRION Library - Online Book Store</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.2.0/css/glide.core.min.css" integrity="sha512-YQlbvfX5C6Ym6fTUSZ9GZpyB3F92hmQAZTO5YjciedwAaGRI9ccNs4iw2QTCJiSPheUQZomZKHQtuwbHkA9lgw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.2.0/css/glide.theme.min.css" integrity="sha512-wCwx+DYp8LDIaTem/rpXubV/C1WiNRsEVqoztV0NZm8tiTvsUeSlA/Uz02VTGSiqfzAHD4RnqVoevMcRZgYEcQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.2.0/glide.js" integrity="sha512-vZGsugWaSqQZuW8N5Z3ild7Tk8NqiZjKffeIQGpnnIs6g7HVZaFZjlLKPIw1qDsrQ5KAxAGfBinglQWu6i/8DA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <style>
        .glide__slide img{
            width: 100%;
        }

        .glide__slide{
            filter: blur(4px);
            opacity: .8;
            transition: .3s linear;
        }

        .glide__slide--active{
            opacity: 1;
            filter: none;
            transform: scale(1.1);
        }

        .glide__slides{
            overflow: visible;
        }
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

    <div align="center">
        <h3>This is main content</h3>
        <h3>New books</h3>
        <div class="images glide" style="text-align: center;">
            <div class="glide__track" data-glide-el="track">
                <ul class="glide__slides">
                    <c:forEach items="${listNewBooks}" var="book">
                    <li class="glide__slide">
                        <img src="data:image/jpg;base64,${book.base64Image}" alt="">
                        <c:forTokens items="${book.ratingStars} " delims="," var="star">
                            <c:if test="${star eq 'on'}">
                                <img style="width: 20px;" src="images/rating_on.png">
                            </c:if>
                            <c:if test="${star eq 'off'}">
                                <img style="width: 20px;"  src="images/rating_off.png">
                            </c:if>
                            <c:if test="${star eq 'half'}">
                                <img style="width: 20px;"  src="images/rating_half.png">
                            </c:if>
                        </c:forTokens>
                        <div>
                            <i>by ${book.author}</i>
                        </div>
                        <div>$ ${book.price}</div>
                    </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="glide__arrows" data-glide-el="controls">
                <button class="glide__arrow glide__arrow--left" data-glide-dir="<"><i class="fas fa-arrow-left"></i></button>
                <button class="glide__arrow glide__arrow--right" data-glide-dir=">"><i class="fas fa-arrow-right"></i></button>
            </div>
        </div>
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
<script>
    new Glide(".images",{
        type: 'carousel',
        perView: 3,
        focusAt: 'center',
        gap: 40,
        autoplay: 2000,
        breakpoints: {
            1200:{
                perView: 3
            },
            800:{
                perView: 2
            }
        }
    }).mount();
</script>
</html>
