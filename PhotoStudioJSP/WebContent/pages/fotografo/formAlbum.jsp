<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Cadastrar Album</h3>
  </div>
  <div class="panel-body">

 <form method="POST" action="AlbumServlet">
            Nome:
            <input type="text" name="descricao" value="" size="50" class="form-control" /><br>
            Observa��o:
            <textarea name="obs" rows="6" cols="34" class="form-control">
            </textarea><br>
            <input type="submit" value="Cadastrar" name="cadastrar"  class="btn btn-success" />
        </form>
</div>
</div>
<%@ include file="footer.jsp" %>