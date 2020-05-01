package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Producto;

public interface IProductoDao {
	public void insertar(Producto producto);
	public List<Producto> listar();
}
