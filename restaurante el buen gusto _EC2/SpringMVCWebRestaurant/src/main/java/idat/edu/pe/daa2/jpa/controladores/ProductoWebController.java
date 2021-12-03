package idat.edu.pe.daa2.jpa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Producto;
import idat.edu.pe.daa2.jpa.servicios.ProductoServicio;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {
	@Autowired
	private ProductoServicio servicio;
	
	@RequestMapping("/listarTodoProducto")
	public String listarProductos(Model model) {
		List<Producto> listaProductos = servicio.buscarTodo();
		model.addAttribute("listaProductos", listaProductos);
		return "/moduloProducto/listarTodoProducto";
	}

	@RequestMapping("/nuevo")
	public String nuevaSede(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);		
		return "/moduloProducto/nuevoProducto";
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearProducto(@ModelAttribute("producto") Producto producto) {
		 servicio.crear(producto);
	    return "redirect:/productos/listarTodoProducto";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarProducto(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloProducto/editarProducto");
	    Producto producto = servicio.buscarPorID(id);
	    mav.addObject("producto", producto);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarProducto(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/productos/listarTodoProducto";       
	}
}
