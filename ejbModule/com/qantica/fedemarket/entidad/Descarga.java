package com.qantica.fedemarket.entidad;

import com.qantica.fedemarket.entidad.Contenido;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * @author Juan Rubiano 
 * 08/09/2016
 * Q-antica Ltda.   
 */

/*
 * Se cambio el campo "fecha" de VARCHAR(355) a DATETIME
 * Se cambio el campo "usuario VARCHAR(255)" a "usuario_id INT"
 */
@Entity
@Table(name="descarga")
public class Descarga implements Serializable {

	@Id 
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha")
	private String fecha;	
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="contenido_id")
	private Contenido contenido;
	
	//@ManyToOne
	@JoinColumn(name="usuario_id")
	private String usuario;
	
	private static final long serialVersionUID = 1L;

	public Descarga() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}   
	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
   
}
