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
public class SrvBuscarLibros extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/buscarLibros.jsp");
		rd.forward(request, response);
	}
}
