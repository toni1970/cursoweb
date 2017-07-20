/*
 * Created on 23-may-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tulibro.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.jsp.*;
import javax.servlet.http.*;
import tulibro.bd.BdOperaciones;
import tulibro.beans.Libro;

/**
 * @author Administrador
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class SrvMostrarLibros extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//String stockString = request.getParameter("stock");
		//String isbnString = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
		//String editorial = request.getParameter("editorial");
		//String precioString = request.getParameter("precio");
		String opcionCondicion = request.getParameter("opcionCondicion");
		String opcionOrden = request.getParameter("opcionOrden");
		//
		//int stock = Integer.parseInt(stockString);
		//int isbn = Integer.parseInt(isbnString);
		//int precio = Integer.parseInt(precioString);

		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		List<Libro> listaLibros = bdOperaciones.mostrarBusqueda(  titulo, autor, categoria, opcionCondicion, opcionOrden);
		bdOperaciones.cerrarConexion();
		int tamano=listaLibros.size()+1;
		
		if (tamano > 0) {
			HttpSession sesion = request.getSession(true);
			Object user = null;
			sesion.setAttribute("user", user);
			sesion.setAttribute("libros", listaLibros);
			ServletContext ct = getServletContext();
			RequestDispatcher rd = ct.getRequestDispatcher("/mostrarLibros.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/buscarLibros.jsp");
		}

		// ServletContext ct = getServletContext();
		// RequestDispatcher rd = ct.getRequestDispatcher("/compraLibros.jsp");
		// rd.forward(request, response);
	}
}
