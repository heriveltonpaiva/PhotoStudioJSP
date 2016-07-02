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

import br.unirn.dao.AlbumDao;
import br.unirn.dao.FotoDao;
import br.unirn.dominio.Album;
import br.unirn.dominio.Foto;

/**
 * Servlet implementation class FotoServlet
 */
@WebServlet("/ListFotoServlet")
@MultipartConfig(maxFileSize = 2177215) /* Foto Tamanho M�ximo 2MB */
public class ListFotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FotoDao dao = new FotoDao();
	AlbumDao albumDao = new AlbumDao();
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
	    
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		
		
		if(op==null){
		List<Album> listaAlbum;
        try {
            listaAlbum = albumDao.findAll();
            request.setAttribute("listaAlbum", listaAlbum);         
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        
        
		List<Foto> listaFotos=null;
		

			request.setAttribute("listaFotos", listaFotos);	        
		
		
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listFoto.jsp");
		dispatcher.forward(request, response);
		}else if(op.equals("e")){
			
			try {
				albumDao.delete(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listFoto.jsp");
			dispatcher.forward(request, response);
			
		}else if(op.equals("a")){
			
			
			  try {
				Foto ft = dao.findById(Integer.parseInt(id));
				
				request.setAttribute("desc", ft.getDescricao());
				request.setAttribute("valor", ft.getValor());
				request.setAttribute("obs", ft.getObs());
				request.setAttribute("album", ft.getIdAlbumAlbum());
				request.setAttribute("op", op);
				List<Album> listaAlbum;
		        try {
		            listaAlbum = albumDao.findAll();
		            request.setAttribute("listaAlbum", listaAlbum);         
		        } catch (SQLException e2) {
		            // TODO Auto-generated catch block
		            e2.printStackTrace();
		        }
				
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/formFoto.jsp");
				dispatcher.forward(request, response);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		
		if(op==null){
		List<Album> listaAlbum;
        try {
            listaAlbum = albumDao.findAll();
            request.setAttribute("listaAlbum", listaAlbum);         
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        
		
		
		String id_album = request.getParameter("album");
		
		List<Foto> listaFotos;
		try {
			listaFotos = dao.findAllByIdAlbum(Integer.parseInt(id_album));

			request.setAttribute("listaFotos", listaFotos);	        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/fotografo/listFoto.jsp");
		dispatcher.forward(request, response);
		}else if(op.equals("e")){			
			doGet(request, response);
		}
	}
}
