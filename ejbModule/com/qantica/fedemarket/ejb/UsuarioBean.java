package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Usuario;

public class UsuarioBean implements UsuarioBeanLocal{

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
		Query query = manager.createQuery("SELECT entidad FROM usuario entidad WHERE entidad.id=:x");
		query.setParameter("x", true);
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
			Query query = manager.createQuery("select ent from Usuario ent where nombreUsuario=:x and contrasena=:y");
			query.setParameter("x", nombreUsuario);
			query.setParameter("y", contrasena);
			user = (Usuario) query.getSingleResult();
			System.out.println("USUARIO -----> "+user);
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

}
