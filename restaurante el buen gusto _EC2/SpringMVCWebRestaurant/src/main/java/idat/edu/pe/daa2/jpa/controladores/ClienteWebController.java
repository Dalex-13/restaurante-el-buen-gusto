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

import idat.edu.pe.daa2.jpa.modelo.Cliente;
import idat.edu.pe.daa2.jpa.servicios.ClienteServicio;


@Controller
@RequestMapping("/clientes")
public class ClienteWebController {
	@Autowired
	private ClienteServicio servicio;
	
	@RequestMapping("/listarTodoCliente")
	public String listarClientes(Model model) {
		List<Cliente> listaClientes = servicio.buscarTodo();
		model.addAttribute("listaClientes", listaClientes);
		return "/moduloCliente/listarTodoCliente";
	}

	@RequestMapping("/nuevo")
	public String nuevaSede(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);		
		return "/moduloCliente/nuevoCliente";
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		 servicio.crear(cliente);
	    return "redirect:/clientes/listarTodoCliente";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCliente(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloCliente/editarCliente");
	    Cliente cliente = servicio.buscarPorID(id);
	    mav.addObject("cliente", cliente);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarCliente(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/clientes/listarTodoCliente";       
	}
}
