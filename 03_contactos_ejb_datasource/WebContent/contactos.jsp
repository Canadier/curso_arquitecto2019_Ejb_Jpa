<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Contacto,daos.DaoContactos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Contacto> listaContactos=(List<Contacto>)request.getAttribute("contactos");
	%>
<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Edad</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
	<%for(Contacto contacto:listaContactos){
		  int id = contacto.getIdContacto();%>
      <tr>
        <td><%=id %></td>
        <td><%=contacto.getNombre() %></td>
        <td><%=contacto.getEmail() %></td>
        <td><%=contacto.getEdad() %></td>
        <td><a href="Controller?op=doEliminar&id=<%=id%>">Eliminar</a></td>
      </tr>
      <%} %>
    </tbody>
  </table>
	
    <div class="col-sm-10">
		
		<a type="button" href='Controller?op=toEntrada' class="btn btn-default">Volver</a>
	</div>
</div>

</body>
</html>