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
 * 09/11/2016 
 */

@Stateless
public class CategoriaBean implements CategoriaBeanLocal, CategoriaBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	/**
	 * Agrega la categoria a la base de datos
	 * @param categoria
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
	 * @param categoria objeto
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
		Query query = manager.createQuery("SELECT entidad.nombre FROM Categoria entidad ORDER BY entidad.nombre");
		return query.getResultList();
	}

	/**
	 * Retorna toda la entidad ordenado por el nombre
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listarCategoriasServlet() {
		Query query = manager.createQuery("SELECT entidad FROM Categoria entidad ORDER BY entidad.nombre");		
		return query.getResultList();
	}
	
	/**
	 * Lista las categorias para el m�vil
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listarCategoriaMovil(int rol) {
		Query query = manager.createQuery("SELECT entidad FROM Categoria entidad WHERE entidad.estado=:x AND entidad.rol.id=:y");
		query.setParameter("x", true);
		query.setParameter("y", rol);
		return query.getResultList();
	}
	
	
	/**
	 * Devuelve las subcategorias del movil de acuerdo a la categoria seleccionada
	 * @param categoria id de la categoria 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Subcategoria> listarSubcategoriasMovil(int categoria) {
		Query query = manager.createQuery("SELECT entidad FROM Subcategoria entidad WHERE entidad.estado=:x AND entidad.categoria=:y");
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
	
	/**
	 * Lista las subcategorias
	 * @param idCategoria 0 si se desean todas
	 * @return Lis<Subcategoria>
	 */
	@Override
	public List<Subcategoria> listarSubcategorias(int idCategoria) {
		if(idCategoria == 0){
			Query query = manager.createQuery("SELECT entidad FROM Subcategoria entidad WHERE entidad.estado=:x");
			query.setParameter("x", true);
			return query.getResultList();
		}else{
			Query query = manager.createQuery("SELECT entidad FROM Subcategoria entidad WHERE entidad.estado=:x AND entidad.categoria.id=:y");
			query.setParameter("x", true);
			query.setParameter("y", Integer.valueOf(idCategoria));
			return query.getResultList();
		}	
		
	}

}
