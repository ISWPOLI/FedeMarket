package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Rol;

/**
 * Bean que permite acceso a los roles
 * @author Juan Rubiano
 * 13/11/2016 * 
 */

@Stateless
public class RolBean implements RolBeanLocal, RolBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	@Override
	public void adicionarRol(Rol rol) {
		manager.persist(rol);		
	}

	@Override
	public void actualizarRol(Rol rol) {
		manager.merge(rol);		
	}

	@Override
	public Rol buscarRol(int id) {
		return manager.find(Rol.class, id);
	}

	/**
	 * Lista los roles que se encuentran en estado activo
	 * @return List con los roles
	 */
	@Override
	public List<Rol> listarRoles() {
<<<<<<< HEAD
		Query query = manager.createQuery("SELECT entidad FROM Rol entidad WHERE  entidad.estado=:x ORDER BY entidad.id DESC");
		query.setParameter("x", true);
=======
		Query query = manager.createQuery("SELECT entidad FROM Rol entidad WHERE entidad.estado=:x ORDER BY entidad.id DESC");
		query.setParameter("x", true);
		return query.getResultList();
	}

	@Override
	public List<Rol> listarTodosRoles() {
		Query query = manager.createQuery("SELECT entidad FROM Rol entidad ORDER BY entidad.id DESC");
>>>>>>> origin/master
		return query.getResultList();
	}

	/**
	 * Lista todos los roles que se encuentren en el sistema
	 * @return List con los roles
	 */
	@Override
	public List<Rol> listarTodosRoles() {
		Query query = manager.createQuery("SELECT entidad FROM Rol entidad");
		return query.getResultList();
	}
	
	

}
