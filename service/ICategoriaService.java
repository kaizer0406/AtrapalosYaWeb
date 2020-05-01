package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Categoria;

public interface ICategoriaService {
	public void Insertar(Categoria categoria);
	public List<Categoria> listar();
}
