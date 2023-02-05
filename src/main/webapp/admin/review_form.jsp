<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/style.css" >
	<title>Edit Review</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">Edit Review</h2>
	</div>
	
	<div align="center">
		<form action="update_review" method="post" style="max-width: 700px; margin: 0 auto;">
		<input type="hidden" name="reviewId" value="${review.reviewId}">

		
		<table class="form">
			<tr>
				<td align="right">Book:</td>
				<td align="left"><b>${review.book.title}</b></td>
			</tr>
			<tr>
				<td align="right">Rating:</td>
				<td align="left"><b>${review.rating}</b></td>
			</tr>
			<tr>
				<td align="right">Customer:</td>
				<td align="left"><b>${review.customer.fullname}</b></td>
			</tr>
			<tr>
				<td align="right">Headline:</td>
				<td align="left">
					<input type="text" size="60" name="headline" value="${review.headline}" required minlength="10" maxlength="128" />
				</td>
			</tr>
			<tr>
				<td align="right">Comment:</td>
				<td align="left">
					<textarea rows="5" cols="70" name="comment" required>${review.comment}</textarea>
				</td>
			</tr>			
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<input type="button" id="buttonCancel" value="Cancel" onclick="history.go(-1);" />
				</td>
			</tr>				
		</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>