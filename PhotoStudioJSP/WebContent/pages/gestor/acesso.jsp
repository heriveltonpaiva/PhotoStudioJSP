<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Alterar Login</h3>
  </div>
  <div class="panel-body">
    
    <form method="POST" action="GestorServlet">
         Login:
            <input type="text" name="login" value="" size="30" class="form-control" /><br>
            Senha:
            <input type="password" name="senha" value="" size="30"  class="form-control"/><br>
            
            <input type="submit" value="Salvar Altera��o" name="cadastrar" class="btn btn-success"/>
        </form>  
   </div>
   </div> 

<%@ include file="footer.jsp" %>