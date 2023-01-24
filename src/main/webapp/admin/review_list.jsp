<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/12/2023
  Time: 12:23 PM
  To change this template use File | Settingsss | File Templates.
--%>

<html>

<head>
    <title>Categories</title>
    <style>
        div.dataTables_wrapper {
            margin-bottom: 3em;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
<jsp:directive.include file="header.jsp"></jsp:directive.include>


<h2>Reviews Management</h2>

<c:if test="${message != null}">
    <div class="alert alert-success center m-2" role="alert">
            ${message}
    </div>
</c:if>

<table id="myTable" class="display" style="width:100%">
    <thead>
    <tr>
        <th>Index</th>
        <th>ID</th>
        <th>Book</th>
        <th>Rating</th>
        <th>Headline</th>
        <th>Customer</th>
        <th>Review On</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="review" items="${listReviews}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${review.reviewId}</td>
            <td>${review.book.title}</td>
            <td>${review.rating}</td>
            <td>${review.headline}</td>
            <td>${review.customer.fullname}</td>
            <td>${review.reviewTime}</td>
            <td>
                <a type="button" class="btn btn-danger" href="javascript:confirmDeleteReview(${review.reviewId})">Delete</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>

    </tfoot>
</table>

<jsp:directive.include file="footer.jsp"></jsp:directive.include>

</body>

<script>
    $(document).ready( function () {
        $('#myTable').DataTable();
    });

    function confirmDeleteReview(reviewId){
        Swal.fire({
            title: "Are you sure you want to delete review with ID " + reviewId + " ?",
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                window.location = 'delete_review?id=' + reviewId;
            }
        })
    }
</script>

</html>
