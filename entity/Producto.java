package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	@Column(name = "desProducto", nullable = false, length = 25)
	private String desProducto;
	
	@Column(name = "precioProducto", nullable = false, length = 25)
	private int precioProducto;
	
	@Column(name = "fechaFabricacion", nullable = false, length = 25)
	private Date fechaFabricacion;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;
	
	@Column(name = "procedencia", nullable = false, length = 20)
	private String procedencia;
	
	public Producto() {
		super();
	}

	public Producto(int idProducto, String desProducto, int precioProducto, Date fechaFabricacion, Categoria categoria,
			 String procedencia) {
		super();
		this.idProducto = idProducto;
		this.desProducto = desProducto;
		this.precioProducto = precioProducto;
		this.fechaFabricacion = fechaFabricacion;
		this.categoria = categoria;
		this.procedencia = procedencia;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDesProducto() {
		return desProducto;
	}

	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	
	
}

