
<%@page import="java.util.List"%>
<%@page import="tulibro.beans.Libro"%>
<%
	String user = (String) session.getAttribute("user");
	List<Libro> libros = (List<Libro>) session.getAttribute("libros");
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
		<form id="form1" name="form1" method="post"
			action="/TuLibroEnCasa/servlet/SrvSeleccionarLibros">
			<h2>RESULTADOS DE LA B&Uacute;SQUEDA</h2>
			<br /> <br />
			<table>
				<tr>
					<td>&nbsp;</td>
					<td><b> Cantidad </b></td>
					<td><b>    ISBN </b></td>
					<td><b> T&iacute;tulo </b></td>
					<td><b> Autor </b></td>
					<td><b> Categor&iacute;a </b></td>
					<td><b> Editorial </b></td>
					<td><b> PRECIO UNIDAD </b></td>
				</tr>

				<%
					Libro libro = null;
					for (int i = 0; i < libros.size(); i++) {
						libro = libros.get(i);
				%>
				<tr>

					<td><input name="check" type="checkbox" value="" /></td>
					<td><input name="cantidad" type="text" size="4" maxlength="4"
						value="<%=libro.getStock()%>" /></td>
					<td><input name="isbn" type="text" size="13" maxlength="13"
						value="<%=libro.getIsbn()%>" /></td>
					<td><input name="titulo" type="text" size="30" maxlength="30"
						value="<%=libro.getTitulo()%>" /></td>
					<td><input name="autor" type="text" size="50" maxlength="50"
						value="<%=libro.getAutor()%>" /></td>
					<td><input name="categoria" type="text" size="30"
						maxlength="30" value="<%=libro.getCategoria()%>" /></td>
					<td><input name="editorial" type="text" size="50"
						maxlength="50" value="<%=libro.getEditorial()%>" /></td>
					<td><input name="precio" type="text" size="7" maxlength="7"
						value="<%=libro.getPrecio()%>" /></td>

				</tr>
				<%
					}
				%>
			</table>
			<br /> <br /> <br /> <input name="comprar" type="submit"
				value="Seleccionar" />
		</form>
	</center>

</body>
</html>