<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Cadastrar Cliente</h3>
  </div>
  <div class="panel-body">
    
    <form method="POST" action="../../Cliente">
     <div class="col-sm-5">
            Nome:
            <input type="text" name="nome" value="aaa" size="50" class="form-control"/>
            </div>
            <div class="col-sm-3">
            CPF:
            <input type="text" name="cpf" value="bbb" size="30" class="form-control" />
            </div>
            <div class="col-sm-4">
            Endereço:
            <input type="text" name="end" value="ccccc" size="60" class="form-control"/>
             </div>
            <div class="col-sm-1">
            N°:
            <input type="text" name="num" value="12" size="5" class="form-control"/>
             </div>
             
            <div class="col-sm-2">
            CEP:
            <input type="text" name="cep" value="532432432" size="20" class="form-control"/>
             </div>
            <div class="col-sm-2">
            Complemento:
            <input type="text" name="complemento" value="sem" size="10" class="form-control" />
             </div>
            <div class="col-sm-3">
            Bairro:
            <input type="text" name="bairro" value="centro" size="20" class="form-control" />
             </div>
            <div class="col-sm-3">
            Cidade:
            <input type="text" name="cidade" value="macaiba" size="20" class="form-control"/>
             </div>
             <div class="col-sm-1">
            Estado:<br>
            <select name="UF:">
                <option>RN</option>
                <option>PB</option>
            </select>
            </div>
            <div class="col-sm-2">
            Telefone:
            <input type="text" name="tel" value="231321" size="30" class="form-control" />
             </div>
            <div class="col-sm-2">
            Celular:
            <input type="text" name="cel" value="321321321" size="30"  class="form-control"/>
             </div>
            <div class="col-sm-4">
            Email:
            <input type="text" name="email" value="heri@gmail" size="60" class="form-control"/>
             </div>
            
            <div class="col-sm-2">
            Login:
            <input type="text" name="login" value="heri" size="30" class="form-control" />
             </div>
            <div class="col-sm-2">
            Senha:
            <input type="password" name="senha" value="123456" size="30" class="form-control" />
             </div>
             <br><br>
             <div class="col-sm-4" style="margin-top:20px;">
            <input type="submit" value="Cadastrar" name="cadastrar" class="btn btn-success" />
            <input type="reset" value="Limpar" name="limpar" class="btn btn-warning" />
            </div>
        </form>
    
    
    
    
    
    
  </div>
</div>

<%@ include file="footer.jsp" %>