package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPersonalDao;
import pe.edu.upc.entity.Personal;


public class PersonalDaoImpl implements IPersonalDao, Serializable{

	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Personal personal) {
		try {
			em.persist(personal);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personal> listar() {
		List<Personal> listPersonales = new ArrayList<Personal>();
		try {
			Query q = em.createQuery("select pe from Personal pe");
			listPersonales = (List<Personal>) q.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listPersonales;
	}
	@Transactional
	@Override
	public void eliminar(int idPersonal) {
		Personal per = new Personal();
		try {
			per = em.getReference(Personal.class, idPersonal);
			em.remove(per);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	

}
