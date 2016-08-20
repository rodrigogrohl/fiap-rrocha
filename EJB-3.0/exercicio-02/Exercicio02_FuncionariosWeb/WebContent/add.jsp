<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD Worker</title>
</head>
<body>
	<h1>Adicionar Funcionario</h1>
	
	<form action="funcionario" method="post">
		CPF: <input type="text" name="cpf"> <br>
		Nome: <input type="text" name="nome"> <br>
		Cargo: <input type="text" name="cargo"> <br>
		Salario: <input type="text" name="salario"> <br>
		INSS: <input type="text" name="inss"> <br>
		<input type="submit" value="Enviar">
	</form>	
	<!-- 
	<ul>
		<c:forEach var="liv" items="${lista}">
			<li>${liv.titulo}</li>
		</c:forEach>
	</ul>
	 -->
</body>
</html>