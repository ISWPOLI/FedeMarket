package com.qantica.fedemarket.ejb;

import java.util.List;
import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Usuario;

@Remote
public interface UsuarioBeanRemote {
	
	public void adicionarUsuario(Usuario usuario);
	public Usuario buscarUsuario(int id);
	public void actualizarUsuario(Usuario usuario);	
	public Usuario login(String usuario, String contrasena);
	public List<Usuario> listarUsuarios();
	public void addRegistro(String nombre, String string);
	
}