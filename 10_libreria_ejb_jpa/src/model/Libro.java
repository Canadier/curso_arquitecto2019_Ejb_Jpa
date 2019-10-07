package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the libros database table.
 * 
 */
@Entity
@Table(name="libros")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int isbn;

	private String autor;

	private int paginas;

	private double precio;

	private String titulo;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	//name: nombre de la foreing key
	//referenceColumnName: nombre de la primary key
	@JoinColumn(name="idTema",referencedColumnName = "idTema")
	private Tema tema;

	public Libro() {
	}

	public Libro(int isbn, String autor, int paginas, double precio, String titulo, Tema tema) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.paginas = paginas;
		this.precio = precio;
		this.titulo = titulo;
		this.tema = tema;
	}

	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return this.paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}