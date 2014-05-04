<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Carrinho de Compras</div>

  <c:if test="${empty listaCarro}">
	<h1>Não há Fotos no Carrinho</h1>
</c:if>
  <!-- Table -->
  <c:if test="${not empty listaCarro}">
  <table class="table">
  <thead>
                <tr>
                    <th>Nome da Foto</th>
                    <th>Valor R$</th>
                    <th>Observação</th>
                    <th>Quantidade</th> 
                    <th>Tamanho</th> 
                    <th>Total R$</th>        
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaCarro}" var="car">
                <tr>
                    <td>${car.idSelecaoSelecao.idFotoFoto.descricao}</td> 
                    <td>${car.idSelecaoSelecao.idFotoFoto.valor}</td> 
                    <td>${car.idSelecaoSelecao.idFotoFoto.obs}</td>
                    <td>${car.idSelecaoSelecao.quantidade}</td>
                    <td>${car.idSelecaoSelecao.tamanho}</td>
                    <td>${car.idSelecaoSelecao.valor_venda}</td>
                                  
                     
                     <td> <a href="">Visualizar</a><br><a href="">Alterar</a> <br> <a href="">Excluir</a> </td>
                    
                    
                </tr>
                </c:forEach>
            </tbody>
    </table>
    </c:if>
  <ul class="pager">
  <li><a href="#">Proximo</a></li>
  <li><a href="#">Anterior</a></li>
</ul>
  
   
   <form  method="POST" action="ListHistoricoServlet">                   
   <button type="reset" class="btn btn-info">Esvaziar Carrinho</button>
   <button type="submit" class="btn btn-success">Finalizar Compra</button>
    </form>
</div>

<%@ include file="footer.jsp" %>