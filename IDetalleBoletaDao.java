package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.DetalleBoleta;

public interface IDetalleBoletaDao {
	
	public void insertar(DetalleBoleta detalleBoleta);
	
	public List<DetalleBoleta> listar();

}
