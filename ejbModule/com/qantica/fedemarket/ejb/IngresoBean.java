package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qantica.fedemarket.entidad.Ingreso;

/**
 * @author Juan Rubiano
 * 08/09/2016 
 */

@Stateless
public class IngresoBean implements IngresoBeanRemote{

	@PersistenceContext(unitName="EjbFedeMarket")
	EntityManager manager;
	
	@Override
	public List<Ingreso> listarIngresos(String user) {
		if(user.equals("")){
			Query query = manager.createQuery("SELECT entidad FROM Descarga entidad");
			return query.getResultList();
		}else{
			Query query = manager.createQuery("SELECT entidad FROM Descarga entidad WHERE entidad.usuario=:x");
			query.setParameter("x", user);
			return query.getResultList();
		}
		
	}
	
	@Override
	public void addRegistro(Ingreso nombre) {
		/*String id = nombre.getUsuario();
		String fecha = nombre.getFecha();
		Query query = manager.createQuery("INSERT INTO Ingreso('fecha','usuario_id') VALUES x,y");
		query.setParameter("x", id);
		query.setParameter("y", fecha);*/ 
		manager.persist(nombre); 
	}
	
	@Override
	public List<Ingreso> listarIngresosSinDescarga() {
		return null;
	}

}
