package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Tienda;

public interface ITiendaService {
	
	public void insertar(Tienda tienda);
	
	public List<Tienda> listar();

}
