package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import idat.edu.pe.daa2.jpa.modelo.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto,Integer>{

	@Query(value="SELECT s FROM Producto s WHERE s.nombre=?1")
	public List<Producto> buscarProductoPorNombre(String nombre);
	
	@Query(value="SELECT s FROM Producto s WHERE s.nombre like CONCAT(?1,'%')")
	public List<Producto> buscarProductoLikeNombre(String nombre);
	
}
