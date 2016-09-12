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
  * Se eliminaron los campos "caficultor", "empleado", "investigador", "otros"
  * Se cambio el campo "estado" de BIT a TINYINT
  * Se agregó el campo "fecha (DATETIME)"
  * 
  */
@Entity
@Table(name="contenido")
public class Contenido implements Serializable {

	@Id 
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@Column(name="version")
	private String version;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="icono")
	private String icono;
	
	@Column(name="estado")
	private boolean estado;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="publicacion")
	private String publicacion;	
	
	@Column(name="descargas")	
	private int descargas;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="ruta")
	private String ruta;
	
	@Column(name="captura1")
	private String captura_1;
	
	@Column(name="captura2")
	private String captura_2;

	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="subcategoria_id")
	private Subcategoria subCategoria;
		
	@OneToMany(mappedBy="contenido")
	private List<Descarga> listaDescarga;	
	
	@OneToMany(mappedBy="contenido")
	private List<Comentario> listaComentario;
	
	private static final long serialVersionUID = 1L;

	public Contenido() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}   
	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}   
	public String getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}   
	public int getDescargas() {
		return this.descargas;
	}

	public void setDescargas(int descargas) {
		this.descargas = descargas;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Subcategoria getSubCategoria() {
		return subCategoria;
	}
	public void setSubCategoria(Subcategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	public List<Descarga> getListaDescarga() {
		return listaDescarga;
	}
	public void setListaDescarga(List<Descarga> listaDescarga) {
		this.listaDescarga = listaDescarga;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCaptura_1() {
		return captura_1;
	}
	public void setCaptura_1(String captura_1) {
		this.captura_1 = captura_1;
	}
	public String getCaptura_2() {
		return captura_2;
	}
	public void setCaptura_2(String captura_2) {
		this.captura_2 = captura_2;
	}
	public List<Comentario> getListaComentario() {
		return listaComentario;
	}
	public void setListaComentario(List<Comentario> listaComentario) {
		this.listaComentario = listaComentario;
	}	
	
}
