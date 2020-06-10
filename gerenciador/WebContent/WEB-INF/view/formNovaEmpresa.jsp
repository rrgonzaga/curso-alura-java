<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--<c:url value="/entrada?acao=novaEmpresa" var="linkNovaEmpresa" />-->
<c:url value="/entrada" var="linkNovaEmpresa" />

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
	 
	<form action="${linkNovaEmpresa}" method="post">
		<div>		
		<input type=hidden name="acao" value="NovaEmpresa">		
		<label> Nome: </label>
		<input type="text" name="nome"/>
		</div>
		<br/>
		<div>
		<label> Data abertura: </label>
		<input type="text" name="dataAbertura"/>
		</div>
		<br/>
		<input type="submit" value="Enviar"/>	
	</form>	
	
</body>
</html>