package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Contenido;

@Remote
public interface ContenidoBeanRemote {

	public void adicionarContenido(Contenido contenido);
	public Contenido buscarContenido(int id);
	public void actualizarContenido(Contenido contenido);
	public List<Contenido> listarContenido(int rol);
	public List<Contenido> listarDestacados(boolean x);
	public List<Contenido> listarContenido();
	
	public void updateContenido(Contenido contenido);
	
}
