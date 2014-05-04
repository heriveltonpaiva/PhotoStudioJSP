<%@ include file="header.jsp" %>


<div class="panel panel-default">

  <!-- Default panel contents -->
  <div class="panel-heading">Lista de Fotografos</div>


<c:if test="${empty listaFotografo}">
	<h1>Lista vazia</h1>
</c:if>

<c:if test="${not empty listaFotografo}">
  <!-- Table -->
  <table class="table">
  
  <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Endere�o</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>UF</th>
                    <th>Telefone</th>
                    <th>Celular</th>
                    <th>A��es</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listaFotografo}" var="fotografo">
                <tr>
                    <td>${fotografo.idFotografo}</td>
                    <td>${fotografo.nome}</td>
                    <td>${fotografo.cpfFotografo}</td>
                    <td>${fotografo.idEnderecoEndereco.descricao} </td>
                    
                    <td>${fotografo.idEnderecoEndereco.idBairroBairro.descricao}</td>
                    <td>${fotografo.idEnderecoEndereco.idBairroBairro.idCidadeCidade.descricao}</td>
                    <td>${fotografo.idEnderecoEndereco.idBairroBairro.idCidadeCidade.idEstadoEstado.descricao}</td>
                    <td>${fotografo.idContatoContato.telefone}</td>
                    <td>${fotografo.idContatoContato.celular}</td>
                      <td> <a href="">Visualizar</a><br><a href="">Alterar</a> <br> <a href="ListFotografoServlet?op=e&id=${fotografo.idFotografo}">Excluir</a> </td>
                </tr>
                </c:forEach>
                
            </tbody>
  
  </table>
  </c:if>
  </div>
  


<%@ include file="footer.jsp" %>