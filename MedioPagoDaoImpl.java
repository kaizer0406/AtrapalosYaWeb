package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IMedioPagoDao;
import pe.edu.upc.entity.MedioPago;


public class MedioPagoDaoImpl implements IMedioPagoDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;
	
	
	@Transactional
	@Override
	public void insertar(MedioPago mediopago) {
		try {
			em.persist(mediopago);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MedioPago> listar() {
		List<MedioPago> lista = new ArrayList<MedioPago>();
		try {
			Query q = em.createQuery("select m from MedioPago m");
			lista = (List<MedioPago>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	@Transactional
	@Override
	public void eliminar(int idMedioPago) {
		MedioPago mp = new MedioPago();
		try {
			mp = em.getReference(MedioPago.class, idMedioPago);
			em.remove(mp);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
