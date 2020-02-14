<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Aula 05 - Atividade 09 - Mais sobre forEach 
		* Exemplo do uso da taglib core forEach 
	-->
	
	<h4>Imprimindo números ímpares de 1 até 10</h4>
	<c:forEach var="i" begin="1" end="10" step="2">
       		${i} <br />
    </c:forEach>

</body>
</html>