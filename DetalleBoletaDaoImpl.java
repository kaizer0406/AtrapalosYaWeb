package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDetalleBoletaDao;
import pe.edu.upc.entity.DetalleBoleta;

public class DetalleBoletaDaoImpl implements IDetalleBoletaDao,Serializable{

	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(DetalleBoleta detalleBoleta) {
		try {
			em.persist(detalleBoleta);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleBoleta> listar() {
		List<DetalleBoleta> listDetalleBoleta = new ArrayList<DetalleBoleta>();
		try {
			Query q = em.createQuery("select db from DetalleBoleta db");
			listDetalleBoleta = (List<DetalleBoleta>) q.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listDetalleBoleta;
	}
	

}
