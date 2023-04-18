<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- FORMLÁRIO PRODUTO parte de foto -->

<div class="form-group form-default  input-group mb-4 ">
																<div class="input-group-prepared">

																	<c:if
																		test="${modelProduto.fotoproduto != '' && modelProduto.fotoproduto != null}">
																		<!-- Pegando o contexto da aplicação  request.getContextPath()-->
																		<a
																			href="<%= request.getContextPath()%>/ServletProdutoController?acao=downloadFoto&id=${modelProduto.id}">
																			<img alt="Imagem Produto" id="fotoembase64"
																			src="${modelProduto.fotouser}" width="70px">
																		</a>
																	</c:if>

																	<c:if
																		test="${modelProduto.fotoproduto == '' || modelProduto.fotoproduto == null}">
																		<img alt="Imagem User" id="fotoembase64"
																			src="assets/images/produtos.png" width="70px">
																	</c:if>

																</div>
																<input type="file" id="filefoto" name="filefoto"
																	accept="image/*"
																	onchange="visualizarimg('fotoembase64','filefoto');"
																	class="form-control-file"
																	style="margin-top: 15px; margin-left: 5px">
															</div>




</body>
</html>