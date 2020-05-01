package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Producto;

public interface IProductoService {
	public void insertar(Producto producto);
	public List<Producto> listar();
}
