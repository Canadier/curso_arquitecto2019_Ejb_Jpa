<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Pedido"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<c:choose>
			<c:when test="${not empty requestScope.pedidos}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Producto</th>
							<th>Categoria</th>
							<th>Precio</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pedido" items="${requestScope.pedidos}">
							<tr>
								<td>${pedido.idPedido}</td>
								<td>${pedido.producto}</td>
								<td>${pedido.categoria}</td>
								<td>${pedido.precio}</td>
								<td><a	href="Controller?op=doEliminar&id=${pedido.idPedido}">Eliminar</a></td>
								<td><a	href="Controller?op=doEditar&id=${pedido.idPedido}">Editar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise> <!-- El control realmente se realiza en el controller, aquí no entraría nunca es simplemente para explicar el uso del "otherwise" -->
				<h1>Sin pedidos</h1>
			</c:otherwise>
		</c:choose>

		<div class="col-sm-10">

			<a type="button" href='Controller?op=toEntrada'	class="btn btn-default">Volver</a>
		</div>
	</div>

</body>
</html>