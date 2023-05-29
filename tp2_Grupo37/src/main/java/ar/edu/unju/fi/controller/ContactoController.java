package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Contacto;

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
	public String mostrarContacto(Model model, Contacto contacto) {
		model.addAttribute("nombre", contacto.getNombre());
		model.addAttribute("email", contacto.getEmail());
		model.addAttribute("ciudad", contacto.getCiudad());
		model.addAttribute("mensaje", contacto.getMensaje());
		return "nuevo_contacto";
	}
}