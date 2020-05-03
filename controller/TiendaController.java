package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Personal;
import pe.edu.upc.entity.Tienda;
import pe.edu.upc.service.IPersonalService;
import pe.edu.upc.service.ITiendaService;

@Named
@RequestScoped
public class TiendaController implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITiendaService tS;
	@Inject
	private IPersonalService peS;
	
	private Tienda tienda;
	private List<Tienda> listaTienda;
	private Personal personal;
	private List<Personal> listaPersonal;
	
	@PostConstruct
	public void init()
	{
		this.tienda= new Tienda();
		this.personal= new Personal();
		this.listaTienda = new ArrayList<Tienda>();
		this.listarTienda();
		this.listarPersonal();
	}
	
	
	
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public List<Tienda> getListaTienda() {
		return listaTienda;
	}
	public void setListaTienda(List<Tienda> listaTienda) {
		this.listaTienda = listaTienda;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public List<Personal> getListaPersonal() {
		return listaPersonal;
	}
	public void setListaPersonal(List<Personal> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}
	
      public void listarTienda() {
		
		try {
			this.listaTienda=tS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
      
     public void listarPersonal() {
		
		try {
			this.listaPersonal=peS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
     
     public String nuevaTienda()
     {
    	 this.setTienda(new Tienda());
    	 return "tienda.xhtml";
     }
     
     public void insertarTienda()
     {
    	 try {
    		 tS.insertar(this.tienda);
    		 limpiarTienda();
    		 listarTienda();		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
     }
     
     public void limpiarTienda()
     {
    	 this.init();
     }
	
	

}
