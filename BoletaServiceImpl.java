package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IBoletaDao;
import pe.edu.upc.entity.Boleta;
import pe.edu.upc.service.IBoletaService;

@Named
@RequestScoped
public class BoletaServiceImpl implements IBoletaService, Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IBoletaDao bD;

	@Override
	public void insertar(Boleta boleta) {		
		bD.insertarBoleta(boleta);
	}

	@Override
	public void eliminar(Integer idBoleta) {
		bD.eliminar(idBoleta);		
	}

	@Override
	public List<Boleta> list() {		
		return bD.listar();
	}

}
