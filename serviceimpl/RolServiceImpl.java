package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.dao.IRolDao;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.service.IRolService;

@Named 
@RequestScoped 
public class RolServiceImpl implements IRolService{
	@Inject 
	private IRolDao rD;
	
	@Override
	public void Insertar(Rol rol) {
		try {
			rD.insertar(rol);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<Rol> listar() {
		return rD.listar();

	}
}
