<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="valida" method="post">
		<label for="usuario">Usuário </label><input type="text" name="usuario"><p>
		<label for="senha">Senha</label><input type="text" name="senha"><p>
		<input type="submit" value="Enviar">
	</form>
	<% 
	String message = (String) request.getAttribute("msgValidacao");
	if(message != null)
		out.append(message);
	%>
</body>
</html>