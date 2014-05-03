package br.unirn.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.unirn.dao.FotoDao;
import br.unirn.dominio.Cliente;
import br.unirn.dominio.Foto;

/**
 * Servlet implementation class FotoServlet
 */
@WebServlet("/ListFotoServlet")
@MultipartConfig(maxFileSize = 2177215) /* Foto Tamanho M�ximo 2MB */
public class ListFotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FotoDao dao = new FotoDao();
	
    public ListFotoServlet() {
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
	
				
		List<Foto> listaFotos;
		try {
			listaFotos = dao.findAll();

			request.setAttribute("listaFotos", listaFotos);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listFoto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
