package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Personal;

public interface IPersonalDao {
	
	public void insertar(Personal personal);
	
	public List<Personal> listar();

}
