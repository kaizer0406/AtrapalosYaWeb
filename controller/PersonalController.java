package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Personal;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.service.IPersonalService;
import pe.edu.upc.service.IRolService;

@Named
@RequestScoped
public class PersonalController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPersonalService peS;
	@Inject
	private IRolService rS;
	
	private Personal personal;
	private List<Personal> listaPersonal;
	private Rol rol;
	private List<Rol> listaRol;
	
	@PostConstruct
	public void init()
	{
		this.personal= new Personal();
		this.rol= new Rol();
		this.listaPersonal = new ArrayList<Personal>();
		this.listarPersonal();
		this.listarRol();
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<Rol> listaRol) {
		this.listaRol = listaRol;
	}
	
	public void listarPersonal() {
		
		try {
			this.listaPersonal=peS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
     public void listarRol() {
		
		try {
			this.listaRol=rS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
     
     public String nuevoPersonal()
     {
    	 this.setPersonal(new Personal());
    	 return "personal.xhtml";
     }
     
     public void insertarPersonal()
     {
    	 try {
    		 peS.insertar(this.personal);
    		 limpiarPersonal();
    		 listarPersonal();		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
     }
     
     public void limpiarPersonal()
     {
    	 this.init();
     }

}
