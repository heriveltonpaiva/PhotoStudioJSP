package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.dao.ClienteDao;
import br.unirn.dao.FotografoDao;
import br.unirn.dao.GestorDao;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Fotografo;
import br.unirn.dominio.Gestor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	GestorDao gestorDao = new  GestorDao();
	ClienteDao clienteDao = new ClienteDao();
	FotografoDao fotografoDao = new FotografoDao();
	
	
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession sessao = request.getSession(true);
		
	    
	    
		String nome = request.getParameter("login");
		String senha = request.getParameter("senha");
		
       
		if(nome.equals("") && senha.equals("")){
		
			System.out.println("Nome do Usu�rio e senha vazio");
			
		}else{
		
		/*
		 * VERIFICAR SE O LOGIN E SENHA � DE UM GESTOR	
		 */
			
		try {
			for (Gestor g : gestorDao.findAll()) {
				
				if(g.getLogin().equals(nome) && g.getSenha().equals(senha)){
					
				    
				    sessao.setAttribute("usuario", g.getLogin());
			        sessao.setAttribute("id_usuario", g.getIdGestor());
			
					RequestDispatcher dispatcher = request.getRequestDispatcher("pages/gestor/index.jsp");
					dispatcher.forward(request, response);
					
				}
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
			
		/*
		 * VERIFICAR SE O LOGIN E SENHA � DE UM FOTOGRAFO
		 */
		
		try {
			for (Fotografo f : fotografoDao.findAll()) {
				
				if(f.getLogin().equals(nome) && f.getSenha().equals(senha)){
					
				    sessao.setAttribute("usuario", f.getNome());
                    sessao.setAttribute("id_usuario", f.getIdFotografo());
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/fotografo/index.jsp");
					dispatcher.forward(request, response);
					
				}
			
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * VERIFICAR SE O LOGIN E SENHA � DE UM CLIENTE
		 */
		
			try {
				for (Cliente c : clienteDao.findAll()) {

					if (c.getLogin().equals(nome) && c.getSenha().equals(senha)) {

					    
					    sessao.setAttribute("usuario", c.getNome());
	                    sessao.setAttribute("id_usuario", c.getIdCliente());
					    
						RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cliente/index.jsp");
						dispatcher.forward(request, response);

					}

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
