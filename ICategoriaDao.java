package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Categoria;

public interface ICategoriaDao {
	public void insertar(Categoria categoria);
	public List<Categoria> listar();
	public void eliminar(int idCategoria);
}
