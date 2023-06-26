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
import ar.edu.unju.fi.service.IEmpleadoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	/**
	 * Muestra la lista de empleados.
	 * @param modelo utilizado para pasar la lista a la vista.
	 * @return vista "empleados" que muestra la lista de empleados.
	 */
	@GetMapping("/listado")
	public String mostrarEmpleados(Model model) {
		model.addAttribute("empleados", empleadoService.getListaEmpleados());
	    return "empleados";
	}
	
	/**
	 * Muestra el formulario para crear un nuevo empleado.
	 * @param modelo utilizado para pasar el nuevo empleado a la vista.
	 * @return vista "nuevo_empleado" que muestra el formulario para crear un nuevo empleado.
	 */
	@GetMapping("/nuevo_empleado")
	public String getNuevoEmpleado(Model model) {
		boolean edicion = false;
		
		model.addAttribute("empleado", empleadoService.nuevoEmpleado());
		model.addAttribute("edicion", edicion);
		
		return "nuevo_empleado";
	}
	
	/**
	 * Guarda un nuevo empleado.
	 * @param objeto de tipo Empleado a guardar.
	 * @param result objeto BindingResult que contiene los resultados de la validación.
	 * @return modelo y vista "empleados" que muestra la lista actualizada de empleados.
	 */
	@PostMapping("/guardar_empleado")
	public ModelAndView getGuardarEmpleado(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult result) {
		
		ModelAndView modelView = new ModelAndView("empleados");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_empleado");
			modelView.addObject("empleado", empleado);
			return modelView;
		}
		empleadoService.guardarEmpleado(empleado);
		
		return modelView;
	}
	
	/**
	 * Muestra el formulario para modificar un empleado.
	 * @param modelo utilizado para pasar el empleado encontrado a la vista.
	 * @param id del empleado a modificar.
	 * @return vista "nuevo_empleado" que muestra el formulario para modificar un empleado.
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarEmpleadao(Model model, @PathVariable(value="id") Long id) {
		boolean edicion = true;
		
		model.addAttribute("empleado", empleadoService.findEmpleadoById(id));
		model.addAttribute("edicion", edicion);
		return "nuevo_empleado";
	}
	
	/**
	 * Modifica un empleado existente.
	 * @param empleadoModificado objeto de tipo Empleado con los datos modificados.
	 * @param result objeto BindingResult que contiene los resultados de la validación.
	 * @param model modelo utilizado para pasar datos a la vista.
	 * @return redirección a la lista de empleados.
	 */
	@PostMapping("/modificar_empleado")
	public String modificarEmpleado(@Valid @ModelAttribute("empleado") Empleado empleadoModificado, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("empleado", empleadoModificado);
			model.addAttribute("edicion", true);
			return "nuevo_empleado";
		}
		
		empleadoService.modificarEmpleado(empleadoModificado);
		
		return "redirect:/empleados/listado";
	}
	
	/**
	 * Elimina un empleado.
	 * @param id del empleado a eliminar.
	 * @return redirección a la lista de empleados.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(value="id") Long id) {
		
		empleadoService.eliminarEmpleado(empleadoService.findEmpleadoById(id));
		
		return "redirect:/empleados/listado";
	}

}
