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
	
	//Lista los roles que se encuentran activos
	public List<Rol> listarRoles();
	
	//Lista todos los roles sin importar si está activo o no
	public List<Rol> listarTodosRoles();
	
}
