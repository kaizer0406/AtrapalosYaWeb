package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Rol;
import pe.edu.upc.service.IRolService;

@Named
@RequestScoped
public class RolController {
	@Inject
	private IRolService rS;
	private Rol rol;
	List<Rol> listaRoles;
	
	@PostConstruct
	public void init() {
		this.listaRoles = new ArrayList<Rol>();
		this.rol = new Rol();
		this.listar();
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
	public String nuevoRol() {
		this.setRol(new Rol());
		return "rol.xhtml"; 
	}
	
	public void listar() {
		try {
			listaRoles = rS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}


	public void insertar() {
		try {
			rS.Insertar(rol);
			limpiarRol();
			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarRol() {
		this.init();

	}
}
