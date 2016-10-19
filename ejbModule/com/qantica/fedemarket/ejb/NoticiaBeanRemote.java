package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Noticia;

public interface NoticiaBeanRemote {

	public void adicionarNoticia(Noticia noticia);
	public Noticia buscarNoticia(int id);
	public void actualizarNoticia(Noticia noticia);
	public List<Noticia> listarNoticias(int rol);
}
