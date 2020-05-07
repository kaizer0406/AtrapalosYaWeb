package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.entity.Boleta;
import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.MedioPago;
import pe.edu.upc.entity.Tienda;
import pe.edu.upc.service.IBoletaService;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.IMedioPagoService;
import pe.edu.upc.service.ITiendaService;

@Named
@RequestScoped
public class BoletaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IBoletaService bS;
	@Inject
	private IClienteService cS;
	@Inject
	private IMedioPagoService mdS;
	@Inject
	private ITiendaService tS;

	private Boleta boleta;
	private Boleta boletaSeleccionada;
	private Cliente cliente;
	private MedioPago medioPago;
	private Tienda tienda;
	private List<Boleta> listaBoleta;
	private List<Cliente> listaCliente;
	private List<MedioPago> listaMedioPago;
	private List<Tienda> listaTienda;
	
	@PostConstruct
	public void init()
	{
		this.boleta= new Boleta();
		this.cliente= new Cliente();
		this.medioPago= new MedioPago();
		this.tienda= new Tienda();
		this.listaBoleta = new ArrayList<Boleta>();
		this.listarBoleta();
		this.listarCliente();
		this.listarMedioPago();
		this.listarTienda();
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	public Boleta getBoletaSeleccionada() {
		return boletaSeleccionada;
	}

	public void setBoletaSeleccionada(Boleta boletaSeleccionada) {
		this.boletaSeleccionada = boletaSeleccionada;
	}

	public List<Boleta> getListaBoleta() {
		return listaBoleta;
	}

	public void setListaBoleta(List<Boleta> listaBoleta) {
		this.listaBoleta = listaBoleta;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<MedioPago> getListaMedioPago() {
		return listaMedioPago;
	}

	public void setListaMedioPago(List<MedioPago> listaMedioPago) {
		this.listaMedioPago = listaMedioPago;
	}

	public List<Tienda> getListaTienda() {
		return listaTienda;
	}

	public void setListaTienda(List<Tienda> listaTienda) {
		this.listaTienda = listaTienda;
	}

	public void listarBoleta() {

		try {
			this.listaBoleta = bS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listarCliente() {

		try {
			this.listaCliente = cS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listarMedioPago() {

		try {
			this.listaMedioPago = mdS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listarTienda() {

		try {
			this.listaTienda = tS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String nuevaBoleta() {
		this.setBoleta(new Boleta());
		return "boleta.xhtml";
	}
	
	public void insertar() {
		try {
			bS.insertar(boleta);
			limpiarBoleta();
			this.listarBoleta();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarBoleta() {
		this.init();
	}

	public void eliminarBoleta(Integer idBoleta) {
		try {
			bS.eliminar(idBoleta);
			listarBoleta();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void selectBoleta(SelectEvent e) {
		this.boletaSeleccionada = (Boleta) e.getObject();
	}

}
