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
                    <th>ID</th>
                    <th>ID Selecao </th>
                    <th>ID Cliente</th>
                    <th></th>            
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaCarro}" var="car">
                <tr>
                    <td>${car.idCarrinho}</td>
                    <td>${car.selecao}</td>
                    <td>${car.idClienteCliente}</td>
                   
                                  
                     
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