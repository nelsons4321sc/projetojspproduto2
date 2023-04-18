<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img alt="Imagem Prodto" id="fotoembase64"
		src="${modelProduto.fotoproduto}" width="70px"
		onchange="visualizarimg('fotoembase64','filefoto');">


		  <a href="<%= request.getContextPath()%>/ServletProdutoController?id=${p.fotoproduto}>"></a>
		  
		   <td><img alt="Imagem User" id="fotoembase64" src="${modelProduto.fotoproduto}" width="30px"></td>

		



</body>
</html>