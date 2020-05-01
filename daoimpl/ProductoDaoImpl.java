package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProductoDao;
import pe.edu.upc.entity.Producto;

public class ProductoDaoImpl implements IProductoDao, Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "Coleccionaloya")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Producto producto1) {

		try {
			em.persist(producto1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> listar() {
		List<Producto> listproductos = new ArrayList<Producto>();
		try {
			Query q = em.createQuery("select p from Producto p");
			listproductos = (List<Producto>) q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return listproductos;
	}
	
}
