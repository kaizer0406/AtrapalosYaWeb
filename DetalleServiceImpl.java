package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDetalleBoletaDao;
import pe.edu.upc.entity.DetalleBoleta;
import pe.edu.upc.service.IDetalleBoletaService;

@Named
@RequestScoped
public class DetalleServiceImpl implements IDetalleBoletaService,Serializable{

	
	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleBoletaDao dboB;
	
	@Override
	public void insertar(DetalleBoleta detalleBoleta) {
		dboB.insertar(detalleBoleta);
		
	}

	@Override
	public List<DetalleBoleta> list() {
		
		return dboB.listar();
	}

}
