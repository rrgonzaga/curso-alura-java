<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Login</title>
</head>
<body>
	<!-- 
		O método "GET" é utilizado para enviar parâmetros na URL, e que ele é problemático quando estamos trabalhando 
		com parâmetros muito longos. Além disso, nem sempre queremos mostrar esses parâmetros.
		
		Já o método "POST" esconde os parâmetros no corpo da requisição, sem mostrá-los na URL.
	 --> 
	 
	<form action="${linkEntradaServlet}" method="post">
		<div>		
			<input type=hidden name="acao" value="Login">	
				
			<label> Login: </label>
			<input type="text" name="login"/>
		</div>
		<br/>
		<div>
			<label> Senha: </label>
			<input type="password" name="senha"/>
		</div>
		<br/>
		<input type="submit" value="Enviar"/>	
	</form>	
	
</body>
</html>