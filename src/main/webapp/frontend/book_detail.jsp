<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/21/2023
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:directive.include file="header.jsp"></jsp:directive.include>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <style>

        /*****************globals*************/
        body {
            font-family: 'open sans';
            overflow-x: hidden; }

        img {
            max-width: 100%; }

        .preview {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column; }
        @media screen and (max-width: 996px) {
            .preview {
                margin-bottom: 20px; } }

        .preview-pic {
            -webkit-box-flex: 1;
            -webkit-flex-grow: 1;
            -ms-flex-positive: 1;
            flex-grow: 1; }

        .preview-thumbnail.nav-tabs {
            border: none;
            margin-top: 15px; }
        .preview-thumbnail.nav-tabs li {
            width: 18%;
            margin-right: 2.5%; }
        .preview-thumbnail.nav-tabs li img {
            max-width: 100%;
            display: block; }
        .preview-thumbnail.nav-tabs li a {
            padding: 0;
            margin: 0; }
        .preview-thumbnail.nav-tabs li:last-of-type {
            margin-right: 0; }

        .tab-content {
            overflow: hidden; }
        .tab-content img {
            width: 100%;
            -webkit-animation-name: opacity;
            animation-name: opacity;
            -webkit-animation-duration: .3s;
            animation-duration: .3s; }

        .card {
            margin-top: 50px;
            background: #eee;
            padding: 3em;
            line-height: 1.5em; }

        @media screen and (min-width: 997px) {
            .wrapper {
                display: -webkit-box;
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex; } }

        .details {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column; }

        .colors {
            -webkit-box-flex: 1;
            -webkit-flex-grow: 1;
            -ms-flex-positive: 1;
            flex-grow: 1; }

        .product-title, .price, .sizes, .colors {
            text-transform: UPPERCASE;
            font-weight: bold; }

        .checked, .price span {
            color: #ff9f1a; }

        .product-title, .rating, .product-description, .price, .vote, .sizes {
            margin-bottom: 15px; }

        .product-title {
            margin-top: 0; }

        .size {
            margin-right: 10px; }
        .size:first-of-type {
            margin-left: 40px; }

        .color {
            display: inline-block;
            vertical-align: middle;
            margin-right: 10px;
            height: 2em;
            width: 2em;
            border-radius: 2px; }
        .color:first-of-type {
            margin-left: 20px; }

        .add-to-cart, .like {
            background: #ff9f1a;
            padding: 1.2em 1.5em;
            border: none;
            text-transform: UPPERCASE;
            font-weight: bold;
            color: #fff;
            -webkit-transition: background .3s ease;
            transition: background .3s ease; }
        .add-to-cart:hover, .like:hover {
            background: #b36800;
            color: #fff; }

        .not-available {
            text-align: center;
            line-height: 2em; }
        .not-available:before {
            font-family: fontawesome;
            content: "\f00d";
            color: #fff; }

        .orange {
            background: #ff9f1a; }

        .green {
            background: #85ad00; }

        .blue {
            background: #0076ad; }

        .tooltip-inner {
            padding: 1.3em; }

        @-webkit-keyframes opacity {
            0% {
                opacity: 0;
                -webkit-transform: scale(3);
                transform: scale(3); }
            100% {
                opacity: 1;
                -webkit-transform: scale(1);
                transform: scale(1); } }

        @keyframes opacity {
            0% {
                opacity: 0;
                -webkit-transform: scale(3);
                transform: scale(3); }
            100% {
                opacity: 1;
                -webkit-transform: scale(1);
                transform: scale(1); } }

        /*# sourceMappingURL=style.css.map */
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"><img  src="data:image/jpg;base64,${book.base64Image}"  alt="photo"></div>
                    </div>


                </div>
                <div class="details col-md-6">
                    <h3 class="product-title">${book.title}</h3>

                    <div>
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
                        <a href="#reviews">${fn:length(book.reviews)} Reviews</a>
                    </div>
                    <p class="product-description">${book.description}</p>
                    <h4 class="price">current price: <span>$ ${book.price}</span></h4>
                    <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>

                    <div class="action">
                        <button class="add-to-cart btn btn-default" type="button">add to cart</button>
                    </div>
                    <div>
                        <button class="btn btn-info m-5" id="buttonWriteReview">Write a review</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <h3> <a id="reviews">Customer Reviews</a></h3>
    <div>
        <table border="0">
            <c:forEach items="${book.reviews}" var="review">
                <tr class="p-5 m-5" style="padding-bottom: 20px;">
                    <td style="padding-top: 20px;" >
                        <c:forTokens items="${review.stars} " delims="," var="star">
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
                        - <b>${review.headline}</b>
                    </td>
                </tr>
                <tr>
                    <td>
                        by ${review.customer.fullname} on ${review.reviewTime}
                    </td>
                </tr>
                <tr><td><i>${review.comment}</i></td></tr>
                <td></td>
                <br>
            </c:forEach>
            <td></td>
        </table>
    </div>
</div>

</body>

<script type="text/javascript">
    $(document).ready(function (){
        $("#buttonWriteReview").click(function (){
            window.location = 'write_review?book_id=' + ${book.bookId};
        })
    })

</script>
</html>
