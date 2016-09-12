package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Usuario;

@Local
public interface UsuarioBeanLocal {
	
	public void adicionarUsuario(Usuario usuario);
	public Usuario buscarUsuario(int id);
	public void actualizarUsuario(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public Usuario login(String usuario, String contrasena);
	
}
