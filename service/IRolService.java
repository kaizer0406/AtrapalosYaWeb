package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Rol;

public interface IRolService {
	public void Insertar(Rol rol);
	public List<Rol> listar();
}
