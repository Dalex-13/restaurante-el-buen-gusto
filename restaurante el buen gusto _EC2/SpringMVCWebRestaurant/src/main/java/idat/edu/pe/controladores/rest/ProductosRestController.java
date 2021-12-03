package idat.edu.pe.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.servicios.ProductoServicio;

@RestController
@RequestMapping("/rest/productos")
public class ProductosRestController {
	@Autowired
	private ProductoServicio servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Producto> listaProductos=servicio.buscarTodo();
		return new ResponseEntity<>(listaProductos,HttpStatus.OK);
		
	}
}
