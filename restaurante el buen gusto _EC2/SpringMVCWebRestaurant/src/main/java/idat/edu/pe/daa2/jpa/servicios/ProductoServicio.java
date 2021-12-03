package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.repositorios.ProductoRepositorio;

@Service
@Transactional
public class ProductoServicio {

	 @Autowired
		private ProductoRepositorio repositorio;
		
		public ProductoServicio() {
			
		}
		
		public List<Producto> buscarTodo(){
			return (List<Producto>) repositorio.findAll();
		}
		
		
		public Producto crear(Producto producto) {
			return repositorio.save(producto);
		}
		
		
		public Producto actualizar(Producto productoActualizar) {
			Producto productoActual = repositorio.findById(productoActualizar.getIdProducto()).get();
			productoActual.setNombre(productoActualizar.getNombre());
			productoActual.setPrecio(productoActualizar.getPrecio());
			productoActual.setStock(productoActualizar.getStock());
				
			Producto productoActualizado = repositorio.save(productoActual);
			return productoActualizado;
			}
		
		public Producto buscarPorID(Integer id) {
			return repositorio.findById(id).get();
		}

		public void borrarPorID(Integer id) {
			repositorio.deleteById(id);
		}
	
	
}
