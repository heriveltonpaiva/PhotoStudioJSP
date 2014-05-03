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
                    <th>ID</th>
                    <th>Descricao </th>
                    <th>Data</th>
                    <th>ID Seleção</th>            
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaVendas}" var="venda">
                <tr>
                    <td>${venda.idVenda}</td>
                    <td>${venda.descricao}</td>
                    <td>${venda.dataVenda}</td>
                   <td>${venda.selecao}</td>                                  
                                         
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