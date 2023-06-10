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

import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejosService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos")
public class ConsejosController {
	@Autowired
	private IConsejosService consejosService;
	
	/**
	 * Método que obtiene la lista de consejos
	 * @param model utilizado para pasar datos a la vista
	 * @return retorma la vista "consejos"
	 */
	@GetMapping("/listado")
	public String mostrarConsejos(Model model) {
		model.addAttribute("consejos", consejosService.getConsejos());
	    return "consejos";
	}
	
	/**
	 * Solicitud GET para mostrar la página de creación de un nuevo consejo.
	 * @param model utilizado para pasar datos a la vista
	 * @return retorna la vista "nuevo_consejo"
	 */
	@GetMapping("/nuevo_consejo")
	public String getNuevoConsejo(Model model) {
		boolean edicion=false;
		
		model.addAttribute("consejo", consejosService.nuevoConsejo());
		model.addAttribute("edicion", edicion);
		
		return "nuevo_consejo";
	}
	
	/**
	 * Solicitud POST para guardar un consejo
	 * @param consejo contiene los datos a guardar
	 * @param result  recupera el resultado de las validaciones 
	 * @return retorna un objeto ModelAndView que representa la vista "consejos"
	 */
	@PostMapping("/guardar_consejo")
	public ModelAndView getGuardarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		
		ModelAndView modelView = new ModelAndView("consejos");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_consejo");
			modelView.addObject("consejo", consejo);
			return modelView;
		}
		
		consejosService.guardarConsejo(consejo);
		
		modelView.addObject("consejos", consejosService.getConsejos());
		
		return modelView;
	}
	
	/**
	 * Solicitud GET para modificar un consejo
	 * @param model utilizado para pasar datos a la vista
	 * @param id identificador del consejo a modificar
	 * @return retorna la vista "nuevo_consejo" con la modificacion del consejo
	 */
	@GetMapping("/modificar_consejo/{id}")
	public String getModificarConsejo(Model model, @PathVariable(value="id") int id) {
		boolean edicion = true;
		
		model.addAttribute("consejo", consejosService.getByIdConsejo(id));
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}

	/**
	 * Solicitud POST para modificar un consejo
	 * @param consejoModificado contiene los datos del consejo a modificar
	 * @param result recupera el resultado de las validaciones 
	 * @param model utilizado para pasar datos a la vista
	 * @return redirige a la página de listado de consejos actualizada
	 */
	@PostMapping("/modificar_consejo")
	public String modificarConsejo(@Valid @ModelAttribute("consejo") Consejo consejoModificado, BindingResult result, Model model ) {
		
		if(result.hasErrors()) {
			model.addAttribute("consejo", consejoModificado);
			model.addAttribute("edicion", true);
			return "nuevo_consejo";
		}
		
		consejosService.modificarConsejo(consejoModificado);
		
		return "redirect:/consejos/listado";
	}
		
	/**
	 * Solicitud GET para eliminar un consejo
	 * @param id identificador del consejo a eliminar
	 * @return redirige a la página de listado de consejos actualizada
	 */
	@GetMapping("/eliminar_consejo/{id}")
	public String eliminarConsejo(@PathVariable(value="id") int id) {
		
		consejosService.eliminarConsejo(id);
		
		return "redirect:/consejos/listado";
	}
}