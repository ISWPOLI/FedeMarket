package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Rol;

@Local
public interface RolBeanLocal {
	
	public void adicionarRol(Rol rol);
	public void actualizarRol(Rol rol);
	public Rol buscarRol(int id);
	public List<Rol> listarRoles();
}
