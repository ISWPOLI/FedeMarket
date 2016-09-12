package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Contenido;

/**
 * Bean que permite acceso al contenido
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

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
	 * Lista el contenido para la aplicación web sin restricción de resultados
	 * @return lista de contenido sin restricción de resultados
	 */
	@Override
	public List<Contenido> listarContenido() {		
		Query query= manager.createQuery("SELECT entidad FROM Contenido entidad ORDER BY entidad.id desc");		
		return query.getResultList();
	}

	/**
	 * Lista el contenido de acuerdo al rol 
	 * @param rol id del Rol 
	 */
	@Override
	public List<Contenido> listarContenido(int rol) {
		Query query= manager.createQuery("SELECT entidad FROM Contenido entidad WHERE entidad.contenido.rol.id =:x ");
		query.setParameter("x", Integer.valueOf(rol));
		return query.getResultList();
	}

	/**
	 * Lista el contenido destacado para la aplicación web y móvil
	 * @param true web sin restricción de resultados. false móvil con un maxímo de 10 resultados
	 * @return listado de contenido destacado
	 */
	public List<Contenido> listarDestacados(boolean x) {
		Query query= manager.createQuery("SELECT entidad FROM Contenido entidad ORDER BY entidad.descargas DESC");
		if(!x)	query.setMaxResults(10);
		return query.getResultList();
	}

}
