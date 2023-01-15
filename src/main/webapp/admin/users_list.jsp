<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/12/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>

<html>

<head>
    <title>Title</title>
    <style>
        div.dataTables_wrapper {
            margin-bottom: 3em;
        }
    </style>
</head>
<body>
<jsp:directive.include file="header.jsp"></jsp:directive.include>

<h2>Users Management</h2>
<a type="button" class="btn btn-success" href="user_form.jsp">Create new user</a>

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
        <th>Email</th>
        <th>Full Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUsers}" varStatus="status">
    <tr>
        <td>${status.index + 1}</td>
        <td>${user.userId}</td>
        <td>${user.email}</td>
        <td>${user.fullName}</td>
        <td>
            <a type="button" class="btn btn-warning" href="edit_user?id=${user.userId}">Edit</a>
            <a type="button" class="btn btn-danger" href="javascript:confirmDelete(${user.userId})">Delete</a>

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

    function confirmDelete(userId){
        if(userId == 1){
            Swal.fire('The default admin user account cannot be deleted');
        }else{
            Swal.fire({
                title: "Are you sure you want to delete the user with ID " + userId + " ?",
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location = 'delete_user?id=' + userId;
                }
            })
        }

    }
</script>

</html>
