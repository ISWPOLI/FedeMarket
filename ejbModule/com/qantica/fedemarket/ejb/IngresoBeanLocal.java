package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Ingreso;

@Local
public interface IngresoBeanLocal {

	public List<Ingreso> listarIngresos(String user);
	public List<Ingreso> listarIngresosSinDescarga();
	
}
