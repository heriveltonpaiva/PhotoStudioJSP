<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Cadastrar Foto</h3>
  </div>
  <div class="panel-body">

<form method="POST" action="../../FotoServlet" enctype="multipart/form-data">
            <div class="col-sm-3">
            Nome:
            <input type="text" name="descricao" value="" size="50" class="form-control"/>
            </div>
            <div class="col-sm-1">
            Valor:
            <input type="text" name="valor" value="" size="15" class="form-control"/>
            </div>
            <div class="col-sm-6">
            Observação:
            <input type="text" name="obs" class="form-control">
           
            </div>
            <div class="col-sm-3">
            Arquivo:
            <input type="file" name="photo" value="" size="30" />
           </div>
           <div class="col-sm-3">
            Escolha um Album:
            <select name="Album" class="form-control">
                <option>Album da Familia</option>
                <option>Album da Escola</option>
            </select><br>
            </div> 
            <div class="col-sm-2">      
            <input type="submit" value="Cadastrar" name="cadastrar" class="btn btn-success" style="margin-top: 20px;" />
             <input type="reset" value="Limpar" name="cadastrar" class="btn btn-warning" style="margin-top: 20px;" />
            </div>
        </form>

</div>
</div>

<%@ include file="footer.jsp" %>