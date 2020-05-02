package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRolDao;
import pe.edu.upc.entity.Rol;

public class RolDaoImpl implements IRolDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;
	@Transactional
	@Override
	public void insertar(Rol rol) {
		try {
			em.persist(rol);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> listar() {
		List<Rol> lista = new ArrayList<Rol>();
		try {
			Query q = em.createQuery("select r from Rol r");
			lista = (List<Rol>) q.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
}
