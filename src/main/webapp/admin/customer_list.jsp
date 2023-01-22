<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/12/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>

<html>

<head>
    <title>Customers</title>
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
<a type="button" class="btn btn-success" href="customer_form.jsp">Create new customer</a>

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
        <th>City</th>
        <th>Country</th>
        <th>Register Date</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${listCustomer}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${customer.customerId}</td>
            <td>${customer.email}</td>
            <td>${customer.fullname}</td>
            <td>${customer.city}</td>
            <td>${customer.country}</td>
            <td><fmt:formatDate pattern="MM/dd/yyyy" value='${customer.registerDate}'/> </td>



            <td>
                <a type="button" class="btn btn-warning" href="edit_customer?id=${customer.customerId}">Edit</a>
                <a type="button" class="btn btn-danger" href="javascript:confirmDeleteCustomer(${customer.customerId})">Delete</a>

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

    function confirmDeleteCustomer(categoryId){
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
                window.location = 'delete_customer?id=' + categoryId;
            }
        })
    }
</script>

</html>
