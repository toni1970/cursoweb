<%
	String user = (String)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Menu Libreria Virtual</title>
</head>
<body>
USUARIO:
<b><%=user%></b>
<center>
<h1>Libreria Virtual: Menu</h1>

<input name="comprar" value="Comprar Libros" onclick="javascript:location.href='/TuLibroEnCasa/servlet/SrvBuscarLibros';" type="button">
<br>
<br>
<input name="foro" value="Foro" type="button">
<br>
<br>
<input name="modificar" value="Modificar Datos" type="button">
<br>
<br>
</center>
</body>
</html>