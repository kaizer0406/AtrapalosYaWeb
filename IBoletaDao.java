package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Boleta;

public interface IBoletaDao {
	
	public void insertarBoleta(Boleta boleta);
	
	public void eliminar(Integer idBoleta);
	
	public List<Boleta> listar();

}
