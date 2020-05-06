package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.MedioPago;

public interface IMedioPagoService {
	public void Insertar(MedioPago mediopago);

	public List<MedioPago> listar();
	
	public void eliminar(int idMedioPago);
}
