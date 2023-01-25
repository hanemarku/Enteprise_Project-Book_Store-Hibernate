<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/25/2023
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
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

<body>
<jsp:directive.include file="header.jsp"></jsp:directive.include>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<form action="submit_review" method="post" style="max-width: 800px; margin: 0 auto">
    <div class="row m-5">
        <div class="col"><h2>Your Reviews</h2></div>
        <div class="col">&nbsp;</div>
        <div class="col"><h4>${loggedCustomer.fullname}</h4></div>
    </div>
    <div class="row">
        <div class="col"><hr/></div>
    </div>
    <div class="row">
        <div class="col-sm">
            <h4>${book.title}</h4>
            <img class="img-fluid" src="data:image/jpg;base64,${book.base64Image}" />
        </div>
        <div class="col-sm">
            <div id="rateYo"></div>
            <input type="hidden" id="rating" name="rating" />
            <h2>${book.bookId}</h2>

            <input type="hidden" name="bookId" value="${book.bookId}" />
            <div>&nbsp;</div>
            <div>
                <input type="text" name="headline" class="form-control"
                       placeholder="Headline or summary for your review (required)" required minlength="10" maxlength="128" />
            </div>
            <div>&nbsp;</div>
            <div>
						<textarea name="comment" cols="70" rows="10" class="form-control"
                                  placeholder="Write your review details..." required minlength="10" maxlength="500" ></textarea>
            </div>
        </div>
    </div>
    <div>&nbsp;</div>
    <div class="row">
        <div class="col text-center">
            <button type="submit" class="btn btn-primary">Submit</button>
            &nbsp;&nbsp;
            <button type="button" onclick="history.go(-1)" class="btn btn-secondary">Cancel</button>
        </div>
    </div>
</form>

</body>

<script type="text/javascript">
    $(document).ready(function() {

        $("#rateYo").rateYo({
            starWidth: "40px",
            fullStar: true,
            onSet: function (rating, rateYoInstance) {
                $("#rating").val(rating);
            }
        });
    });
</script>

</html>

