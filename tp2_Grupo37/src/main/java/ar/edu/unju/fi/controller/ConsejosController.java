package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;

@Controller
@RequestMapping("/consejos")
public class ConsejosController {
	
	@Autowired
	ListaConsejo listaConsejo;
	
	@Autowired
	private Consejo consejo;
	
	@GetMapping("/listado")
	public String mostrarConsejos(Model model) {
		model.addAttribute("consejos", listaConsejo.getConsejos());
	    return "consejos";
	}
	
	@GetMapping("/nuevo_consejo")
	public String getNuevoConsejo(Model model) {
		boolean edicion=false;
		
		model.addAttribute("consejo", consejo);
		model.addAttribute("edicion", edicion);
		
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardar_consejo")
	public ModelAndView getGuardarConsejo(@ModelAttribute("consejo") Consejo consejo) {
		int ultimaId=0;
		
		ModelAndView modelView = new ModelAndView("consejos");
		
		for(Consejo ultimoElemento : listaConsejo.getConsejos()) {
			ultimaId = ultimoElemento.getId();
		}
		ultimaId++;
		consejo.setId(ultimaId);
		
		listaConsejo.getConsejos().add(consejo);
		
		modelView.addObject("consejos", listaConsejo.getConsejos());
		
		return modelView;
	}
	
	@GetMapping("/modificar_consejo/{id}")
	public String getModificarConsejo(Model model, @PathVariable(value="id") int id) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion = true;
		
		for(Consejo consejo : listaConsejo.getConsejos()) {
			if(consejo.getId() == id) {
				consejoEncontrado = consejo;
				break;
			}
		}
		
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}

	@PostMapping("/modificar_consejo")
	public String modificarConsejo(@ModelAttribute("consejo") Consejo consejoModificado) {
		for(Consejo consejo : listaConsejo.getConsejos()) {
			if(consejo.getId() == consejoModificado.getId()) {
				consejo.setTitulo(consejoModificado.getTitulo());
				consejo.setTexto(consejoModificado.getTexto());
				consejo.setClave(consejoModificado.getClave());
				break;
			}
		}
		return "redirect:/consejos/listado";
	}
	
	@GetMapping("/eliminar_consejo/{id}")
	public String eliminarConsejo(@PathVariable(value="id") int id) {
		for(Consejo consejo : listaConsejo.getConsejos()) {
			if(consejo.getId() == id) {
				listaConsejo.getConsejos().remove(consejo);
				break;
			}
		}
		return "redirect:/consejos/listado";
	}
}