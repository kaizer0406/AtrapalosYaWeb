package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Personal;

public interface IPersonalService {
	
	public void insertar(Personal personal);
	
	public List<Personal> listar();

}
