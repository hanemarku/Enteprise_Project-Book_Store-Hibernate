<%--
  Created by IntelliJ IDEA.
  customer: DELL
  Date: 1/18/2023
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create New Book</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../js/jquery-ui.min.css"></script>




</head>

<style>

    /* ==========================================================================
       #FONT
       ========================================================================== */
    .font-robo {
        font-family: "Roboto", "Arial", "Helvetica Neue", sans-serif;
    }

    /* ==========================================================================
       #GRID
       ========================================================================== */
    .row {
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-flex-wrap: wrap;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
    }

    .row-space {
        -webkit-box-pack: justify;
        -webkit-justify-content: space-between;
        -moz-box-pack: justify;
        -ms-flex-pack: justify;
        justify-content: space-between;
    }

    .col-2 {
        width: -webkit-calc((100% - 60px) / 2);
        width: -moz-calc((100% - 60px) / 2);
        width: calc((100% - 60px) / 2);
    }

    @media (max-width: 767px) {
        .col-2 {
            width: 100%;
        }
    }

    /* ==========================================================================
       #BOX-SIZING
       ========================================================================== */
    /**
     * More sensible default box-sizing:
     * css-tricks.com/inheriting-box-sizing-probably-slightly-better-best-practice
     */
    html {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }

    * {
        padding: 0;
        margin: 0;
    }

    *, *:before, *:after {
        -webkit-box-sizing: inherit;
        -moz-box-sizing: inherit;
        box-sizing: inherit;
    }

    /* ==========================================================================
       #RESET
       ========================================================================== */
    /**
     * A very simple reset that sits on top of Normalize.css.
     */
    body,
    h1, h2, h3, h4, h5, h6,
    blockquote, p, pre,
    dl, dd, ol, ul,
    figure,
    hr,
    fieldset, legend {
        margin: 0;
        padding: 0;
    }

    /**
     * Remove trailing margins from nested lists.
     */
    li > ol,
    li > ul {
        margin-bottom: 0;
    }

    /**
     * Remove default table spacing.
     */
    table {
        border-collapse: collapse;
        border-spacing: 0;
    }

    /**
     * 1. Reset Chrome and Firefox behaviour which sets a `min-width: min-content;`
     *    on fieldsets.
     */
    fieldset {
        min-width: 0;
        /* [1] */
        border: 0;
    }

    button {
        outline: none;
        background: none;
        border: none;
    }

    /* ==========================================================================
       #PAGE WRAPPER
       ========================================================================== */
    .page-wrapper {
        min-height: 100vh;
    }

    body {
        font-family: "Roboto", "Arial", "Helvetica Neue", sans-serif;
        font-weight: 400;
        font-size: 14px;
    }

    h1, h2, h3, h4, h5, h6 {
        font-weight: 400;
    }

    h1 {
        font-size: 36px;
    }

    h2 {
        font-size: 30px;
    }

    h3 {
        font-size: 24px;
    }

    h4 {
        font-size: 18px;
    }

    h5 {
        font-size: 15px;
    }

    h6 {
        font-size: 13px;
    }

    /* ==========================================================================
       #BACKGROUND
       ========================================================================== */
    .bg-blue {
        background: #2c6ed5;
    }

    .bg-red {
        background: #fa4251;
    }

    /* ==========================================================================
       #SPACING
       ========================================================================== */
    .p-t-100 {
        padding-top: 100px;
    }

    .p-t-180 {
        padding-top: 180px;
    }

    .p-t-20 {
        padding-top: 20px;
    }

    .p-t-30 {
        padding-top: 30px;
    }

    .p-b-100 {
        padding-bottom: 100px;
    }

    /* ==========================================================================
       #WRAPPER
       ========================================================================== */
    .wrapper {
        margin: 0 auto;
    }

    .wrapper--w960 {
        max-width: 960px;
    }

    .wrapper--w680 {
        max-width: 680px;
    }

    /* ==========================================================================
       #BUTTON
       ========================================================================== */
    .btn {
        line-height: 40px;
        display: inline-block;
        padding: 0 25px;
        cursor: pointer;
        color: #fff;
        font-family: "Roboto", "Arial", "Helvetica Neue", sans-serif;
        -webkit-transition: all 0.4s ease;
        -o-transition: all 0.4s ease;
        -moz-transition: all 0.4s ease;
        transition: all 0.4s ease;
        font-size: 14px;
        font-weight: 700;
    }

    .btn--radius {
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
    }

    .btn--green {
        background: #57b846;
    }

    .btn--green:hover {
        background: #4dae3c;
    }

    /* ==========================================================================
       #DATE PICKER
       ========================================================================== */
    td.active {
        background-color: #2c6ed5;
    }

    input[type="date" i] {
        padding: 14px;
    }

    .table-condensed td, .table-condensed th {
        font-size: 14px;
        font-family: "Roboto", "Arial", "Helvetica Neue", sans-serif;
        font-weight: 400;
    }

    .daterangepicker td {
        width: 40px;
        height: 30px;
    }

    .daterangepicker {
        border: none;
        -webkit-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        display: none;
        border: 1px solid #e0e0e0;
        margin-top: 5px;
    }

    .daterangepicker::after, .daterangepicker::before {
        display: none;
    }

    .daterangepicker thead tr th {
        padding: 10px 0;
    }

    .daterangepicker .table-condensed th select {
        border: 1px solid #ccc;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
        font-size: 14px;
        padding: 5px;
        outline: none;
    }

    /* ==========================================================================
       #FORM
       ========================================================================== */
    input {
        outline: none;
        margin: 0;
        border: none;
        -webkit-box-shadow: none;
        -moz-box-shadow: none;
        box-shadow: none;
        width: 100%;
        font-size: 14px;
        font-family: inherit;
    }

    /* input group 1 */
    /* end input group 1 */
    .input-group {
        position: relative;
        margin-bottom: 32px;
        border-bottom: 1px solid #e5e5e5;
    }

    .input-icon {
        position: absolute;
        font-size: 18px;
        color: #ccc;
        right: 8px;
        top: 50%;
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        transform: translateY(-50%);
        cursor: pointer;
    }

    .input--style-2 {
        padding: 9px 0;
        color: #666;
        font-size: 16px;
        font-weight: 500;
    }

    .input--style-2::-webkit-input-placeholder {
        /* WebKit, Blink, Edge */
        color: #808080;
    }

    .input--style-2:-moz-placeholder {
        /* Mozilla Firefox 4 to 18 */
        color: #808080;
        opacity: 1;
    }

    .input--style-2::-moz-placeholder {
        /* Mozilla Firefox 19+ */
        color: #808080;
        opacity: 1;
    }

    .input--style-2:-ms-input-placeholder {
        /* Internet Explorer 10-11 */
        color: #808080;
    }

    .input--style-2:-ms-input-placeholder {
        /* Microsoft Edge */
        color: #808080;
    }

    /* ==========================================================================
       #SELECT2
       ========================================================================== */
    .select--no-search .select2-search {
        display: none !important;
    }

    .rs-select2 .select2-container {
        width: 100% !important;
        outline: none;
    }

    .rs-select2 .select2-container .select2-selection--single {
        outline: none;
        border: none;
        height: 36px;
    }

    .rs-select2 .select2-container .select2-selection--single .select2-selection__rendered {
        line-height: 36px;
        padding-left: 0;
        color: #808080;
        font-size: 16px;
        font-family: inherit;
        font-weight: 500;
    }

    .rs-select2 .select2-container .select2-selection--single .select2-selection__arrow {
        height: 34px;
        right: 4px;
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-pack: center;
        -webkit-justify-content: center;
        -moz-box-pack: center;
        -ms-flex-pack: center;
        justify-content: center;
        -webkit-box-align: center;
        -webkit-align-items: center;
        -moz-box-align: center;
        -ms-flex-align: center;
        align-items: center;
    }

    .rs-select2 .select2-container .select2-selection--single .select2-selection__arrow b {
        display: none;
    }

    .rs-select2 .select2-container .select2-selection--single .select2-selection__arrow:after {
        font-family: "Material-Design-Iconic-Font";
        content: '\f2f9';
        font-size: 18px;
        color: #ccc;
        -webkit-transition: all 0.4s ease;
        -o-transition: all 0.4s ease;
        -moz-transition: all 0.4s ease;
        transition: all 0.4s ease;
    }

    .rs-select2 .select2-container.select2-container--open .select2-selection--single .select2-selection__arrow::after {
        -webkit-transform: rotate(-180deg);
        -moz-transform: rotate(-180deg);
        -ms-transform: rotate(-180deg);
        -o-transform: rotate(-180deg);
        transform: rotate(-180deg);
    }

    .select2-container--open .select2-dropdown--below {
        border: none;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
        -webkit-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        border: 1px solid #e0e0e0;
        margin-top: 5px;
        overflow: hidden;
    }

    /* ==========================================================================
       #TITLE
       ========================================================================== */

    .title {
        text-transform: uppercase;
        font-weight: 700;
        margin-bottom: 37px;
    }

    /* ==========================================================================
       #CARD
       ========================================================================== */
    .card {
        overflow: hidden;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
        background: #fff;
    }

    .card-2 {
        -webkit-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        box-shadow: 0px 8px 20px 0px rgba(0, 0, 0, 0.15);
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
        width: 100%;
        display: table;
    }

    .card-2 .card-heading {
        background: url("../images/bg-heading-02.jpg") top left/cover no-repeat;
        width: 29.1%;
        display: table-cell;
    }

    .card-2 .card-body {
        display: table-cell;
        padding: 80px 90px;
        padding-bottom: 88px;
    }

    @media (max-width: 767px) {
        .card-2 {
            display: block;
        }
        .card-2 .card-heading {
            width: 100%;
            display: block;
            padding-top: 300px;
            background-position: left center;
        }
        .card-2 .card-body {
            display: block;
            padding: 60px 50px;
        }
    }

