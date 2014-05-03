package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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

import br.unirn.dao.CarrinhoDao;
import br.unirn.dao.FotoDao;
import br.unirn.dao.VendaDao;
import br.unirn.dominio.Carrinho;
import br.unirn.dominio.Foto;
import br.unirn.dominio.Venda;

/**
 * Servlet implementation class FotoServlet
 */
@WebServlet("/ListHistoricoServlet")
@MultipartConfig(maxFileSize = 2177215) /* Foto Tamanho M�ximo 2MB */
public class ListHistoricoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	CarrinhoDao carrinhoDao = new CarrinhoDao();
	VendaDao vendaDao = new VendaDao();
    public ListHistoricoServlet() {
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
	
				
		List<Venda> listaVendas;
		try {
			listaVendas = vendaDao.findAll();

			request.setAttribute("listaVendas", listaVendas);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cliente/listHistorico.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     
		try {
			for (Carrinho car : carrinhoDao.findAll()) {
				
				Venda v = new Venda();
				
				v.setDescricao("Vendido");
				v.setDataVenda(new Date());
				v.setSelecao(car.getSelecao());
				
				vendaDao.insert(v);
				
				carrinhoDao.delete(car.getIdCarrinho());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cliente/listHistorico.jsp");
		dispatcher.forward(request, response);
	}
}
