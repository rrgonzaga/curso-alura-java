<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	
	<!-- Aula 05 - Atividade 08 - Usando a taglib core 
		* Uso da taglib core if junto com EL - Expression Language 
	-->
	<Body>
	
		<c:import url="logout-parcial.jsp" />
			
		<c:if test="${not empty empresa}">
			<span>Empresa ${empresa} cadastrada com sucesso!</span>
		</c:if>
		
		<c:if test="${empty empresa}">
			<span>Nenhuma empresa cadastrada!</span>
		</c:if>
		
	</Body>		
</HTML>