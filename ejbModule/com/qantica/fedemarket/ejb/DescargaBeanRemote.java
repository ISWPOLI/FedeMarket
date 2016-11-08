package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Descarga;

@Remote
public interface DescargaBeanRemote {
	
	public void adicionarDescarga(Descarga categoria);
	public Descarga buscarDescarga(int id);
	public void actualizarDescarga(Descarga categoria);
	public List<Descarga> historialDescarga();
	public List<Descarga> listDescargaUsuario(String user);
}
