package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Tienda;

public interface ITiendaDao {
	
	public void insertar(Tienda tienda);
	
	public List<Tienda> listar();

}
