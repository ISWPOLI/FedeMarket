package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Categoria;
import com.qantica.fedemarket.entidad.Subcategoria;

@Remote
public interface CategoriaBeanRemote {
	
	public void adicionarCategoria(Categoria categoria);
	public Categoria buscarCategoria(int id);
	public void actualizarCategoria(Categoria categoria);
	public List<String> listarCategorias();
	public List<Categoria> listarCategoriasServlet();
	public List<Subcategoria> listarSubcategorias(int idCategoria);
	
	/*	MÉTODOS PARA EL MÓVIL */
	public List<Categoria> listarCategoriaMovil(int rol);
	public List<Subcategoria> listarSubcategoriasMovil(int categoria);
	public List<Categoria> listarInterCategoriaMovil(int categoria);
	public List<Categoria> listarSubcategoriaMovil(int intercategoria);
	
}
