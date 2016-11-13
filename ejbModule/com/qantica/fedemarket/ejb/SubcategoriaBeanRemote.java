package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.qantica.fedemarket.entidad.Subcategoria;

@Remote
public interface SubcategoriaBeanRemote {

	public void adicionarSubcategoria(Subcategoria subcategoria);
	public Subcategoria buscarSubcategoria(int id);
	public void actualizarSubcategoria(Subcategoria subcategoria);
	public List<Subcategoria> listarSubcategorias(int idRol);
	public List<Subcategoria> listarSubcategoriasServlet();	
}
