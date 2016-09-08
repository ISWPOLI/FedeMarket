package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Comentario;

@Local
public interface ComentarioBeanLocal {
	
	public void adicionarComentario(int aid, String uid, int rating, String descripcion, String uname);
	public List<Comentario> listarComentarios(int id);
	
}
