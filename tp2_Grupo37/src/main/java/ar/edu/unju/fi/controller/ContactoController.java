package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Contacto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ContactoController {
	
	@Autowired
	Contacto contacto;
	
	@GetMapping("/contacto")
	public String mostrarContacto(Model model) {
		model.addAttribute("contacto",  contacto);
	    return "contacto";
	}
    @PostMapping("/contacto")
	public String mostrarContacto(@Valid @ModelAttribute("contacto") Contacto contacto, BindingResult result) {
    	ModelAndView modelView = new ModelAndView("contacto");
    	
    	if(result.hasErrors()) {
    		modelView.setViewName("contacto");
			modelView.addObject("contacto", contacto);
			return "contacto";
		}
    	contacto.setNombre(contacto.getNombre());
    	contacto.setEmail(contacto.getEmail());
    	contacto.setCiudad(contacto.getCiudad());
    	contacto.setMensaje(contacto.getMensaje());
		
    	
		return "nuevo_contacto";
		
	}
}