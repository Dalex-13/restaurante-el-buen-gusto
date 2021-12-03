package idat.edu.pe.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.servicios.ClienteServicio;


@RestController
@RequestMapping("/rest/clientes")
public class ClientesRestController {
	@Autowired
	private ClienteServicio servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Cliente> listaClientes=servicio.buscarTodo();
		return new ResponseEntity<>(listaClientes,HttpStatus.OK);
		
	}
}
