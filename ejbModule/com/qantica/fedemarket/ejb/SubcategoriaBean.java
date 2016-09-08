package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Subcategoria;

/**
 * Bean que permite acceso a las sucategorias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class SubcategoriaBean implements SubcategoriaBeanLocal , SubcategoriaBeanRemote{

	@Override
	public List<Subcategoria> listarSubcategorias(int categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subcategoria> listarSubcategoriasNivel(int subcategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarSubcategoria(Subcategoria subcategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarSubcategoria(Subcategoria subcategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Subcategoria buscarSubcategoria(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
