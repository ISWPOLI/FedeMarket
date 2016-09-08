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


@Entity
@Table(name="comentario")
public class Comentario implements Serializable {
	   
	@Id 
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="fecha")
	private String fecha;
	
	//@ManyToOne
	@JoinColumn(name="usuario_id")	
	private String usuario;
	
	@ManyToOne
	@JoinColumn(name="contenido_id")	
	private Contenido contenido;	
	
	private static final long serialVersionUID = 1L;

	public Comentario() {
		super();
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}
	
	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String uid) {
		this.usuario = uid;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
}
