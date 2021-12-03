package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.repositorios.ClienteRepositorio;

@Service
@Transactional
public class ClienteServicio {

	 @Autowired
		private ClienteRepositorio repositorio;
		
		public ClienteServicio() {
			
		}
		
		public List<Cliente> buscarTodo(){
			return (List<Cliente>) repositorio.findAll();
		}
		
		
		public Cliente crear(Cliente cliente) {
			return repositorio.save(cliente);
		}
		
		
		public Cliente actualizar(Cliente clienteActualizar) {
			Cliente clienteActual = repositorio.findById(clienteActualizar.getIdCliente()).get();
			clienteActual.setNombre(clienteActualizar.getNombre());
			clienteActual.setApellido(clienteActualizar.getApellido());
				
			Cliente clienteActualizado = repositorio.save(clienteActual);
			return clienteActualizado;
			}
		
		public Cliente buscarPorID(Integer id) {
			return repositorio.findById(id).get();
		}

		public void borrarPorID(Integer id) {
			repositorio.deleteById(id);
		}
	
	
	
}
