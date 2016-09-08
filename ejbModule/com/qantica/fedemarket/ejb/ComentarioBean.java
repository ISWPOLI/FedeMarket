package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Comentario;

/**
 * Bean que permite acceso a los comentarios
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class ComentarioBean implements ComentarioBeanLocal, ComentariosBeanRemote{

	@Override
	public void adicionarComentario(int aid, String uid, int rating, String descripcion, String uname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comentario> listarComentarios(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
