package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.MedioPago;

public interface IMedioPagoDao {
	public void insertar(MedioPago mediopago);
	public List<MedioPago> listar();
	public void eliminar(int idMedioPago);
}
