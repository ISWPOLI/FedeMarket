package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Contenido;

/**
 * Bean que permite acceso al contenido
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class ContenidoBean implements ContenidoBeanLocal, ContenidoBeanRemote{

	@Override
	public void adicionarContenido(Contenido contenido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contenido buscarContenido(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarContenido(Contenido contenido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contenido> listarContenido(int rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contenido> listarDestacados(boolean x) {
		// TODO Auto-generated method stub
		return null;
	}

}
