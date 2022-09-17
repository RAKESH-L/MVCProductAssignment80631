<%@page import="com.spring.main.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section>
		<div>
			<h1>All Products</h1>
			<%
				List<Product> list = (List<Product>) request.getAttribute("list");
				
				Product product = (Product)request.getAttribute("product");
		
				for (Product p : list) {
			%>
			<%=p %> &nbsp;<a href="<%=request.getContextPath()%>/delete-product?id=<%=p.getId()%>"
			onclick='return confirm("Are you sure you want to delete?")'>delete</a>
			
			&nbsp;|&nbsp; <a href="<%=request.getContextPath()%>/edit-product?id=<%=p.getId()%>">edit</a>
			<br />
			
			<%
				}
			%>
		</div>
		<div>
		<% String flag = (String)request.getAttribute("flag");  %>
			
			<%if(flag == null) {%>
			<h3>Add Product</h3>
			<form action="<%=request.getContextPath()%>/insert-product" method="get">
				<label>Name: </label>
				<input type="text" name="pname"> 
						<br /><br /> 
				<label>Product Description: </label> 
				<input type="text" name="pdescription" > 
				<br /><br /> 
				<label>Category: </label> 
				<input type="text" name="pcategory"> 
				<br /><br /> 
				<label>Product Price: </label> 
				<input type="number" name="pprice"> 
				<br /><br /> 
				<input type="submit" value="Add Product">
			</form>
			<%} else { %>
			<h3>Edit Product</h3>
			<form action="<%=request.getContextPath()%>/edit-product-op" method="get">
				<input type="hidden" name="id" value="<%=product.getId() %>"> 
				<label>Name: </label>
				<input type="text" name="pname" value="<%=product.getName() %>" readonly="readonly"> 
						<br /><br /> 
				<label>Product Description: </label> 
				<input type="text" name="pdescription" value="<%=product.getDescription() %>"> 
				<br /><br /> 
				<label>Category: </label> 
				<input type="text" name="pcategory" value="<%=product.getCategory() %>"> 
				<br /><br /> 
				<label>Product Price: </label> 
				<input type="number" name="pprice" value="<%=product.getPrice() %>"> 
				<br /><br /> 
				<input type="submit" value="Edit Product">
			</form>
			<%} %>
		</div>

	</section>

</body>
</html>