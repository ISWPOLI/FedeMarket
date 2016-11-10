package com.qantica.fedemarket.entidad;

import com.qantica.fedemarket.entidad.Contenido;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entidad Descarga
 * @author Juan Rubiano 
 * 11/09/2016 
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
	
	@ManyToOne
	@JoinColumn(name="contenido_id")
	private Contenido contenido;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
   
}
