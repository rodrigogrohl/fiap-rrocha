<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadatro Usuarios</title>
</head>
<body>
	<form action="cadusuarios" method="post">
		<label for="usuario">Usuário </label><input type="text" name="usuario"><p>
		<label for="senha">Senha</label><input type="password" name="senha"><p>
		<select name="nivel" id="nivel">
			<option value="1">Administrator</option>
			<option value="2">User</option>
		</select>
		<input type="submit" value="Enviar">
	</form>
	${msgCadastros}
</body>
</html>