package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Categoria;
import com.qantica.fedemarket.entidad.Subcategoria;

/**
 * Bean que permite acceso a las categorias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 09/09/2016 
 */

@Stateless
public class CategoriaBean implements CategoriaBeanLocal, CategoriaBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	/**
	 * Agrega la categoria a la base de datos
	 */
	@Override
	public void adicionarCategoria(Categoria categoria) {
		manager.persist(categoria);		
	}
	
	/**
	 * Busca la categoria de acuerdo al id
	 */
	@Override
	public Categoria buscarCategoria(int id) {		
		return manager.find(Categoria.class, id);
	}
	
	/**
	 * Actualiza la categoria 
	 */
	@Override
	public void actualizarCategoria(Categoria categoria) {
		Categoria miCategoria = buscarCategoria(categoria.getId());
		miCategoria.setNombre(categoria.getNombre());
		miCategoria.setDescripcion(categoria.getDescripcion());
		miCategoria.setEstado(categoria.getEstado());
		miCategoria.setRol(categoria.getRol());
		if(!categoria.getIcono().equals("")){
			miCategoria.setIcono(categoria.getIcono());
		}
		
		manager.merge(categoria);
	}
	
	/**
	 * Retorna el nombre de las categorias ordenadas por el mismo
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> listarCategorias() {
		Query query = manager.createQuery("SELECT entidad.nombre FROM categoria entidad ORDER BY entidad.nombre");
		return query.getResultList();
	}

	/**
	 * Retorna toda la entidad ordenado por el nombre
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listarCategoriasServlet() {
		Query query = manager.createQuery("SELECT entidad FROM categoria entidad ORDER BY entidad.nombre");		
		return query.getResultList();
	}
	
	/**
	 * Lista las categorias para el móvil
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listarCategoriaMovil(int rol) {
		Query query = manager.createQuery("SELECT entidad FROM categoria entidad WHERE entidad.estado=:x AND entidad.rol");
		query.setParameter("x", true);
		query.setParameter("y", rol);
		return query.getResultList();
	}
	
	
	/**
	 * Devuelve las subcategorias del movil de acuerdo a la categoria seleccionada
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subcategoria> listarSubcategoriasMovil(int categoria) {
		Query query = manager.createQuery("SELECT entidad FROM subcategoria entidad WHERE entidad.estado=:x AND entidad.categoria=:y");
		query.setParameter("x", true);
		query.setParameter("y", categoria);
		return query.getResultList();
	}

	
	@Override
	public List<Categoria> listarInterCategoriaMovil(int categoria) {
		return null;
	}

	@Override
	public List<Categoria> listarSubcategoriaMovil(int intercategoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
