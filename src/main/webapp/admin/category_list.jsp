<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/12/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
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


<h2>Category Management</h2>
<a type="button" class="btn btn-success" href="category_form.jsp">Create new category</a>

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
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${listCategory}" varStatus="status">
    <tr>
        <td>${status.index + 1}</td>
        <td>${category.categoryId}</td>
        <td>${category.name}</td>
        <td>
            <a type="button" class="btn btn-warning" href="edit_category?id=${category.categoryId}">Edit</a>
            <a type="button" class="btn btn-danger" href="javascript:confirmDeleteCategory(${category.categoryId})">Delete</a>

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

    function confirmDeleteCategory(categoryId){
            Swal.fire({
                title: "Are you sure you want to delete the category with ID " + categoryId + " ?",
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location = 'delete_category?id=' + categoryId;
                }
            })
    }
</script>

</html>
