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
		O m�todo "GET" � utilizado para enviar par�metros na URL, e que ele � problem�tico quando estamos trabalhando 
		com par�metros muito longos. Al�m disso, nem sempre queremos mostrar esses par�metros.
		
		J� o m�todo "POST" esconde os par�metros no corpo da requisi��o, sem mostr�-los na URL.
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