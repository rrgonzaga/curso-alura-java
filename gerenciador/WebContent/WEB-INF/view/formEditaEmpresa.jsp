<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=AlteraEmpresa" var="linkAlteraEmpresa" />

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
	 
	 <!-- Aula 07 - Atividade 06 - formulário de alteração 
		* Uso da taglib core url e atribuindo o value da url a uma variável; 
		* Imprimindo o valor de uma variável da taglib core no body do HTML usando EL - Expression Language 
	-->
	
	<c:import url="logout-parcial.jsp" />
	 
	<form action="${linkAlteraEmpresa}" method="post">
		<div>
		<input type="hidden" name="id" value="${empresa.id}" />
		
		<label> Nome: </label>
		<input type="text" name="nome" value="${empresa.nome}"/>
		</div>
		<br/>
		<div>
		<label> Data abertura: </label>
		<input type="text" name="dataAbertura" value="<fmt:formatDate value='${empresa.dataAbertura}' pattern='dd/MM/yyyy'/>"/>
		</div>
		<br/>
		<input type="submit" value="Enviar"/>	
	</form>	
	
</body>
</html>