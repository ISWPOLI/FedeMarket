package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Contenido;

/**
 * Bean que permite acceso al contenido
 * @author Juan Rubiano
 * 08/09/2016 
 * Modificaci�n 22/11/2016
 * Se elimina el m�todo de listarContenido por rol y se 
 * agrega el m�todo listarContenidoServlet que lista por 
 * el id de la subcategoria y el id de la categoria recibidos
 */

@Stateless
public class ContenidoBean implements ContenidoBeanLocal, ContenidoBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	@Override
	public void adicionarContenido(Contenido contenido) {
		manager.persist(contenido);
		
	}

	@Override
	public Contenido buscarContenido(int id) {
		return manager.find(Contenido.class, id);
	}

	@Override
	public void actualizarContenido(Contenido contenido) {
		Contenido miContenido = manager.find(Contenido.class, contenido.getId());
		miContenido.setVersion(contenido.getVersion());
		miContenido.setNombre(contenido.getNombre());
		miContenido.setEstado(contenido.getEstado());
		miContenido.setDescripcion(contenido.getDescripcion());
		
		if(!contenido.getIcono().equals("")){
			miContenido.setIcono(contenido.getIcono());
		}if(!contenido.getCaptura_1().equals("")){
			miContenido.setCaptura_1(contenido.getCaptura_1());
		}if(!contenido.getCaptura_2().equals("")){
			miContenido.setCaptura_2(contenido.getCaptura_2());
		}if(!contenido.getRuta().equals("")){
			miContenido.setRuta(contenido.getRuta());
		}
		
		manager.merge(contenido);
		
	}
	
	/**
	 * Lista el contenido para la aplicaci�n web sin restricci�n de resultados
	 * @return lista de contenido sin restricci�n de resultados
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contenido> listarContenido() {		
		Query query= manager.createQuery("SELECT entidad FROM Contenido entidad ORDER BY entidad.id desc");		
		return query.getResultList();
	}

	
	/**
	 * Lista el contenido destacado para la aplicaci�n web y m�vil
	 * @param true web sin restricci�n de resultados. false m�vil con un max�mo de 10 resultados
	 * @return listado de contenido destacado
	 */
	public List<Contenido> listarDestacados(boolean x) {
		Query query= manager.createQuery("SELECT entidad FROM Contenido entidad ORDER BY entidad.descargas DESC");
		if(!x)	query.setMaxResults(10);
		return query.getResultList();
	}

	
	/**
	 * Actualiza el contenido
	 * @param objeto contenido que se va a actualizar
	 */
	@Override
	public void updateContenido(Contenido contenido){		
		manager.merge(contenido);
	}

	/**
	 * Lista el contenido de acuerdo al id de la subcategoria
	 * @param subcategoria id de la subcategoria
	 * @param categoria id de la categoria
	 * @return List con el contenido
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contenido> listarContenidoServlet(int subcategoria, int categoria) {
		if(subcategoria == 0){
			Query query = manager.createQuery("SELECT entidad FROM Contenido entidad WHERE categoria_id=:x AND "
					+ "entidad.estado=:y");
			query.setParameter("x", categoria);
			query.setParameter("y", true);
			return query.getResultList();
		}else{
			Query query = manager.createQuery("SELECT entidad FROM Contenido entidad WHERE subcategoria_id=:x "
					+ "AND entidad.estado=:y");
			query.setParameter("x", subcategoria);
			query.setParameter("y", true);
			return query.getResultList();
		}

		
	}	

}
