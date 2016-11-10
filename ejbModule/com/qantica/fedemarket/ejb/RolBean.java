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
 * 10/11/2016 
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

	@Override
	public List<Rol> listarRoles() {
		Query query = manager.createQuery("SELECT entidad FROM Rol entidad ORDER BY entidad.id DESC");		
		return query.getResultList();
	}

}
