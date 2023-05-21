package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Contacto;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	@GetMapping("/nuevo")
	public String nuevoContacto(Model model) {
		Contacto contacto = new Contacto();
		model.addAttribute("contacto",  contacto);
		return "nuevo_contacto";
	}
	
	@PostMapping("/nuevo")
	public String mostrarContacto(Model model, Contacto contacto) {
		if (!contacto.getNombre().isEmpty() && !contacto.getEmail().isEmpty() && !contacto.getCiudad().isEmpty() && !contacto.getMensaje().isEmpty()) {
			model.addAttribute("nombre", contacto.getNombre());
			model.addAttribute("email", contacto.getEmail());
			model.addAttribute("ciudad", contacto.getCiudad());
			model.addAttribute("mensaje", contacto.getMensaje());
		}
		return "nuevo_contacto";
	}
}