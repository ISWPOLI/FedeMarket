package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Noticia;

/**
 * Bean Remote para la entidad Noticia
 * @author Juan Rubiano
 * 13/11/16
 */
@Remote
public interface NoticiaBeanRemote {

	public void adicionarNoticia(Noticia noticia);
	public Noticia buscarNoticia(int id);
	public void actualizarNoticia(Noticia noticia);
	public List<Noticia> listarNoticias(int rol);
	public List<Noticia> listarNoticias();
}
