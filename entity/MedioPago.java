package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "MedioPago")
public class MedioPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedioPago;
	
	@Column(name = "desMedioPago", nullable = false, length = 45)
	private String desMedioPago;
	
	@Column(name = "seguridad", nullable = false, length = 5)
	private String seguridad;
	
	public MedioPago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMedioPago() {
		return idMedioPago;
	}

	public void setIdMedioPago(int idMedioPago) {
		this.idMedioPago = idMedioPago;
	}

	public String getDesMedioPago() {
		return desMedioPago;
	}

	public void setDesMedioPago(String desMedioPago) {
		this.desMedioPago = desMedioPago;
	}

	public String getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMedioPago;
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
		MedioPago other = (MedioPago) obj;
		if (idMedioPago != other.idMedioPago)
			return false;
		return true;
	}
}
