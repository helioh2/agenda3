<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar contatos</title>
</head>
<body>

<table>
<tr>
<td> Nome: </td>
<td> Endereço: </td>
<td> Email: </td>
<td> Data de Nascimento: </td>
</tr>
<jsp:useBean id="dao" class="br.ufpr.dao.ContatoDao"/>
<%
//ContatoDao dao = new ContatoDao();

for (Contato contato: dao.getLista()) {
	%>
	<tr>
	<td> <% out.print(contato.getNome()); %>  </td>
	<td> <% out.print(contato.getEndereco()); %> </td>
	<td> <% out.print(contato.getEmail()); %> </td>
	<td> <% out.print(new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime())); } %> </td>
	</tr>


</table>

</body>
</html>