package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IBoletaDao;
import pe.edu.upc.entity.Boleta;

public class BoletaDaoImpl implements IBoletaDao, Serializable{


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;

	@Transactional
	@Override
	public void insertarBoleta(Boleta boleta) {
		try {
			em.persist(boleta);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Transactional
	@Override
	public void eliminar(Integer idBoleta) {
		Boleta bol = new Boleta();
		try {
			bol = em.getReference(Boleta.class, idBoleta);
			em.remove(bol);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Boleta> listar() {
		List<Boleta> listBoletas = new ArrayList<Boleta>();
		try {
			Query q = em.createQuery("select b from Boleta b");
			listBoletas = (List<Boleta>) q.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listBoletas;
	}
	
	

}
