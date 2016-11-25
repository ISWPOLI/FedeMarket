package com.qantica.fedemarket.ejb;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Comentario;
import com.qantica.fedemarket.entidad.Contenido;
import com.qantica.fedemarket.entidad.Usuario;

/**
 * Bean que permite acceso a los comentarios
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 09/11/2016 
 */

@Stateless
public class ComentarioBean implements ComentarioBeanLocal, ComentarioBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	public Contenido buscarContenido(int aid) {
		return manager.find(Contenido.class, aid);
	}
	
	@Override 
	public void adicionarComentario(int aid, Usuario uid, int rating, String descripcion, String uname, String fecha) {
		Comentario comentario = new Comentario();
		comentario.setUsuario(uid);
		comentario.setRating(rating);
		comentario.setDescripcion(descripcion);
		comentario.setContenido(buscarContenido(aid));
		comentario.setNombre(uname);
		comentario.setFecha(fecha);
		
		manager.persist(comentario);
		
		actualizarRating(aid);
	}

	@Override
	public List<Comentario> listarComentarios(int id) {
		Query query = manager.createQuery("SELECT entidad FROM Comentario entidad WHERE entidad.contenido.id=:x ORDER BY entidad.id DESC");
		query.setParameter("x", id);
		return query.getResultList();
	}
	
	public void actualizarRating(int id){
		Contenido contenido = manager.find(Contenido.class, id);
		Query query = manager.createQuery("SELECT AVG(entidad.rating) FROM comentario entidad WHERE entidad.contenido.id=:x GROUP BY (entidad.contenido.id)");
		query.setParameter("x", id);
		
		double aux = (Double) query.getSingleResult();
		contenido.setRating((int) aux);
		
		manager.merge(contenido);
	}

	@Override
	public List<Comentario> listarComentariosUsuario(String user) {
		if(user.equals("")){
			Query query = manager.createQuery("SELECT entidad FROM Comentario entidad");
			return query.getResultList();
		}else{
			Query query = manager.createQuery("SELECT entidad FROM Comentario entidad WHERE entidad.id=:x");
			query.setParameter("x",user);			
			return query.getResultList();
		}		
	}

}
