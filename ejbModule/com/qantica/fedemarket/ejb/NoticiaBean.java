package com.qantica.fedemarket.ejb;

import com.qantica.fedemarket.entidad.Noticia;

/**
 * Bean que permite acceso a las noticias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class NoticiaBean implements NoticiaBeanLocal, NoticiaBeanRemote{

	@Override
	public void adicionarNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Noticia buscarNoticia(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

}
