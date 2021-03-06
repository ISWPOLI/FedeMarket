package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Comentario;
import com.qantica.fedemarket.entidad.Usuario;

/**
 * Bean que permite acceso a las categorias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */
@Local
public interface ComentarioBeanLocal {
	
	public void adicionarComentario(int aid, Usuario uid, int rating, String descripcion, String uname, String fecha);
	public List<Comentario> listarComentarios(int id);
	
}
