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
@Table(name="Boleta")
public class Boleta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBoleta;
	
	@Column(name="desBoleta",nullable=false, length=40)
	private String desBoleta;
		
	@Column(name="fechaRegistro",nullable=false, length=40)
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name="idCliente",nullable =false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idTienda",nullable =false)
	private Tienda tienda;
	
	@ManyToOne
	@JoinColumn(name="idMedioPago",nullable =false)
	private MedioPago medioPago;

	public Boleta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boleta(Integer idBoleta, String desBoleta, Date fechaRegistro, Cliente cliente, Tienda tienda, MedioPago medioPago) {
		super();
		this.idBoleta = idBoleta;
		this.desBoleta = desBoleta;
		this.fechaRegistro = fechaRegistro;
		this.cliente = cliente;
		this.tienda = tienda;
		this.medioPago = medioPago;
	}

	public Integer getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Integer idBoleta) {
		this.idBoleta = idBoleta;
	}
	
	public String getDesBoleta() {
		return desBoleta;
	}

	public void setDesBoleta(String desBoleta) {
		this.desBoleta = desBoleta;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBoleta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleta other = (Boleta) obj;
		if (idBoleta != other.idBoleta)
			return false;
		return true;
	}

}
