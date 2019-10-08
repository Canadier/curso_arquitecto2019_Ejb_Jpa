<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Pedido"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<%Pedido p=(Pedido)request.getAttribute("pedido"); %>
<div class="container">
	<h1>Formulario vertical</h1>
	<form action="Controller?op=doModificar&idPedido=<%=p.getIdPedido()%>" method="post">
		<div class="form-group">
			<label>Producto:</label><input type="text" name="producto" value="<%=p.getProducto() %>" class="form-control" style="width:30%" placeholder="Producto" autocomplete="name"/>
		</div>
		<div class="form-group">
			<label>Precio:</label><input type="number" name="precio" value="<%=p.getPrecio() %>" class="form-control" style="width:30%" placeholder="Precio"/>
		</div>
		<div class="form-group">
			<label>Categoría:</label><input type="text" name="categoria" value="<%=p.getCategoria() %>" class="form-control" style="width:30%" placeholder="Categoria"/>
		</div>
		<button type="submit" class="btn btn-default">Enviar</button>
		
	</form>
	

</div>

</body>
</html>