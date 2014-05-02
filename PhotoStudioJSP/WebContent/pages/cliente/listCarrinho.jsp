<%@ include file="header.jsp" %>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Carrinho de Compras</div>

  <!-- Table -->
  <table class="table">
   <thead>
                <tr>
                    <th>Descrição</th>
                    <th>Valor </th>
                    <th>Quantidade</th>
                    <th>Tamanho</th>
                    <th>Total</th>
                    <th>Imagem</th>
                    <th>Ações</th>                  
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Foto de Familia</td>
                    <td>30,00</td>
                    <td>2</td>
                    <td>15x20</td>
                    <td>60,00</td>
                    <td> <img src="" width="100" height="100" alt="foto"/>
                    </td>
                    <td><a href="">Alterar</a> <br> <a href="">Excluir</a> </td>
                    
                </tr>
                 <tr>
                    <td>Foto de Familia</td>
                    <td>30,00</td>
                    <td>2</td>
                    <td>15x20</td>
                    <td>60,00</td>
                    <td> <img src="" width="100" height="100" alt="foto"/>
                    </td>
                    <td><a href="">Alterar</a> <br> <a href="">Excluir</a> </td>
                    
                </tr>
                <tr>
                    <td>Foto de Familia</td>
                    <td>30,00</td>
                    <td>2</td>
                    <td>15x20</td>
                    <td>60,00</td>
                    <td> <img src="" width="100" height="100" alt="foto"/>
                    </td>
                    <td><a href="">Alterar</a> <br> <a href="">Excluir</a> </td>
                    
                </tr>
            </tbody>
  </table> 
  <ul class="pager">
  <li><a href="#">Proximo</a></li>
  <li><a href="#">Anterior</a></li>
</ul>
  
   <button type="submit" class="btn btn-info">Esvaziar Carrinho</button>
   <button type="submit" class="btn btn-success">Finalizar Compra</button>
</div>

<%@ include file="footer.jsp" %>