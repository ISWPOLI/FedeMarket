package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Subcategoria;

/**
 * Bean que permite acceso a las sucategorias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

@Stateless
public class SubcategoriaBean implements SubcategoriaBeanLocal , SubcategoriaBeanRemote{
	
	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	@Override
	public void adicionarSubcategoria(Subcategoria subcategoria) {
		manager.persist(subcategoria);
	}
	
	@Override
	public void actualizarSubcategoria(Subcategoria subcategoria) {
		manager.merge(subcategoria);		
	}
	
	@Override
	public Subcategoria buscarSubcategoria(int id) {
		return manager.find(Subcategoria.class, id);
	}
	
	/**
	 * Lista las subcategorias de acuerdo a la categoria
	 * @param id de la categoria
	 * @return lista con las subcategorias
	 */
	@Override
	public List<Subcategoria> listarSubcategorias(int categoria) {
		Query query = manager.createQuery("SELECT entidad FROM subcategoria entidad WHERE categoria_id=:x AND estado=:y");
		query.setParameter("x", categoria);
		query.setParameter("y", true);
		return query.getResultList();
	}

	/**
	 * Lista las subcategoria de acuerdo al subnivel
	 * @param id de la subcategoria
	 * @return lista de las subcategorias
	 */
	@Override
	public List<Subcategoria> listarSubcategoriasNivel(int subcategoria) {
		Query query = manager.createQuery("SELECT entidad FROM subcategoria entidad WHERE subcategoria_id=:x AND estado=:y");
		query.setParameter("x", subcategoria);
		query.setParameter("y", true);
		return query.getResultList();
	}

	/**
	 * Lista todas las subcategorias
	 * @return lista con las subcategorias
	 */
	@Override
	public List<Subcategoria> listarSubcategorias() {
		Query query = manager.createQuery("SELECT entidad FROM Subcategoria entidad WHERE entidad.estado=:x");
		query.setParameter("x", true);
		return query.getResultList();
	}

	

}
