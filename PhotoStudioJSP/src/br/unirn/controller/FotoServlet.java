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
@WebServlet("/FotoServlet")
@MultipartConfig(maxFileSize = 2177215) /* Foto Tamanho M�ximo 2MB */
public class FotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FotoDao dao = new FotoDao();
	
    public FotoServlet() {
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
		
		String descricao = request.getParameter("descricao");
		String valor = request.getParameter("valor");
		String obs = request.getParameter("obs");
		
		 InputStream inputStream = null; // input stream of the upload file
         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
		
		 
		
		Foto foto = new Foto();
		
		foto.setContenttype(filePart.getContentType());
		foto.setFotoNome(filePart.getName());
		foto.setValor(Double.parseDouble(valor));
		foto.setFotoSize(filePart.getSize());
		foto.setDescricao(descricao);
		foto.setObs(obs);
		foto.setArquivo(inputStream);
	
		try {
			dao.insert(foto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        }
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
}