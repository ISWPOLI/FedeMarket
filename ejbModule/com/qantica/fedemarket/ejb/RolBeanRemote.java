package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Rol;

/**
 * Bean Remote para la entidad Rol
 * @author Juan Rubiano
 * 13/11/16 *
 */
@Remote
public interface RolBeanRemote {

	public void adicionarRol(Rol rol);
	public void actualizarRol(Rol rol);
	public Rol buscarRol(int id);
	public List<Rol> listarRoles();
	public List<Rol> listarTodosRoles();
	
}
