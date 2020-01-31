<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		Lista de empresas: 
	</div>
	<ul>
		<%List<Empresa> empresas = (List<Empresa>)request.getAttribute("empresas"); %>		
		<%for(Empresa empresa : empresas) { %>
			<li><%=empresa.getNome()%></li>
		<%} %>	
	</ul>

</body>
</html>