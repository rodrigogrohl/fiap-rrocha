<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Livros Cadastrados</title>
</head>
<body>
	<h1>Lista de Livros Cadastrados</h1>
	<jsp:useBean id="livros" class="br.com.fiap.bean.LivrosBean" />
	<table>
		<tr>
			<td>Nome</td>
			<td>Autor</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		
		<c:forEach var="livro" items="${livros.lista}" >
			<tr>
				<td>${livro.titulo}</td>
				<td>${livro.autor }</td>
				<td>
					<a href="consultarLivro?codigo=${livro.codigo}" >Detalhes</a>
				</td>
				<td> + </td>
			</tr>	
		</c:forEach>
	</table>
	
</body>
</html>