package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Rol;

/**
 * Bean que permite acceso a los roles
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class RolBean implements RolBeanLocal, RolBeanRemote{

	@Override
	public void adicionarRol(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarRol(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rol buscarRol(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rol> listarRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