</style>
<body>
<jsp:directive.include file="header.jsp"></jsp:directive.include>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
<%--                <c:if test="${customer != null}">--%>
                    <h2>Edit Profile</h2>
<%--                </c:if>--%>
<%--                <c:if test="${customer == null}">--%>
<%--                    <h2 class="title">Register as a Customer</h2>--%>
<%--                </c:if>--%>

<%--                <c:if test="${customer != null}">--%>
<%--                <form action="update_customer" method="POST" >--%>
<%--                    <input type="hidden" name="customerId" value="${customer.customerId}">--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${customer == null}">--%>
                    <form action="update_profile" method="POST" id="profileForm" >

<%--                        </c:if>--%>
                    <div class="input-group">
                    <input class="input--style-2" id="email" type="email" placeholder="Email" name="email" value="${loggedCustomer.email}">
                    </label><span class="error" id='message3'></span></span>
                    </div>
                    <div class="input-group">
                    <input class="input--style-2" type="text" id="fullname" placeholder="Full Name" name="fullname" value="${loggedCustomer.fullname}" required>
                    </label><span class="error" id='message6'></span></span>
                    </div>
                    <div class="input-group">
                    <input class="input--style-2" type="password" id="password" placeholder="Password - Leave blank if you do not want to change password" name="password" >
                    </label><span class="error" id='message1'></span></span>
                    </div>

                    <div class="input-group">
                        <input class="input--style-2" type="password" id="conf_password" placeholder="Confirm Password" name="conf_password" >
                        </label><span class="error" id='message10'></span></span>
                    </div>

                    <div class="input-group">
                    <input class="input--style-2" type="text" id="phone" placeholder="Phone Number" name="phone" value="${loggedCustomer.phone}" required>
                    </label><span class="error" id='message4'></span></span>
                    </div>
                    <div class="input-group">
                    <input class="input--style-2" type="text" id="address" placeholder="Address" name="address" value="${loggedCustomer.address}" required>
                    </label><span class="error" id='message5'></span></span>
                    </div>
                    <div class="input-group">
                    <input class="input--style-2" type="text" id="zip" placeholder="Zip Code" name="zip" value="${loggedCustomer.zipcode}" required>
                    </label><span class="error" id='message2'></span></span>
                    </div>
                            <div class="input-group">
                                <input class="input--style-2" type="text" id="city" placeholder="Country" name="city" value="${loggedCustomer.city}" required>
                                </label><span class="error" id='message8'></span></span>
                            </div>
                    <div class="input-group">
                    <input class="input--style-2" type="text" id="country" placeholder="Country" name="country" value="${loggedCustomer.country}" required>
                    </label><span class="error" id='message7'></span></span>
                    </div>

                    <button type="submit" class="btn btn-success">Edit</button>
                            <button class="btn btn-danger" onclick="history.go(-1);">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $('.description').richText();

    $(document).ready(function() {
        $("#publishDate" ).datepicker();
        $('#bookImage').change(function (){
            showImageThumbnail(this);
        })
    });

    function showImageThumbnail(fileInput){
        var file = fileInput.files[0];
        var reader = new FileReader();
        reader.onload = function(e){
            $('#thumbnail').attr('src', e.target.result);
        };
        reader.readAsDataURL(file);
    }

</script>
</html>
