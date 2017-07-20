/*
 * Created on 26-abr-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tulibro.bd;

import java.sql.*;
import java.text.Normalizer.Form;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

//import artupa.beans.Cliente;
import tulibro.beans.*;

//import tulibro.beans.*;

/**
 * @author Administrador
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class BdOperaciones extends BdBase {

	/**
	 * 
	 */
	public BdOperaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean validarUsuario(String user, String password) {
		boolean correcto = true;
		String sentenciaSql = null;

		try {
			sentenciaSql = "select usuario,password from cliente where" + " usuario='" + user + "' and password='"
					+ password + "'";
			System.out.println(sentenciaSql);
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			correcto = rs.next();
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Validación de usuario no efectuada correctamente");
			correcto = false;
		}

		return correcto;
	}

	public List<Libro> mostrarBusqueda(String titulo, String autor, String categoria, String opcionCondicion,
			String opcionOrden) {
		String sentenciaSql = null;
		String odenarpor = opcionOrden;
		int codategoria = Integer.parseInt(categoria);
		
		System.out.println("autor = "+autor);
		System.out.println("Titulo = "+titulo);
		System.out.println("Condicion = "+opcionCondicion);
		System.out.println("Categoria = "+categoria);
		System.out.println("Orden = "+opcionOrden);


		List<Libro> libros = new ArrayList<Libro>();
		
		sentenciaSql = "select l.stock, l.isbn , l.titulo, a.nom_autor, c.nom_categoria, e.nom_editorial, l.precio from autor a"
				+ " join libro l on a.cod_autor=l.cod_autor"
				+ " join categoria c on c.cod_categoria=l.cod_categoria"
				+ " join editorial e on e.cod_editorial=l.cod_editorial ";

		

		 if  (codategoria == 0)  {
			sentenciaSql += " where  l.titulo like '%"+titulo+"%' "+opcionCondicion +" a.nom_autor like '%"+autor+"%'";
		}
		 else{
			 sentenciaSql += "where c.cod_categoria="+codategoria+" and (l.titulo like '%"+titulo+"%' "+ opcionCondicion+" a.nom_autor like '%"+autor+"%')";
			
		 }
		 sentenciaSql +=" order by " + odenarpor;

		try {

			System.out.println(sentenciaSql);
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayMas = rs.next();
			Libro libro = null;
			while (hayMas) {
				libro = new Libro();
				libro.setStock(rs.getInt(1));
				libro.setIsbn(rs.getString(2));
				libro.setTitulo(rs.getString(3));
				libro.setAutor(rs.getString(4));
				libro.setCategoria(rs.getString(5));
				libro.setEditorial(rs.getString(6));
				libro.setPrecio(rs.getInt(7));
				libros.add(libro);
				hayMas = rs.next();
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Consulta de pedidos no efectuada correctamente");

			return libros;
		}

		// -----------------------------------------------------------------------------
		return libros;
	}

}
