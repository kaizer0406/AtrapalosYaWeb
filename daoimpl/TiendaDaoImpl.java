package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITiendaDao;
import pe.edu.upc.entity.Tienda;

public class TiendaDaoImpl implements ITiendaDao, Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;

	
	@Transactional
	@Override
	public void insertar(Tienda tienda) {
		try {
			em.persist(tienda);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tienda> listar() {
		List<Tienda> listaTiendas=new ArrayList<Tienda>();
		try {
			Query q = em.createQuery("select t from Tienda t");
			listaTiendas = (List<Tienda>) q.getResultList();		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaTiendas;
	}

}
