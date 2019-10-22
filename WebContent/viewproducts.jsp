
<%@page import="com.heraizen.domain.Products"%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>
		Welcome: &nbsp<%=
		session.getAttribute("username")
	%>
	</h3>
	<table>
		<tr>
			<th>name</th>
			<th>price</th>
			<th>buy</th>
		</tr>
		 
		<%
		List<Products> products =  
        (List<Products>)request.getAttribute("products");
			for (Products product : products) {
				String pid=product.getPid();
				String link="addtocart?pid="+pid;
		%>
		<tr>
			<td><%=product.getPname()%></td> 
            <td><%=product.getPrice()%></td>
            <td><a href="<%=link%>">Add To cart</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="logout">logout</a>

</body>
</html>