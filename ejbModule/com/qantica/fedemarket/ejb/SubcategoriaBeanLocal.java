package com.qantica.fedemarket.ejb;

import java.util.List;

import javax.ejb.Local;

import com.qantica.fedemarket.entidad.Subcategoria;

@Local
public interface SubcategoriaBeanLocal {
	
	public void adicionarSubcategoria(Subcategoria subcategoria);
	public void actualizarSubcategoria(Subcategoria subcategoria);
	public Subcategoria buscarSubcategoria(int id);
	public List<Subcategoria> listarSubcategorias(int categoria);
	public List<Subcategoria> listarSubcategoriasNivel(int subcategoria);

}
