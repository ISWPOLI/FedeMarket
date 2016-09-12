package com.qantica.fedemarket.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Usuario;

/**
 * Bean que permite acceso al login del app
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class LoginBean implements LoginBeanLocal, LoginBeanRemote{
	
	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;	
	
	@Override
	public Usuario validarUsuario(String usuario, String contrasena) {
		Query query = manager.createQuery("SELECT ent FROM Usuario ent WHERE nombreUsuario=:x AND contrasena=:y");
		query.setParameter("x", usuario);
		query.setParameter("y", contrasena);
		
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
