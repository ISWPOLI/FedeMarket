package com.qantica.fedemarket.ejb;

import java.util.List;

import com.qantica.fedemarket.entidad.Categoria;
import com.qantica.fedemarket.entidad.Subcategoria;

/**
 * Bean que permite acceso a las categorias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

public class CategoriaBean implements CategoriaBeanLocal, CategoriaBeanRemote{

	@Override
	public void adicionarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria buscarCategoria(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> listarCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarCategoriasServlet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarCategoriaMovil(int rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subcategoria> listarSubcategoriasMovil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarInterCategoriaMovil(int categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarSubcategoriaMovil(int intercategoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
