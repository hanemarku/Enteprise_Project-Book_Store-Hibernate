<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/18/2023
  Time: 7:27 PM
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


<h2>Books Management</h2>
<a type="button" class="btn btn-success" href="book_form.jsp">Create new book</a>

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
        <th>Image</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
        <th>Last Updated</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${listBooks}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${book.bookId}</td>
            <td>
                <img width="120px" src="data:image/jpg;base64,${book.base64Image}" />
            </td>
            <td>${book.author}</td>
            <td>${book.categoryId}</td>
            <td>$ ${book.price}</td>
            <td><fmt:formatDate pattern="MM/dd/yyyy" value='${book.publishDate}'/> </td>
            <td>
                <a type="button" class="btn btn-warning" href="edit_book?id=${book.bookId}">Edit</a>
                <a type="button" class="btn btn-danger" href="javascript:confirmDeleteBook(${book.bookId})">Delete</a>

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

    function confirmDeleteBook(bookId){
        Swal.fire({
            title: "Are you sure you want to delete book with ID " + bookId + " ?",
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                window.location = 'delete_book?id=' + bookId;
            }
        })
    }
</script>

</html>
