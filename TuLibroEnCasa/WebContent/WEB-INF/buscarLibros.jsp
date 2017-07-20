<%
	String user = (String)session.getAttribute("user");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda de libros</title>
</head>
<body>
USUARIO:
<b><%=user%></b>
<center>
<form id="form1" name="form1" method="post" action="/TuLibroEnCasa/servlet/SrvSeleccionarLibros">
<h2>RESULTADOS DE LA B&Uacute;SQUEDA</h2>
<br />
<br />
<table>
	<tr>
        <td>&nbsp;</td>
        <td><b>Cantidad </b></td>
        <td><b>ISBN </b></td>
        <td><b>T&iacute;tulo </b></td>
        <td><b>Autor </b></td>
        <td><b>Categor&iacute;a </b></td>
        <td><b>Editorial </b></td>    
        <td><b>PRECIO UNIDAD </b></td>
	</tr>
	</table>
	<br />
<br />
<br />
<input name="comprar" type="submit" value="Seleccionar" />
</form>
</center>

</body>
</html>