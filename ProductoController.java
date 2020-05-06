package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Producto;
import pe.edu.upc.service.ICategoriaService;
import pe.edu.upc.service.IProductoService;

@Named
@RequestScoped
public class ProductoController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductoService pS;
	@Inject
	private ICategoriaService cS;
	
	
	private Producto producto;
	private List<Producto> listproductos;
	private Categoria categoria;
	private List<Categoria> listcategoria;
	
	@PostConstruct
	public void init()
	{
		this.categoria= new Categoria();
		this.producto= new Producto();
		this.listproductos= new ArrayList<Producto>();
		//this.cancion= new Cancion();
		this.listarproductos();
		this.listarcategorias();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getListproductos() {
		return listproductos;
	}

	public void setListproductos(List<Producto> listproductos) {
		this.listproductos = listproductos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListcategoria() {
		return listcategoria;
	}

	public void setListcategoria(List<Categoria> listcategoria) {
		this.listcategoria = listcategoria;
	}
	
	
	public void listarproductos() {
		try {
			this.listproductos= pS.listar();			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void listarcategorias() {
		try {
			this.listcategoria = cS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public String nuevoProducto() {
		this.setProducto(new Producto());
		return "producto.xhtml"; 
	}
	public void insertarproducto() {
		
		try
		{
			pS.insertar(this.producto);
			limpiarproducto();
			listarproductos();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void limpiarproducto()
	{
		this.init();
	}
	
	public void eliminar(int idProducto) {
		try {
			pS.eliminar(idProducto);
			listarproductos();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
