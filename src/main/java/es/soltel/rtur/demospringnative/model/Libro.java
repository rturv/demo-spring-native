package es.soltel.rtur.demospringnative.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table("libros")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column("id_libro")
	@JsonIgnore
	private Long id;

	@Column("cd_codigo")
	private String codigo;

	@Column("ds_titulo")
	private String titulo;

	@Column("ds_autor")
	private String autor;

	@Column("txt_sinopsis")
	private String sinopsis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + 
				", autor=" + autor + ", sinopsis="
				+ sinopsis + "]";
	}

}
