<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Cadastrar Foto</h3>
  </div>
  <div class="panel-body">

<form method="POST" action="FotoServlet" enctype="multipart/form-data">
            <div class="col-sm-3">
            Nome:
            <input type="text" name="descricao" value="${desc}" size="50" class="form-control"/>
            </div>
            <div class="col-sm-1">
            Valor:
            <input type="text" name="valor" value="${valor}" size="15" class="form-control"/>
            </div>
            <div class="col-sm-6">
            Observaï¿½ï¿½o:
            <input type="text" name="obs" value="${obs}" class="form-control">
            
           
            </div>
            <div class="col-sm-3">
            Arquivo:
            <input type="file" name="photo"  size="30" />
           </div>
           <div class="col-sm-3">
            Escolha um Album:
            <select name="album" class="form-control">
              <c:forEach items="${listaAlbum}" var="obj">
                <option value="${obj.idAlbum}">${obj.descricao}</option>
              
               </c:forEach>
            </select><br>
            </div> 
            <div class="col-sm-2"> 
             <c:if test="${op eq 'a'}">
             <input type="submit" value="Salvar Alteração" name="alterar"  class="btn btn-success" style="margin-top: 20px;" />
            </c:if>
            <c:if test="${op != 'a'}">
            <input type="submit" value="Cadastrar" name="cadastrar"  class="btn btn-success" style="margin-top: 20px;"/>
             <input type="reset" value="Limpar" name="cadastrar" class="btn btn-warning" style="margin-top: 20px;" />
         
       ${mensagem}
        </c:if>
         </div>
        </form>

</div>
</div>

<%@ include file="footer.jsp" %>