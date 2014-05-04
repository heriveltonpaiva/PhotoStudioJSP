<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Cadastrar Album</h3>
  </div>
  <div class="panel-body">

 <form method="POST" action="AlbumServlet">
            Nome:
            <input type="text" name="descricao" value="${desc}" size="50" class="form-control" /><br>
            Observação:
            <textarea name="obs" rows="6" cols="34" class="form-control">
            ${obser}
            </textarea><br>
            
            <c:if test="${op eq 'a'}">
             <input type="submit" value="Salvar Alteração" name="alterar"  class="btn btn-success" />
            </c:if>
            <c:if test="${op != 'a'}">
            <input type="submit" value="Cadastrar" name="cadastrar"  class="btn btn-success" />
       ${mensagem}
        </c:if>
        </form>
        
              
</div>
</div>
<%@ include file="footer.jsp" %>