package com.qantica.fedemarket.ejb;

import com.qantica.fedemarket.entidad.Usuario;

/**
 * Bean que permite acceso al login del app
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class LoginBean implements LoginBeanLocal, LoginBeanRemote{

	@Override
	public Usuario validarUsuario(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		return null;
	}

}
