package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Contenido;

@Local
public interface ContenidoBeanLocal {
	
	public void adicionarContenido(Contenido contenido);
	public Contenido buscarContenido(int id);
	public void actualizarContenido(Contenido contenido);
	public List<Contenido> listarContenido();
	public List<Contenido> listarDestacados(boolean x);	
	
	public List<Contenido> listarContenidoServlet(int subcategoria, int categoria);
	
}
