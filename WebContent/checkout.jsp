<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.heraizen.domain.Products"%>
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
	double totalprice=0;
	%>
	
	<h3>Ready To delivery</h3>
	
	<table>
		<tr>
			<th>name</th>
			<th>price</th>
			<th>Order Id</th>
			
		</tr>
		<%
			for (Products product : products) {
			totalprice+=product.getPrice();		
		%>
		<tr>
			<td><%=product.getPname()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getPid() %></td>
		</tr>
		<%
			}
		%>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
		<td>Total price:</td>
		<td><%=totalprice %></td>
		<td></td>
		</tr>
		</table>
		<a href="delivery.jsp">Deliver</a><br><br>
		<a href="viewproducts">View Cart</a>
</body>
</html>