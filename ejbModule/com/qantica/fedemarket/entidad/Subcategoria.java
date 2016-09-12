package com.qantica.fedemarket.entidad;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;

/**
 * @author Juan Rubiano 
 * 08/09/2016
 * Q-antica Ltda.   
 */

/*
 * Se cambio el campo "miSubCategoria_id INT" a "subcategoria_id INT"
 * Se cambio el campo "estado BIT" a "estado TINYINT"
 */

@Entity
@Table(name="subcategoria")
public class Subcategoria implements Serializable {
      
	@Id
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="subcategoria_id")
	Subcategoria miSubCategoria;
	
	@OneToMany(mappedBy = "subCategoria")
	List<Contenido> listaContenido;	
	
	@OneToMany(mappedBy = "miSubCategoria")
	List<Subcategoria> listaSubCategorias;
	
	private static final long serialVersionUID = 1L;

	public Subcategoria() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Contenido> getListaContenido() {
		return listaContenido;
	}
	public void setListaContenido(List<Contenido> listaContenido) {
		this.listaContenido = listaContenido;
	}
	public Subcategoria getMiSubCategoria() {
		return miSubCategoria;
	}
	public void setMiSubCategoria(Subcategoria miSubCategoria) {
		this.miSubCategoria = miSubCategoria;
	}
	public List<Subcategoria> getListaSubCategorias() {
		return listaSubCategorias;
	}
	public void setListaSubCategorias(List<Subcategoria> listaSubCategorias) {
		this.listaSubCategorias = listaSubCategorias;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
