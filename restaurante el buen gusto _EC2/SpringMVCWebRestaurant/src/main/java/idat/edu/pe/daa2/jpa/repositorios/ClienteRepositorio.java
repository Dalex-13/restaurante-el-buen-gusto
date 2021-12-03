package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Cliente;




public interface ClienteRepositorio extends CrudRepository<Cliente,Integer>{

	@Query(value="SELECT s FROM Cliente s WHERE s.nombre=?1")
	public List<Cliente> buscarClientePorNombre(String nombre);
	
	@Query(value="SELECT s FROM Cliente s WHERE s.nombre like CONCAT(?1,'%')")
	public List<Cliente> buscarClienteLikeNombre(String nombre);
	
	
}
