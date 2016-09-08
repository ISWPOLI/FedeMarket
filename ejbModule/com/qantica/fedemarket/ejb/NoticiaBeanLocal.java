package com.qantica.fedemarket.ejb;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Noticia;

@Local
public interface NoticiaBeanLocal {
	
	public void adicionarNoticia(Noticia noticia);
	public Noticia buscarNoticia(int id);
	public void actualizarNoticia(Noticia noticia);

}
