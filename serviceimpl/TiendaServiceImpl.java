package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITiendaDao;
import pe.edu.upc.entity.Tienda;
import pe.edu.upc.service.ITiendaService;

@Named
@RequestScoped
public class TiendaServiceImpl implements ITiendaService, Serializable{

	
	private static final long serialVersionUID = 1L;

	@Inject
	private ITiendaDao tD;
	
	@Override
	public void insertar(Tienda tienda) {
		tD.insertar(tienda);
		
	}

	@Override
	public List<Tienda> listar() {
		// TODO Auto-generated method stub
		return tD.listar();
	}

}
