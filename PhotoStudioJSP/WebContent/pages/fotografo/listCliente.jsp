<%@ include file="header.jsp" %>


<div class="panel panel-default">

  <!-- Default panel contents -->
  <div class="panel-heading">Lista de Clientes</div>

<c:if test="${empty listaCliente}">
	<h1>Lista vazia</h1>
</c:if>

<c:if test="${not empty listaCliente}">
  <!-- Table -->
  <table class="table">
  
  <thead>
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Endereço</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Telefone</th>
                    <th>Celular</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach items="${listaCliente}" var="cli">
                <tr>
                    <td>${cli.idCliente}</td>
                    <td>${cli.nome}</td>
                    <td>${cli.cpf}</td>
                    <td>${cli.idEnderecoEndereco} </td>
                    
                    <td>${cli.idEnderecoEndereco}</td>
                    <td>${cli.idEnderecoEndereco}</td>
                    <td>${cli.idContatoContato}</td>
                    <td>${cli.idContatoContato}</td>
                      <td> <a href="">Visualizar</a><br><a href="">Alterar</a> <br> <a href="">Excluir</a> </td>
                </tr>
                </c:forEach>
            
            </tbody>
  
  </table>
  </c:if>
  </div>
  


<%@ include file="footer.jsp" %>