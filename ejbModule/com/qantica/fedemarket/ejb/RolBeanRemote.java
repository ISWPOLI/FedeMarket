package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Rol;

public interface RolBeanRemote {

	public void adicionarRol(Rol rol);
	public void actualizarRol(Rol rol);
	public Rol buscarRol(int id);
	public List<Rol> listarRoles();

	
}
