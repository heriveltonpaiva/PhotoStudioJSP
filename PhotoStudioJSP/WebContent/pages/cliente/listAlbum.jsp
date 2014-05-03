   
<%@ include file="header.jsp" %>

<div class="panel panel-default">

  <!-- Default panel contents -->

  <div class="panel-heading">Lista de Albuns</div>

<form action="" method="POST">

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
                    <th>Observação</th>
                    <th>Foto</th>   
                    <th>Quantidade e Tamanho</th>                 
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaFotos}" var="foto">
                <tr>
                    <td>${foto.idFoto}</td>
                    <td>${foto.valor}</td>
                    <td>${foto.obs}</td>
                    <td><img src="images/photo${foto.idFoto}.jpg"  width="200" height="200"/></td>
                     <td>
                    
                     <form  method="POST" action="ListCarrinhoServlet">
                     <input name="quantidade" type="number" style="width:60px;" />
                     <input name="idfoto" type="hidden" value="${foto.idFoto}" />
                     <input name="valor" type="hidden" value="${foto.valor}" />
                     <select name="tamanho" >
                      <option >-- Tamanho --</option>
                      <option > 15x20 </option>
                      <option > 30x30 </option>
                      <option > 50x50 </option>
                     </select>
                    <input type="submit" value="Adicionar ao Carrinho" name="adicionar" class="btn btn-info"  />
                     </form>
                    </td>
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