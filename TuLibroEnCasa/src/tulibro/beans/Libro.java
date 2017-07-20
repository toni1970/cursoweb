/*
 * Created on 25-abr-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tulibro.beans;

import java.io.Serializable;

/**
 * @author Administrador
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class Libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stock;
	private String isbn;
	private String titulo;
	private String autor;
	private String categoria;
	private String editorial;
	private int precio;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(int stock, String isbn, String titulo, String autor, String categoria, String editorial, int precio) {
		super();
		this.stock = stock;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.editorial = editorial;
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
