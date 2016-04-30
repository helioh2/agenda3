<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:import url="cabecalho.jsp"></c:import>

<!--  instanciar Dao -->
<jsp:useBean id="dao" class="br.ufpr.dao.ContatoDao"/> 

<table>
<tr>
<td> Nome: </td>
<td> Endere�o: </td>
<td> Email: </td>
<td> Data de Nascimento: </td>
</tr>

<c:forEach var="contato" items="${dao.lista}">
	<tr>
		<td> ${contato.nome}  </td>
		<td> ${contato.endereco}  </td>
		<td> 

		<c:choose>
			<c:when test="${not empty contato.email}">
				<a href="mailto:${contato.email}">${contato.email}</a>
			</c:when>
			<c:otherwise>
				E-mail n�o informado!
			</c:otherwise>
		</c:choose>

		</td>
		<td> <fmt:formatDate value="${contato.dataNascimento.time}"
					pattern="dd/MM/yyyy" />   </td>	
	</tr>

</c:forEach>



</table>

<c:import url="rodape.jsp"></c:import>

</body>
</html>