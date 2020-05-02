package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMedioPagoDao;
import pe.edu.upc.entity.MedioPago;
import pe.edu.upc.service.IMedioPagoService;

@Named 
@RequestScoped 
public class MedioPagoServiceImpl implements IMedioPagoService{

	@Inject 
	private IMedioPagoDao mD;
	
	@Override
	public void Insertar(MedioPago mediopago) {
		try {
			mD.insertar(mediopago);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<MedioPago> listar() {
		return mD.listar();

	}
}
