package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Noticia;

@Remote
public interface NoticiaBeanRemote {

	public void adicionarNoticia(Noticia noticia);
	public Noticia buscarNoticia(int id);
	public void actualizarNoticia(Noticia noticia);
	public List<Noticia> listarNoticias(int rol);
}
