package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import com.qantica.fedemarket.entidad.Descarga;

/**
 * Bean que permite acceso a las descargas
 * @author Juan Rubiano
 * 09/11/2016 
 */

@Stateless
@Table(name="descarga")
public class DescargaBean implements DescargaBeanLocal, DescargaBeanRemote {

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	
	@Override
	public void adicionarDescarga(Descarga descarga) {
		manager.persist(descarga);		
	}

	@Override
	public Descarga buscarDescarga(int id) {
		return manager.find(Descarga.class, id);
	}

	@Override
	public void actualizarDescarga(Descarga descarga) {
		manager.merge(descarga);		
	}

	@Override
	public List<Descarga> historialDescarga() {
		Query query=manager.createQuery("SELECT entidad FROM Descarga entidad");
		return query.getResultList();
	}

	@Override
	public List<Descarga> listDescagaUsuario(String user) {
		Query query=manager.createQuery("SELECT entidad FROM Descarga entidad WHERE entidad.usuario =:x");
		query.setParameter("x", user);
		return query.getResultList();
	}

	@Override
	public List<Descarga> listDescargaUsuario(String user) {
		Query query=manager.createQuery("select entidad from Descarga entidad where entidad.usuario =:x");
		query.setParameter("x", user);
		return query.getResultList();	
	}
}
