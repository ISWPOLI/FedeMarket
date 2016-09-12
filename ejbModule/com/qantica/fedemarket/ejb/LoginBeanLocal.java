package com.qantica.fedemarket.ejb;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Usuario;

@Local
public interface LoginBeanLocal {
	
	public Usuario validarUsuario(String usuario, String contrasena);
}
