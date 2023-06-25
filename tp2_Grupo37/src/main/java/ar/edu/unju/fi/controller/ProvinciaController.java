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

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.service.IProvinciaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/provincias")
public class ProvinciaController {
	
	@Autowired
	private IProvinciaService provinciaService;
	
	/**
	 * Muestra la lista de provincias.
	 * @param modelo utilizado para pasar la lista a la vista.
	 * @return vista "provincias" que muestra la lista de empleados.
	 */
	@GetMapping("/listado")
	public String mostrarProvincias(Model model) {
		model.addAttribute("provincias", provinciaService.getListaProvincias());
	    return "provincias";
	}
	
	/**
	 * Muestra el formulario para crear un nueva provincia.
	 * @param modelo utilizado para pasar la nueva provincia a la vista.
	 * @return vista "nueva_provincia" que muestra el formulario para crear un nuevo empleado.
	 */
	@GetMapping("/nueva_provincia")
	public String getNuevaProvincia(Model model) {
		boolean edicion = false;
		
		model.addAttribute("provincia", provinciaService.nuevaProvincia());
		model.addAttribute("edicion", edicion);
		
		return "nueva_provincia";
	}
	
	/**
	 * Guarda un nueva provincia.
	 * @param objeto de tipo Provincia a guardar.
	 * @param result objeto BindingResult que contiene los resultados de la validación.
	 * @return modelo y vista "provincias" que muestra la lista actualizada de las provincias.
	 */
	@PostMapping("/guardar_provincia")
	public ModelAndView getGuardarProvincia(@Valid @ModelAttribute("provincia") Provincia provincia, BindingResult result) {
		
		ModelAndView modelView = new ModelAndView("provincias");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_provincia");
			modelView.addObject("provincia", provincia);
			return modelView;
		}
		provinciaService.guardarProvincia(provincia);
		modelView.addObject("provincias",provinciaService.getListaProvincias());
		
		return modelView;
	}
	
	/**
	 * Muestra el formulario para modificar una provincia.
	 * @param modelo utilizado para pasar la provincia encontrado a la vista.
	 * @param id de la provincia a modificar.
	 * @return vista "nueva_provincia" que muestra el formulario para modificar una provincia.
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarProvincia(Model model, @PathVariable(value="id") Long id) {
		boolean edicion = true;
		
		model.addAttribute("provincia", provinciaService.findProvinciaById(id));
		model.addAttribute("edicion", edicion);
		return "nueva_provincia";
	}
	
	/**
	 * Modifica una provincia existente.
	 * @param provinciaModificada objeto de tipo Provincia con los datos modificados.
	 * @param result objeto BindingResult que contiene los resultados de la validación.
	 * @param model modelo utilizado para pasar datos a la vista.
	 * @return redirección a la lista de provincias.
	 */
	@PostMapping("/modificar_provincia")
	public String modificarProvincia(@Valid @ModelAttribute("provincia") Provincia provinciaModificada, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("provincia", provinciaModificada);
			model.addAttribute("edicion", true);
			return "nueva_provincia";
		}
		
		provinciaService.modificarProvincia(provinciaModificada);
		
		return "redirect:/provincias/listado";
	}
	
	/**
	 * Elimina una provincia.
	 * @param id de la provincia a eliminar.
	 * @return redirección a la lista de provincias.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarProvincia(@PathVariable(value="id") Long id) {
		
		provinciaService.eliminarProvincia(provinciaService.findProvinciaById(id));
		
		return "redirect:/provincias/listado";
	}
}
