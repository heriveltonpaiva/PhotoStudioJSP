<%@ include file="header.jsp" %>


<div class="panel panel-default">
   <c:if test="${empty listaVendas}">
	<h1>Não há Histórico de Compras</h1>
</c:if>
  <!-- Table -->
  <c:if test="${not empty listaVendas}">
  <table class="table">
  <thead>
                <tr>
                     <th>Venda</th>
                    <th>Nome da Foto</th>                  
                    <th>Quantidade</th>
                    <th>Tamanho</th> 
                    <th>Total R$</th>
                    <th>Observação </th>
                    <th>Data da Venda</th>               
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaVendas}" var="venda">
                <tr>
                    <td>${venda.descricao}</td> 
                    <td>${venda.idSelecaoSelecao.idFotoFoto.descricao}</td>                 
                    <td>${venda.idSelecaoSelecao.quantidade}</td>
                    <td>${venda.idSelecaoSelecao.tamanho}</td>
                    <td>${venda.idSelecaoSelecao.valor_venda}</td>    
                    <td>${venda.idSelecaoSelecao.idFotoFoto.obs}</td>                              
                    <td>${venda.dataVenda}</td>                       
                </tr>
                </c:forEach>
            </tbody>
    </table>
    </c:if>
  <ul class="pager">
  <li><a href="#">Proximo</a></li>
  <li><a href="#">Anterior</a></li>
</ul>
  
</div>

<%@ include file="footer.jsp" %>