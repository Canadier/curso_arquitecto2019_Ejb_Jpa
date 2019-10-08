<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<c:set var="pedidos" value="${requestScope.pedidos}"/>
	<c:choose>
		<c:when test="${!empty pedidos}">
			<table border="1">
				<tr>
					<th>Producto</th><th>Precio</th><th>Categoría</th><th></th><th></th>
				</tr>
				<c:forEach var="con" items="${pedidos}">
					<tr>
						<td>${con.producto}</td>
						<td>${con.precio}</td>
						<td>${con.categoria}</td>
						<td><a href="Controller?op=doEliminar&idPedido=${con.idPedido}">Eliminar</a></td>
						<td><a href="Controller?op=doRecuperar&idPedido=${con.idPedido}">Editar</a></td>
					</tr>
				</c:forEach>
			</table>	
		</c:when>
		<c:otherwise>
			<h1>No hay pedidos</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<a href="Controller?op=toOpciones">Volver</a>
</body>
</html>