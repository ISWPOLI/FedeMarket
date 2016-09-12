package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Noticia;

/**
 * Bean que permite acceso a las noticias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

@Stateless
public class NoticiaBean implements NoticiaBeanLocal, NoticiaBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	@Override
	public void adicionarNoticia(Noticia noticia) {
		manager.persist(noticia);		
	}

	@Override
	public Noticia buscarNoticia(int id) {
		return manager.find(Noticia.class, id);
	}

	@Override
	public void actualizarNoticia(Noticia noticia) {
		manager.merge(noticia);		
	}

	/**
	 * Lista todas las noticias para la web
	 * @return lista con todas las noticias
	 */
	@Override
	public List<Noticia> listarNoticias() {
		Query query = manager.createQuery("SELECT entidad FROM noticia ORDER BY noticia.id DESC");		
		return query.getResultList();
	}
	
	/**
	 * Lista las noticias de acuerdo al rol móvil
	 * @param rol id del rol
	 * @return lista con las noticias de acuerdo al rol 
	 */
	@Override
	public List<Noticia> listarNoticias(int rol) {
		Query query = manager.createQuery("SELECT entidad FROM noticia entidad WHERE rol_id=:x ORDER BY entidad.id DESC");
		query.setParameter("x", rol);
		query.setMaxResults(5);
		return query.getResultList();
	}

}
