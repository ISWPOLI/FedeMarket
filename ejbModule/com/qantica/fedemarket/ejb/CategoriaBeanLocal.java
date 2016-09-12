package com.qantica.fedemarket.ejb;

import java.util.List;
import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Categoria;
import com.qantica.fedemarket.entidad.Subcategoria;

/**
 * Bean que permite acceso a las categorias
 * @author Juan Rubiano
 * Q-antica Ltda
 * Colombia
 * 08/09/2016 
 */

@Local
public interface CategoriaBeanLocal {
	
	public void adicionarCategoria(Categoria categoria);
	public Categoria buscarCategoria(int id);
	public void actualizarCategoria(Categoria categoria);
	public List<String> listarCategorias();
	public List<Categoria> listarCategoriasServlet();
	
	/*	MÉTODOS PARA EL MÓVIL */
	public List<Categoria> listarCategoriaMovil(int rol);
	public List<Subcategoria> listarSubcategoriasMovil(int categoria);
	public List<Categoria> listarInterCategoriaMovil(int categoria);
	public List<Categoria> listarSubcategoriaMovil(int intercategoria);
}
