   
<%@ include file="header.jsp" %>

<div class="panel panel-default">

  <!-- Default panel contents -->
  <div class="panel-heading">Lista de Albuns</div>

<c:if test="${empty listaAlbum}">
	<h1>Lista vazia</h1>
</c:if>
<c:if test="${not empty listaAlbum}">
  <!-- Table -->
  <table class="table">
  <thead>
                <tr>
                    <th>Nome</th>
                    <th>Data de Criação</th>
                    <th>Observação</th>

                    <th>Ações</th>                  
                </tr>
            </thead>
            <tbody>
                   <c:forEach items="${listaAlbum}" var="album">
                <tr>
                    <td>${album.idAlbum}</td>
                    <td>${album.descricao}</td>
                    <td>${album.obs}</td>
                    
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
</div>
<%@ include file="footer.jsp" %>