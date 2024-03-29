<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagens</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />">
<script type="text/javascript" src="<c:url value="/js/jquery-2.1.4.min.js"/>"></script>
</head>
<body>
	<c:import url="../menu.jsp"/>
	<fieldset>
		<legend>Lista de Postagens</legend>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Titulo do Post</th>
				<th>Permalink</th>
				<th>Data de Postagem</th>
				<th>Autor</th>
				<th>Categorias</th>
				<th>Ação</th>
			</tr>	
			<c:forEach var="postagem" items="${page.content}" varStatus="i">		
			<tr bgcolor='${i.count % 2 != 0 ? '#f1f1f1' : 'white'}'>
				<td>${postagem.id}</td>
				<td>${postagem.titulo}</td>
				<td>${postagem.permalink}</td>
				<td>
					<fmt:parseDate var="date" value="${postagem.dataPostagem}" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
					<fmt:formatDate value="${date}" type="both"/>
				</td>
				<td>${postagem.autor.nome}</td>
				<td>
					<c:forEach var="c" items="${postagem.categorias}">
						[ ${c.descricao} ]
					</c:forEach>
				</td>
				<td>					
					<c:url var="update" value="/postagem/update/${postagem.id}"/>
					<a href="${update}" title="Editar">&#9445</a>
					<c:url var="delete" value="/postagem/delete/${postagem.id}"/>
					<a href="${delete}" title="Excluir">&#9447</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<c:import url="../paginacao.jsp"/>
	</fieldset>
</body>
</html>