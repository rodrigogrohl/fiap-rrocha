<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadatro Usuarios</title>
</head>
<body>
	<form action="cadlivros" method="post"
					enctype="multipart/form-data">
		
		<label for="codigo">Código </label>
		<input type="text" name="codigo"><p>
		
		<label for="titulo">Título </label>
		<input type="text" name="titulo"><p>
		
		<label for="autor">Autor </label>
		<input type="text" name="autor"><p>
		
		<label for="datapub">Publicação </label>
		<input type="date" name="datapub"><p>
		
		<label for="preco">Preço </label>
		<input type="text" name="preco"><p>
		
		<label for="foto">Capa </label>
		<input type="file" name="foto" id="foto">
		
		<input type="submit" value="Enviar">
	</form>
	${msgCadastros}
</body>
</html>