package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IClienteDao;
import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;
@Named 
@RequestScoped 
public class ClienteServiceImpl implements IClienteService{
	@Inject 
	private IClienteDao cD;
	
	@Override
	public void Insertar(Cliente cliente) {
		try {
			cD.insertar(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<Cliente> listar() {
		return cD.listar();

	}

	@Override
	public void eliminar(int idCliente) {
		cD.eliminar(idCliente);
		
	}
}
