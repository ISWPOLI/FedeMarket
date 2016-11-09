package com.qantica.fedemarket.entidad;

import com.qantica.fedemarket.entidad.Contenido;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * @author Juan Rubiano 
 * 09/11/2016
 * Q-antica Ltda.   
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
	private int contenido;
	
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
	public int getContenido() {
		return this.contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
   
}
