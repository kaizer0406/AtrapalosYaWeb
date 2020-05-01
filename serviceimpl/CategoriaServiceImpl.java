package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICategoriaDao;
import pe.edu.upc.entity.Categoria;
import pe.edu.upc.service.ICategoriaService;

@Named 
@RequestScoped 
public class CategoriaServiceImpl implements ICategoriaService {
	@Inject 
	private ICategoriaDao cD;
	
	@Override
	public void Insertar(Categoria categoria) {
		try {
			cD.insertar(categoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public List<Categoria> listar() {
		return cD.listar();
}}
