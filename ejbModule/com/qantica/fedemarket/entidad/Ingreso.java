package com.qantica.fedemarket.entidad;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * @author Juan Rubiano 
 * 08/09/2016
 * Modificación 24/11/2016
 * Se elimina el campo nombre de la DB y de la entidad
 */

@Entity
@Table(name="ingreso")
public class Ingreso implements Serializable {

	   
	@Id 
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha")
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name="usuario_id") 
	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;

	public Ingreso() {
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
   
}
