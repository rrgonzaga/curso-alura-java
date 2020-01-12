<% 
	//Scriptlet
	String nomeEmpresa = (String)request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>
<HTML>
	<!-- Minha primeira página JSP - Java Server Page -->
	<Body>
		<span> Empresa <%=nomeEmpresa %> cadastrada com sucesso! </span>
	</Body>		
</HTML>