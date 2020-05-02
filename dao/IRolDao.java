package pe.edu.upc.dao;

import java.util.List;


import pe.edu.upc.entity.Rol;

public interface IRolDao {
	public void insertar(Rol rol);
	public List<Rol> listar();
}
