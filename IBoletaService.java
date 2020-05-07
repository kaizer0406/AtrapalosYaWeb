package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Boleta;

public interface IBoletaService {
	
	public void insertar(Boleta boleta);
	
	public void eliminar(Integer idBoleta);
	
	public List<Boleta> list();

}
