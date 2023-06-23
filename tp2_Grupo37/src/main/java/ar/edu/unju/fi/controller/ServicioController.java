package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.ServicioCorte;
import ar.edu.unju.fi.entity.ServicioPaseo;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IListaService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private IListaService listaService;
	
	@Autowired
	private IServicioService servicioService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private Empleado empleado;
	
	/**
	 * Método que obtiene una lista de servicios según el tipo de servicio especificado.
	 *
	 * @param model    Objeto Model para pasar datos a la vista (lista de paseos o cortes)
	 * @param servicio Tipo de servicio especificado en la URL
	 * @return Regresa la vista "servicios"
	 */
	@GetMapping("/listado/{servicio}")
	public String getListaServicio(Model model, @PathVariable(value="servicio")String servicio) {
		boolean paseo, corte;
		
		// Comprobación del tipo de servicio
		if(servicio.equals("paseo")) {
			paseo=true;
			corte=false;
			model.addAttribute("paseos", servicioService.getServicioPaseos());
		} else {
			paseo=false;
			corte=true;
			model.addAttribute("cortes", servicioService.getServicioCortes());
		}
		model.addAttribute("acciones", false);
		model.addAttribute("paseo", paseo);
		model.addAttribute("corte", corte);

		return "servicios";
	}
	
	/**
	 * Redirige a la página de listado de servicios de paseos
	 *
	 */
	@GetMapping("/servicios-paseo")
	public String getServicioPaseos() {

		return "redirect:/servicios/listado/paseo";
	}
	
	/**
	 * Redirige a la página de listado de servicios de cortes
	 *
	 */
	@GetMapping("/servicios-corte")
	public String getServicioCortes() {
		
		return "redirect:/servicios/listado/corte";
	}
	
	
	//Servicio de paseos
	/**
	 * Maneja la solicitud GET para mostrar la página de creación de un nuevo paseo.
	 *
	 * @param modelo utilizado para pasar datos a la vista
	 * @return representa la vista "nuevo_paseo" con los datos necesarios
	 */
	@GetMapping("/nuevo-paseo")
	public String getNuevoPaseoPage(Model model) {
		// Variable que indica si se está en modo de edición el metodo
		boolean edicion=false;
		
		// Agrega un objeto ServicioPaseo vacío al modelo
		model.addAttribute("servicioPaseo", servicioService.nuevoPaseo());
		
		//Agrega la lista de los dias para el formulario
		model.addAttribute("dias", listaService.getDias());
		
		//Agrega la lista de los empleados para el formulario
		model.addAttribute("empleados", empleadoService.getListaEmpleados());
		
		// Agrega la variable "edicion" al modelo
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	
	/**
	 * Maneja la solicitud POST para guardar un servicio de paseo
	 *
	 * @param el objeto de ServicioPaseo que contiene los datos del paseo a guardar
	 * @return regresa un objeto ModelAndView que representa la vista "servicios"
	 */
	@PostMapping("/guardar-paseo")
	public ModelAndView getGuardarPaseoPage(@Valid @ModelAttribute("servicioPaseo") ServicioPaseo servicioPaseo, BindingResult result) {
		
		boolean paseo=true, corte=false;
		
		// Se crea un objeto ModelAndView con la vista "servicios"
		ModelAndView modelView = new ModelAndView("servicios");
		
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_paseo");
			modelView.addObject("dias", listaService.getDias());
			modelView.addObject("empleados", empleadoService.getListaEmpleados());
			modelView.addObject("servicioPaseo", servicioPaseo);
			return modelView;
		}
		
		// Agrega el servicioPaseo a la lista de paseos de servicio
		servicioService.guardarPaseo(servicioPaseo);
		
		empleado = empleadoService.findEmpleadoById(servicioPaseo.getEmpleado().getId());
		
		servicioPaseo.setEmpleado(empleado);
		
		// Agrega el listado de paseos al modelo del ModelAndView
		modelView.addObject("paseos", servicioService.getServicioPaseos());
		modelView.addObject("acciones", false);
		modelView.addObject("paseo", paseo);
		modelView.addObject("corte", corte);
		return modelView;
	}
	
	/**
	 * Maneja la solicitud GET para modificar un paseo de servicio.
	 *
	 * @param el objeto Model utilizado para pasar datos a la vista
	 * @param el ID del paseo de servicio a modificar
	 * @return retorna la cadena "nuevo_paseo" que representa la vista de modificación de paseo
	 */
	@GetMapping("/modificar-paseo/{id}")
	public String getModificarPaseo(Model model, @PathVariable(value="id") int id) {
		// Variable que indica si se está en modo de edición el metodo
		boolean edicion = true;
		
		// Agrega el objeto encontrado, la bandera al modelo, la lista de empleados y los dias
		model.addAttribute("servicioPaseo", servicioService.getByIdPaseo(id));
		model.addAttribute("dias", listaService.getDias());
		model.addAttribute("empleados", empleadoService.getListaEmpleados());
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	/**
	 * Maneja la solicitud POST para modificar un paseo de servicio.
	 *
	 * @param el objeto de ServicioPaseo contiene los datos del paseo a modificar
	 * @return redirige a la página de listado de servicios
	 */
	@PostMapping("/modificar-paseo")
	public ModelAndView modicarPaseo(@Valid @ModelAttribute("servicioPaseo")ServicioPaseo servicioPaseo, BindingResult result ) {
		ModelAndView modelView = new ModelAndView();
		
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_paseo");
			modelView.addObject("servicioPaseo", servicioPaseo);
			modelView.addObject("dias", listaService.getDias());
			modelView.addObject("empleados", empleadoService.getListaEmpleados());
			modelView.addObject("edicion", true);
			return modelView;
		}
		
		servicioService.modificarPaseo(servicioPaseo);
		
		modelView.setViewName("redirect:/servicios/listado/paseo");
		return modelView;
	}
	
	
	/**
	 * Maneja la solicitud GET para eliminar un paseo de servicio.
	 *
	 * @param ID del paseo a eliminar
	 * @return redirige a la página de listado de servicios
	 */
	@GetMapping("/eliminar-paseo/{id}")
	public String eliminarPaseo(@PathVariable(value="id") int id) {
		// Eliminamos el paseo utilizando su id en la lista
		servicioService.eliminarPaseo(servicioService.getByIdPaseo(id));
		
		return "redirect:/servicios/listado/paseo";
	}
	
	@GetMapping("/filtro-paseo/{dia}")
	public String getfiltoServicioPaseo(Model model, @PathVariable(value="dia")String dia) {
		boolean paseo, corte;
		
		//obtiene los servicios de acuerdo al dia correspondiente
		model.addAttribute("paseos", servicioService.filtroServicioPaseos(dia));
		paseo=true;
		corte=false;
		model.addAttribute("acciones", false);
		model.addAttribute("paseo", paseo);
		model.addAttribute("corte", corte);

		return "servicios";
	}
	
	
	//----Servicio de cortes----//
	/**
	 * Maneja la solicitud GET para la página "nuevo_corte".
	 * 
	 * @param el objeto Model utilizado para agregar atributos al modelo
	 * @return el nombre de la vista que se debe mostrar en pantalla
	 */
	@GetMapping("/nuevo-corte")
	public String getNuevoCortePage(Model model) {
		
		// Variable que indica si se está en modo de edición el metodo
		boolean edicion=false;
		
		// Agrega un nuevo objeto "ServicioCorte" al modelo
		model.addAttribute("servicioCorte", servicioService.nuevoCorte());
		// Agrega la lista de empleados al modelo
		model.addAttribute("empleados", empleadoService.getListaEmpleados());
		
		//Agrega la lista de los dias para el formulario
		model.addAttribute("dias", listaService.getDias());
		
		// Agregar la variable "edicion" al modelo
		model.addAttribute("edicion", edicion);
		return "nuevo_corte";
	}
	
	
	/**
	 * Maneja la solicitud POST para guardar un servicio de corte.
	 * 
	 * @param el objeto servicioCorte de ServicioCorte que contiene los datos del corte a guardar
	 * @return objeto ModelAndView que representa la vista "servicios" con los datos almacenados
	 */
	@PostMapping("/guardar-corte")
	public ModelAndView getGuardarCortePage(@Valid @ModelAttribute("servicioCorte") ServicioCorte servicioCorte, BindingResult result) {

		boolean paseo=false, corte=true;
		
		// Creación de un objeto ModelAndView para la vista "servicios"
		ModelAndView modelView = new ModelAndView("servicios");
		
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_corte");
			modelView.addObject("dias", listaService.getDias());
			modelView.addObject("servicioCorte", servicioCorte);
			modelView.addObject("empleados", empleadoService.getListaEmpleados());
			return modelView;
		}
		
		empleado = empleadoService.findEmpleadoById(servicioCorte.getEmpleado().getId());
		
		servicioCorte.setEmpleado(empleado);
		
		servicioService.guardarCorte(servicioCorte);
		
		// Agrega el listado de cortes al modelo del ModelAndView y valores booleanos
		modelView.addObject("cortes", servicioService.getServicioCortes());
		modelView.addObject("acciones", false);
		modelView.addObject("paseo", paseo);
		modelView.addObject("corte", corte);
		return modelView;
	}
	
	/**
	 * Maneja la solicitud GET para modificar un corte de servicio específico.
	 *
	 * @param el objeto Model utilizado para pasar datos a la vista
	 * @param el ID del corte de servicio que se desea modificar
	 * @return la vista "nuevo_corte" para modificar el corte de servicio
	 */
	@GetMapping("/modificar-corte/{id}")
	public String getModificarCorte(Model model, @PathVariable(value="id") int id) {
		// Variable que indica si se está en modo de edición el metodo
		boolean edicion = true;
		
		model.addAttribute("servicioCorte", servicioService.getByIdCorte(id));
		model.addAttribute("dias", listaService.getDias());
		model.addAttribute("empleados", empleadoService.getListaEmpleados());
		model.addAttribute("edicion", edicion);
		return "nuevo_corte";
	}
	
	
	/**
	 * Maneja la solicitud POST para modificar un corte de servicio existente.
	 *
	 * @param el objeto ServicioCorte que contiene los datos del corte a modificar
	 * @return Redirige a la página de listado de servicios
	 */
	@PostMapping("/modificar-corte")
	public String modicarCorte(@Valid @ModelAttribute("servicioCorte")ServicioCorte servicioCorte, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("servicioCorte", servicioCorte);
			model.addAttribute("dias", listaService.getDias());
			model.addAttribute("empleados", empleadoService.getListaEmpleados());
			model.addAttribute("edicion", true);
			return "nuevo_corte";
		}
		
		servicioService.modificarCorte(servicioCorte);
		
		return "redirect:/servicios/listado/corte";
	}
	
	
	/**
	 * Maneja la solicitud GET para eliminar un corte de servicio.
	 *
	 * @param el ID del corte de servicio a eliminar
	 * @return Redirige a la página de listado de servicios
	 */
	@GetMapping("/eliminar-corte/{id}")
	public String eliminarCorte(@PathVariable(value="id") int id) {
		
		// Eliminamos el corte utilizando su id en la lista
		servicioService.eliminarCorte(servicioService.getByIdCorte(id));
	    
	    return "redirect:/servicios/listado/corte";
	}
	
	@GetMapping("/filtro-corte/{dia}")
	public String getfiltoServicioCorte(Model model, @PathVariable(value="dia")String dia) {
		boolean paseo, corte;
		
		//obtiene los servicios de acuerdo al dia correspondiente
		model.addAttribute("cortes", servicioService.filtroServicioCortes(dia));
		paseo=false;
		corte=true;
		model.addAttribute("acciones", false);
		model.addAttribute("paseo", paseo);
		model.addAttribute("corte", corte);

		return "servicios";
	}
}
