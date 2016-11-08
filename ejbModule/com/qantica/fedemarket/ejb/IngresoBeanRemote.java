package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Ingreso;

@Remote
public interface IngresoBeanRemote {

	public List<Ingreso> listarIngresos(String user);
	public List<Ingreso> listarIngresosSinDescarga();
	
}
