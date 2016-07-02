package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.dao.AlbumDao;
import br.unirn.dao.CarrinhoDao;
import br.unirn.dao.SelecaoDao;
import br.unirn.dominio.Carrinho;
import br.unirn.dominio.Selecao;

/**
 * Servlet implementation class FotoServlet
 */
@WebServlet("/ListCarrinhoServlet")
@MultipartConfig(maxFileSize = 2177215) /* Foto Tamanho M�ximo 2MB */
public class ListCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CarrinhoDao dao = new CarrinhoDao();
	AlbumDao albumDao = new AlbumDao();
	SelecaoDao selecaoDao = new SelecaoDao();
    public ListCarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
		List<Carrinho> listaCarro;
		try {
			listaCarro = dao.findAllCarrinho();

			request.setAttribute("listaCarro", listaCarro);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/cliente/listCarrinho.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		Integer id = (Integer) sessao.getAttribute("id_usuario");
		
		String quant = request.getParameter("quantidade");
		String tamanho = request.getParameter("tamanho");
		String idFoto = request.getParameter("idfoto");
		String valorFoto = request.getParameter("valor");
		
		double valor_venda = Integer.parseInt(quant)* Double.parseDouble(valorFoto);
		
		Carrinho novo = new Carrinho();
		
		novo.setIdClienteCliente(id);
		
		Selecao selecao = new Selecao();
		
		selecao.setIdcliente(id);
		selecao.setQuantidade(Integer.parseInt(quant));
		selecao.setTamanho(tamanho);
		selecao.setValor_venda(valor_venda);
		selecao.setIdfoto(Integer.parseInt(idFoto));
		try {
			selecao.setIdfotografo(albumDao.findByIdFoto(Integer.parseInt(idFoto)));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			selecaoDao.adicionarSelecaoCarrinho(selecao, novo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
