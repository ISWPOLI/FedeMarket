package com.qantica.fedemarket.ejb;

import java.util.List;
import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Categoria;
import com.qantica.fedemarket.entidad.Subcategoria;

@Local
public interface CategoriaBeanLocal {
	
	public void adicionarCategoria(Categoria categoria);
	public Categoria buscarCategoria(int id);
	public void actualizarCategoria(Categoria categoria);
	public List<String> listarCategorias();
	public List<Categoria> listarCategoriasServlet();
	
	/*	MÉTODOS PARA EL MÓVIL */
	public List<Categoria> listarCategoriaMovil(int rol);
	public List<Subcategoria> listarSubcategoriasMovil();
	public List<Categoria> listarInterCategoriaMovil(int categoria);
	public List<Categoria> listarSubcategoriaMovil(int intercategoria);
}
