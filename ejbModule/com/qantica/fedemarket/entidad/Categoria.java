package com.qantica.fedemarket.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Juan Rubiano 
 * 08/09/2016
 * Q-antica Ltda.
 *   
 */

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
   
	@Id 
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="icono")
	private String icono;
	
	@Column(name="estado")
	private boolean estado;
	
	@Column(name="rol_id")
	private int rol;
	
	@OneToMany(mappedBy = "categoria")
	List<Subcategoria> listaSubCategoria;
	
	@OneToMany(mappedBy = "categoria")
	List<Contenido> listaContenido;
	
	private static final long serialVersionUID = 1L;

	public Categoria() {
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
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Contenido> getListaContenido() {
		return listaContenido;
	}
	
	public void setListaContenido(List<Contenido> listaContenido) {
		this.listaContenido = listaContenido;
	}
	
	public List<Subcategoria> getListaSubCaregoria() {
		return listaSubCategoria;
	}
	
	public void setListaSubCaregoria(List<Subcategoria> listaSubCategoria) {
		this.listaSubCategoria = listaSubCategoria;
	}
	
	public String getIcono() {
		return icono;
	}
	
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
}
