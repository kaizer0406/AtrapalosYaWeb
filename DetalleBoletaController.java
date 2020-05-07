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
import pe.edu.upc.entity.DetalleBoleta;
import pe.edu.upc.entity.Producto;
import pe.edu.upc.service.IBoletaService;
import pe.edu.upc.service.IDetalleBoletaService;
import pe.edu.upc.service.IProductoService;
import pe.edu.upc.util.Message;

@Named
@RequestScoped
public class DetalleBoletaController implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDetalleBoletaService dbS;
	@Inject
	private IBoletaService bS;
	@Inject
	private IProductoService pS;
	
	private DetalleBoleta detalleBoleta;
	private DetalleBoleta detalleBoletaSeleccionada;
	private Boleta boleta;
	private Producto producto;
	private List<DetalleBoleta> listaDetalleBoleta;
	private List<Boleta> listaBoleta;
	private List<Producto> listaProducto;
	
	@PostConstruct
	public void init()
	{
		this.detalleBoleta= new DetalleBoleta();
		this.boleta= new Boleta();
		this.producto= new Producto();
		this.listaDetalleBoleta = new ArrayList<DetalleBoleta>();
		this.listarDetalleBoleta();
		this.listarBoleta();
		this.listarProducto();
	}
	
	public DetalleBoleta getDetalleBoleta() {
		return detalleBoleta;
	}
	public void setDetalleBoleta(DetalleBoleta detalleBoleta) {
		this.detalleBoleta = detalleBoleta;
	}
	public DetalleBoleta getDetalleBoletaSeleccionada() {
		return detalleBoletaSeleccionada;
	}
	public void setDetalleBoletaSeleccionada(DetalleBoleta detalleBoletaSeleccionada) {
		this.detalleBoletaSeleccionada = detalleBoletaSeleccionada;
	}
	public Boleta getBoleta() {
		return boleta;
	}
	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public List<DetalleBoleta> getListaDetalleBoleta() {
		return listaDetalleBoleta;
	}
	public void setListaDetalleBoleta(List<DetalleBoleta> listaDetalleBoleta) {
		this.listaDetalleBoleta = listaDetalleBoleta;
	}
	public List<Boleta> getListaBoleta() {
		return listaBoleta;
	}
	public void setListaBoleta(List<Boleta> listaBoleta) {
		this.listaBoleta = listaBoleta;
	}
	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	public void listarBoleta() {

		try {
			this.listaBoleta = bS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listarProducto() {

		try {
			this.listaProducto = pS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listarDetalleBoleta() {

		try {
			this.listaDetalleBoleta = dbS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public String nuevoDetalleBoleta() {
		this.setDetalleBoleta(new DetalleBoleta());
		return "detalleBoleta.xhtml";
	}
	
	public void insertar() {
		try {
			dbS.insertar(detalleBoleta);
			limpiarDetalleBoleta();
			this.listarBoleta();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
    public String verDetalle() {
		String view = "";
		try {
			if (this.detalleBoletaSeleccionada != null) {
				this.detalleBoleta = detalleBoletaSeleccionada;

				view = "verDetalleBoleta.xhtml";
			} else {
				Message.messageInfo("Debe seleccionar un detalle");
			}
		} catch (Exception e) {
			Message.messageError("Error Personal :" + e.getMessage());
		}

		return view;
	}
	
	public void limpiarDetalleBoleta() {
		this.init();
	}
	
	public void selectDetalleBoleta(SelectEvent e) {
		this.detalleBoletaSeleccionada = (DetalleBoleta) e.getObject();
	}

}
