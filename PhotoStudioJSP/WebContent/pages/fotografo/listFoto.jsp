   
<%@ include file="header.jsp" %>

<div class="panel panel-default">
<div class="panel-heading">Meus Albuns</div>
<div class="panel-body">
   <h4>Escolha um Album:</h4>
   <select name="Album" size="5" >
                <option>Album da Familia</option>
                <option>Album da Escola</option>
            </select>
            <button type="submit" >Listar Fotos</button>
            
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
                    <th>Observação</th>
                    <th>Imagem</th>
                    <th>Ações</th>                  
                </tr>
            </thead>
            <tbody>
                  <c:forEach items="${listaFotos}" var="foto">
                <tr>
                    <td>${foto.idFoto}</td>
                    <td>${foto.valor}</td>
                    <td>${foto.obs}</td>
                    <td><img src="images/photo${foto.idFoto}.jpg"  width="200" height="200"/></td>
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