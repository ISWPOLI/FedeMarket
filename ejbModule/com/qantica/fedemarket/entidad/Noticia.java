package com.qantica.fedemarket.entidad;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * @author Juan Rubiano 
 * 08/09/2016
 * Q-antica Ltda.   
 */

@Entity
@Table(name="noticia")
public class Noticia implements Serializable {
  
	@Id 
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="fuente")
	private String fuente;
	
	@Column(name="imagen")
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;
	
	private static final long serialVersionUID = 1L;

	public Noticia() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}   
	public String getFuente() {
		return this.fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
   
	
}
