package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleBoleta;

public interface IDetalleBoletaService {
	
	public void insertar(DetalleBoleta detalleBoleta);
	
	public List<DetalleBoleta> list();

}
