package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Comentario;
import com.qantica.fedemarket.entidad.Usuario;

@Remote
public interface ComentarioBeanRemote {

	public void adicionarComentario(int aid, Usuario uid, int rating, String descripcion, String uname);
	public List<Comentario> listarComentarios(int id);
	public void actualizarRating(int id);
	public List<Comentario> listarComentariosUsuario(String user);
}
