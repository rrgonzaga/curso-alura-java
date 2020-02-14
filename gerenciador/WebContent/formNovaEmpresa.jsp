<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		O método "GET" é utilizado para enviar parâmetros na URL, e que ele é problemático quando estamos trabalhando 
		com parâmetros muito longos. Além disso, nem sempre queremos mostrar esses parâmetros.
		
		Já o método "POST" esconde os parâmetros no corpo da requisição, sem mostrá-los na URL.
	 -->
	 
	 <!-- Aula 05 - Atividade 08 - Usando a taglib core 
		* Uso da taglib core url e atruindo o value da url a uma variável; 
		* Imprimindo o valor de uma variável da taglib core no body do HTML usando EL - Expression Language 
	-->
	 
	<form action="${linkServletNovaEmpresa}" method="post">
		<div>
		<label> Nome: </label>
		<input type="text" name="nome"/>
		</div>
		<br>
		<input type="submit" value="Enviar"/>	
	</form>	
	
</body>
</html>