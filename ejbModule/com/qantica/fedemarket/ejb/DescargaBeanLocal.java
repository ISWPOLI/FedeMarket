package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Descarga;

@Local
public interface DescargaBeanLocal {
	
	public void adicionarDescarga(Descarga descarga);
	public Descarga buscarDescarga(int id);
	public void actualizarDescarga(Descarga categoria);
	public List<Descarga> historialDescarga();
	public List<Descarga> listDescagaUsuario(String user);
	
}
