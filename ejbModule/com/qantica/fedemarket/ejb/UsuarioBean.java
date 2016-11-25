package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Ingreso;
import com.qantica.fedemarket.entidad.Usuario;

/**
 * Bean para la entidad Usuario
 * @author Juan Rubiano
 * 13/11/16
 * Modificación 24/11/2016:
 * Se agrega método para buscar usuario por identificación.
 */
 @Stateless
public class UsuarioBean implements UsuarioBeanLocal, UsuarioBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	@Override
	public void adicionarUsuario(Usuario usuario) {
		manager.persist(usuario);		
	}

	@Override
	public Usuario buscarUsuario(int id) {
		return manager.find(Usuario.class, id);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		manager.merge(usuario);		
	}

	@Override
	public List<Usuario> listarUsuarios() {
		Query query = manager.createQuery("SELECT entidad FROM Usuario entidad");
		return query.getResultList();
	}

	/**
	 * Login 
	 * @param nombreUsuario user
	 * @param contrasena pass
	 * @return Retorna un String con la info del usuario o null
	 */
	@Override
	public Usuario login(String nombreUsuario, String contrasena) {
		Usuario user = null;
		int id;
		try{			
			Query query = manager.createQuery("SELECT entidad FROM Usuario entidad WHERE nombreUsuario=:x AND contrasena=:y");
			query.setParameter("x", nombreUsuario);
			query.setParameter("y", contrasena);
			user = (Usuario) query.getSingleResult();
			if(!user.equals(null)){
				id = user.getId();
				user = buscarUsuario(id);
				return user;
			}
		}catch(NoResultException e){

		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}	

	@Override
	public List<Usuario> buscarUsuarioIdent(String identificacion) {
		Query query = manager.createQuery("SELECT entidad FROM Usuario entidad WHERE entidad.identificacion=:x");
		query.setParameter("x", identificacion);
		return query.getResultList();
	}

}
