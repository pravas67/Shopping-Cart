<%@page import="com.heraizen.domain.Products"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Your cart items:.....</h3>
	<%
		List<Products> products = (List<Products>) request.getAttribute("products");
	String checkoutlink =null;
	%>
	<%
		if (products.size() == 0) {
	%>
	<h3>cart is Empty</h3>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>name</th>
			<th>price</th>
			<th>remove</th>
		</tr>
		<%
			for (Products product : products) {
					String pid = product.getPid();
					String removelink = "remove?pid=" + pid;
					 checkoutlink = "checkout?pid=" + pid;
		%>
		<tr>
			<td><%=product.getPname()%></td>
			<td><%=product.getPrice()%></td>
			<td><a href="<%=removelink%>">Remove</a></td>
		</tr>
		<%
			}
			}
		%>

		<%-- <c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.getPname()}"></c:out></td>
				<td><c:out value="${product.getPrice()}"></c:out></td>
				<td><a href="checkout?pid=" +${product.getPid()}>checkout</a></td>
				<td><a href="${link}">Remove</a></td>
			</tr>
		</c:forEach> --%>

	</table>
	<a href="checkout">Checkout</a><br><br>
	<a href="viewproducts">View Products</a>
</body>
</html>