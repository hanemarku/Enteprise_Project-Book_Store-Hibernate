<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<%--<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/animsition/3.2.1/js/animsition.min.js" integrity="sha512-A6ariLe+TnwXgF0FtGuOAZB4MuNxxS1W+NvJZxN3fcXYtcrxHu7Z8yJ2MBk7MwnZuG70ksTGdAUyUEbbXW6Imw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>

<script defer src="https://use.fontawesome.com/releases/v5.15.4/js/solid.js" integrity="sha384-/BxOvRagtVDn9dJ+JGCtcofNXgQO/CCCVKdMfL115s3gOgQxWaX/tSq5V8dRgsbc" crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.15.4/js/fontawesome.js" integrity="sha384-dPBGbj4Uoy1OOpM4+aRGfAOc0W37JkROT+3uynUgTHZCHZNMHfGXsmmvYTffZjYO" crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<link href="../css/user_form.css" rel="stylesheet" type="text/css">
<link href="../css/category_form.css" rel="stylesheet" type="text/css">
<%--<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<script type="text/javascript" src="../js/user_form.js"></script>
<script type="text/javascript" src="../js/category_form.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.css" integrity="sha512-phGxLIsvHFArdI7IyLjv14dchvbVkEDaH95efvAae/y2exeWBQCQDpNFbOTdV1p4/pIa/XtbuDCnfhDEIXhvGQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/hamburgers/1.2.1/hamburgers.min.css" integrity="sha512-+mlclc5Q/eHs49oIOCxnnENudJWuNqX5AogCiqRBgKnpoplPzETg2fkgBFVC6WYUVxYYljuxPNG8RE7yBy1K+g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animsition/3.2.1/css/animsition.css" integrity="sha512-JEslR3QY8qua/uihUh9OGYKdPpPEt4r0m0sZ1y2F9rJ6N3ITYApyDP1+rD+Rwy0nnk/qGjtZhmqB3+Hi6QP3Ug==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>




<link href="../css/frontend.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/frontend.js"></script>


<nav class="navbar navbar-expand-custom navbar-mainbg">
    <a class="navbar-brand navbar-logo" href="#"> <img style="width: 120px;" src="../images/adrion-ltd-logo.jpg"></a>
    <a class="navbar-brand navbar-logo" href="#"> Welcome, <c:out value="${sessionScope.useremail}" /> |  <a href="logout">Logout</a></a>

    <button class="navbar-toggler" type="button" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars text-white"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <div class="hori-selector"><div class="left"></div><div class="right"></div></div>
            <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);">Dashboard</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="list_users"> &nbsp; <i class="fas fa-user"></i>Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="list_category">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-bars"></i>Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="list_books">&nbsp;<i class="fas fa-users"></i>Books</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="list_customer">&nbsp;<i class="fas fa-users"></i>Customers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);">&nbsp;<i class="fas fa-eye"></i>Reviews</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);">&nbsp;<i class="fas fa-truck"></i>Orders</a>
            </li>
        </ul>
    </div>
</nav>


<i class="fa-duotone fa-users"></i>

