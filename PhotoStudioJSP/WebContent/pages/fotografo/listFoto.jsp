   
<%@ include file="header.jsp" %>

<div class="panel panel-default">
<div class="panel-heading">Album de Fotos</div>
<div class="panel-body">
 
  <form method="POST" action="ListFotoServlet"> 
<div class="col-sm-3">
         
            <select name="album" class="form-control" style="margin-top: 20px;">
               <option >-- Selecione o Album --</option>
              <c:forEach items="${listaAlbum}" var="obj">
                <option value="${obj.idAlbum}">${obj.descricao}</option>
              
               </c:forEach>
            </select><br>
            </div> 
            <div class="col-sm-1">
 <input type="submit" value="Pesquisar" name="pesquisar" class="btn btn-warning" style="margin-top: 20px;" />

</div>   
         
</form>
</div>
 
  <!-- Default panel contents -->
  <div class="panel-heading">Lista de Fotos</div>

<c:if test="${empty listaFotos}">
	<h1>Lista vazia</h1>
</c:if>
  <!-- Table -->
  <c:if test="${not empty listaFotos}">
  <table class="table">
  <thead>
                <tr>
                    <th>Nome</th>
                    <th>Valor </th>
                    <th>Data Upload </th>
                    <th>Observação</th>
                    <th>Imagem</th>
                    <th>Ações</th>                  
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaFotos}" var="foto">
                <tr>
                    <td>${foto.descricao}</td>
                    <td>${foto.valor}</td>
                    <td>${foto.dataUpload}</td>
                    <td>${foto.obs}</td>
                    <td><img src="images/photo${foto.idFoto}.jpg"  width="200" height="200"/></td>
                      <td><a href="ListFotoServlet?op=a&id=${foto.idFoto}">Alterar</a> <br> <a href="ListFotoServlet?op=e&id=${foto.idFoto}">Excluir</a> </td>
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