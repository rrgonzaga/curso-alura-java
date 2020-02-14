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
		O m�todo "GET" � utilizado para enviar par�metros na URL, e que ele � problem�tico quando estamos trabalhando 
		com par�metros muito longos. Al�m disso, nem sempre queremos mostrar esses par�metros.
		
		J� o m�todo "POST" esconde os par�metros no corpo da requisi��o, sem mostr�-los na URL.
	 -->
	 
	 <!-- Aula 05 - Atividade 08 - Usando a taglib core 
		* Uso da taglib core url e atruindo o value da url a uma vari�vel; 
		* Imprimindo o valor de uma vari�vel da taglib core no body do HTML usando EL - Expression Language 
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