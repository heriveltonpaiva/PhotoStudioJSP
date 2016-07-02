package br.unirn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unirn.dao.AlbumDao;
import br.unirn.dominio.Album;

/**
 * Servlet implementation class AlbumController
 */
@WebServlet("/AlbumServlet")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AlbumDao dao = new AlbumDao();
	
    public AlbumServlet() {
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
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/formAlbum.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descricao = request.getParameter("descricao");
		String obs = request.getParameter("obs");
		
		 if(descricao.equals("")&& obs.equals("")){
			 
			 request.setAttribute("mensagem","Preencha os Campos Obrigat�rios"); 
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/formAlbum.jsp");
		     dispatcher.forward(request, response);
		 }else{
		
		 HttpSession sessao = request.getSession(false);
	        
	        int id_fotografo =  (Integer) sessao.getAttribute("id_usuario");
		
	        Date data = new Date();
		Album album = new Album();
		
		album.setDescricao(descricao);		
		album.setData(data);
		album.setObs(obs);
		
		
		try {
			dao.insert(album, id_fotografo);
			request.setAttribute("mensagem","Registro Inserido com Sucesso !!!"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
		
		
	}
	

}
