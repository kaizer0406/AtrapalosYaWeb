package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.service.ICategoriaService;

@Named
@RequestScoped
public class CategoriaController {
	@Inject
	private ICategoriaService cS;
	private Categoria categoria;
	List<Categoria> listaCategorias;
	
	
	@PostConstruct
	public void init() {
		this.listaCategorias = new ArrayList<Categoria>();
		this.categoria = new Categoria();
		this.listar();
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}


	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	public String nuevaCategoria() {
		this.setCategoria(new Categoria());
		return "categoria.xhtml"; 
	}
	
	public void listar() {
		try {
			listaCategorias = cS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void insertar() {
		try {
			cS.Insertar(categoria);
			limpiarCategoria();
			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void limpiarCategoria() {
		this.init();
	}
	
	public void eliminar(Categoria categoria) {
		try {
			cS.eliminar(categoria.getIdCategoria());
			listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
