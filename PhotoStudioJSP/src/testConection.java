import java.sql.SQLException;

import br.unirn.dao.Conexao;


public class testConection {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		Conexao.getConexao();  

	}

}
