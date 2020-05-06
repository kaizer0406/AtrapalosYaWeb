package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.MedioPago;
import pe.edu.upc.service.IMedioPagoService;

@Named
@RequestScoped
public class MedioPagoController {
	@Inject
	private IMedioPagoService mS;
	private MedioPago mediopago;
	List<MedioPago> listaMedioPagos;
	
	
	@PostConstruct
	public void init() {
		this.listaMedioPagos = new ArrayList<MedioPago>();
		this.mediopago = new MedioPago();
		this.listar();
	}


	public MedioPago getMediopago() {
		return mediopago;
	}


	public void setMediopago(MedioPago mediopago) {
		this.mediopago = mediopago;
	}


	public List<MedioPago> getListaMedioPagos() {
		return listaMedioPagos;
	}


	public void setListaMedioPagos(List<MedioPago> listaMedioPagos) {
		this.listaMedioPagos = listaMedioPagos;
	}
	
	
	
	public String nuevoMedioPago() {
		this.setMediopago(new MedioPago());
		return "mediopago.xhtml"; 
	}
	
	
	public void listar() {
		try {
			listaMedioPagos = mS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void insertar() {
		try {
			mS.Insertar(mediopago);
			limpiarMedioPago();
			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void limpiarMedioPago() {
		this.init();

	}
	
	public void eliminar(int idMedioPago) {
		try {
			mS.eliminar(idMedioPago);
			listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
