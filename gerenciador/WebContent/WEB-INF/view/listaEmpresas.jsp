<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Tag Library</title>
</head>
<body>
<!-- 		Aula 05 - Atividade 05 - Conhecendo JSTL  -->
<%-- 		* Substituindo scriptlet por JSTL - Java Standard Tag Library (tags) e por Expression Language - EL (${}) --%>
<!-- 		* Refatorando o código usando Taglib, EL e tags HTML. -->
<!-- 		* JSTL é a biblioteca padrão de tags do Java, mas existem outras bibliotecas. Por exemplo, o Spring MVC possui a sua própria. -->
<!-- 		* JSTL não vem embutido com o Tomcat. Precisamos adicionar a lib do JSTL para poder usá-la.  -->

	<div>
		<span>Usuário logado: ${usuarioLogado.login}</span>
	</div>
	<div>
		<c:if test="${not empty empresa}">
			<span>Empresa ${empresa} cadastrada com sucesso!</span>
		</c:if>
	</div>
	
	<div>
		Lista de empresas: 
	</div>
	<ul>
		<c:forEach items="${empresas}" var="empresa">			
			<li>
				${empresa.nome}, data de abertura: <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
			</li>
		</c:forEach>	
	</ul>
	
<!-- 	<ul> -->
<%-- 		<%List<Empresa> empresas = (List<Empresa>)request.getAttribute("empresas"); %>		 --%>
<%-- 		<%for(Empresa empresa : empresas) { %> --%>
<%-- 			<li><%=empresa.getNome()%></li> --%>
<%-- 		<%} %>	 --%>
<!-- 	</ul> -->
	

</body>
</html>