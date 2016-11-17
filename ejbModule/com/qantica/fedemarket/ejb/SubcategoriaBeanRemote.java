package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Subcategoria;
 
/**
  * Bean remoto de la entidad Subcategoria 
  * @author Juan Rubiano
  * 16/11/2016
  */
@Remote
public interface SubcategoriaBeanRemote {

	public void adicionarSubcategoria(Subcategoria subcategoria);
	public Subcategoria buscarSubcategoria(int id);
	public void actualizarSubcategoria(Subcategoria subcategoria);
	public List<Subcategoria> listarSubcategorias(int idCategoria);
	public List<Subcategoria> listarSubcategoriasServlet();	
}
