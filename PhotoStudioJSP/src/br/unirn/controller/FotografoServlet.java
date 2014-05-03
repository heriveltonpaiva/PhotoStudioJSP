package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.dao.FotografoDao;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Fotografo;
import br.unirn.dominio.Gestor;

/**
 * Servlet implementation class FotografoController
 */
@WebServlet("/FotografoServlet")
public class FotografoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	FotografoDao fotografoDao = new FotografoDao();
	
	
    public FotografoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Fotografo> listaFotografo;
		try {
			listaFotografo = fotografoDao.findAll();
			request.setAttribute("listaFotografo", listaFotografo);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/gestor/formFotografo.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String usuario = (String) session.getAttribute("usuario");
		
		//TABELA FOTOGRAFO
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Fotografo fotografo = new Fotografo();
        
        fotografo.setCpfFotografo(cpf);
        fotografo.setNome(nome);
        fotografo.setLogin(login);
        fotografo.setSenha(senha);
        
        //TABELA ENDERE�O
        
        String end = request.getParameter("end");
        int numero = Integer.parseInt(request.getParameter("num"));
        String cep = request.getParameter("cep");
        String compl = request.getParameter("complemento");
        
        Endereco endereco = new Endereco();
        
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setComplemento(compl);
        endereco.setDescricao(end);
        
        // TABELA BAIRRO
        
        String bairro = request.getParameter("bairro");
        
        Bairro b = new Bairro();
        b.setDescricao(bairro);
        
        //TABELA CIDADE
        String cidade = request.getParameter("cidade");
        
        Cidade c = new Cidade();
        c.setDescricao(cidade);
        
        //ESTADO
        String estado = request.getParameter("estado");
        
        Estado e = new Estado();
        
        e.setDescricao(estado);
        
        //TABELA CONTATO
        String tel = request.getParameter("tel"); 
        String cel = request.getParameter("cel");
        String email = request.getParameter("email");

        Contato contato = new  Contato();
        
        contato.setCelular(cel);
        contato.setEmail(email);
        contato.setTelefone(tel);
        
        Gestor gestor = new Gestor();
       
        HttpSession sessao = request.getSession(false);
        
        int id_gestor =  (Integer) sessao.getAttribute("id_usuario");
        
        gestor.setIdGestor(id_gestor);
        
        
			try {
				fotografoDao.adicionarUsuario(fotografo, endereco, b, c, e, contato, gestor);
			} catch (SQLException e1) {
				System.out.println("Erro:"+e1.getMessage()+"Causa"+e1.getCause());
				e1.printStackTrace();
			}
	
			
			List<Fotografo> listaFotografo;
			try {
				listaFotografo = fotografoDao.findAll();
				request.setAttribute("listaFotografo", listaFotografo);	        
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListFotografoServlet");
			dispatcher.forward(request, response);
			
	}
		
	

}
