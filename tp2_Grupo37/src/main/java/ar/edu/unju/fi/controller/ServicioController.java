package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicioCorte;
import ar.edu.unju.fi.listas.ListaServicioPaseo;
import ar.edu.unju.fi.model.ServicioCorte;
import ar.edu.unju.fi.model.ServicioPaseo;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	ListaServicioPaseo listaPaseo = new ListaServicioPaseo();
	ListaServicioCorte listaCorte = new ListaServicioCorte();
	
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
			model.addAttribute("paseos", listaPaseo.getServicioPaseos());
		} else {
			paseo=false;
			corte=true;
			model.addAttribute("cortes", listaCorte.getServicioCortes());
		}
		
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
		model.addAttribute("servicioPaseo", new ServicioPaseo());
		
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
	public ModelAndView getGuardarPaseoPage(@ModelAttribute("servicioPaseo") ServicioPaseo servicioPaseo) {
		//valor utilizado para controlar el valor del ultima ID, se inicializa en 0 en caso de estar vacia
		int ultimaId=0;
		
		boolean paseo=true, corte=false;
		
		// Se crea un objeto ModelAndView con la vista "servicios"
		ModelAndView modelView = new ModelAndView("servicios");
		
		//Se posiciona en el ultimo elemento y obtine su ID e incrementarlo una unidad
		for(ServicioPaseo ultimoElemento : listaPaseo.getServicioPaseos()) {
			ultimaId = ultimoElemento.getId();
		}
		ultimaId++;
		servicioPaseo.setId(ultimaId);
		
		// Agrega el servicioPaseo a la lista de paseos de servicio
		listaPaseo.getServicioPaseos().add(servicioPaseo);
		
		// Agrega el listado de paseos y cortes al modelo del ModelAndView
		modelView.addObject("paseos", listaPaseo.getServicioPaseos());
		//modelView.addObject("cortes", listaCorte.getServicioCortes());
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
		// Crea un objeto ServicioPaseo para almacenar el objeto buscado
		ServicioPaseo paseoEncontrado = new ServicioPaseo();
		
		// Variable que indica si se está en modo de edición el metodo
		boolean edicion = true;
		
		// Busca el paseo de servicio correspondiente al ID proporcionado
		for(ServicioPaseo paseo : listaPaseo.getServicioPaseos()) {
			if(paseo.getId() == id) {
				paseoEncontrado = paseo;
				break;
			}
		}
		
		// Agrega el objeto encontrado y la bandera al modelo
		model.addAttribute("servicioPaseo", paseoEncontrado);
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
	public String modicarPaseo(@ModelAttribute("servicioPaseo")ServicioPaseo servicioPaseo) {
		// Recorre la lista de paseos de servicio para encontrar el objeto correspondiente al ID
		for(ServicioPaseo paseo : listaPaseo.getServicioPaseos()) {
			if(paseo.getId() == servicioPaseo.getId()) {
				// Actualiza los atributos del paseo con los valores del objeto servicioPaseo
				paseo.setDia(servicioPaseo.getDia());
				paseo.setHorarioInicio((byte)servicioPaseo.getHorarioInicio());
				paseo.setHorarioFinal((byte)servicioPaseo.getHorarioFinal());
				paseo.setNombre(servicioPaseo.getNombre());
				break;
			}
		}
		return "redirect:/servicios/listado/paseo";
	}
	
	
	/**
	 * Maneja la solicitud GET para eliminar un paseo de servicio.
	 *
	 * @param ID del paseo a eliminar
	 * @return redirige a la página de listado de servicios
	 */
	@GetMapping("/eliminar-paseo/{id}")
	public String eliminarPaseo(@PathVariable(value="id") int id) {
		// Recorre la lista de paseos de servicio para encontrar el objeto correspondiente al ID
		for(ServicioPaseo paseo : listaPaseo.getServicioPaseos()) {
			if(paseo.getId() == id) {
				// Elimina el paseo de la lista de paseos de servicio
				listaPaseo.getServicioPaseos().remove(paseo);
				break;
			}
		}
		return "redirect:/servicios/listado/paseo";
	}
	
	
	//Servicio de cortes
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
		model.addAttribute("servicioCorte", new ServicioCorte());
		
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
	public ModelAndView getGuardarCortePage(@ModelAttribute("servicioCorte") ServicioCorte servicioCorte) {
		//valor utilizado para controlar el valor del ultima ID, se inicializa en 0 en caso de estar vacia
		int ultimaId=0;
		
		boolean paseo=false, corte=true;
		
		// Creación de un objeto ModelAndView para la vista "servicios"
		ModelAndView modelView = new ModelAndView("servicios");
		
		//Se posiciona en el ultimo elemento y obtine su ID e incrementarlo una unidad
		for(ServicioCorte ultimoElemento : listaCorte.getServicioCortes()) {
			ultimaId = ultimoElemento.getId();
		}
		ultimaId++;
		
		// Establece el ID incrementado al objeto
		servicioCorte.setId(ultimaId);
		
		// Agrega el servicioCorte a la lista de cortes
		listaCorte.getServicioCortes().add(servicioCorte);
		
		// Agrega el listado de paseos y cortes al modelo del ModelAndView
		//modelView.addObject("paseos", listaPaseo.getServicioPaseos());
		modelView.addObject("cortes", listaCorte.getServicioCortes());
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
		ServicioCorte corteEncontrado = new ServicioCorte();
		// Variable que indica si se está en modo de edición el metodo
		boolean edicion = true;
		
		for(ServicioCorte corte : listaCorte.getServicioCortes()) {
			if(corte.getId() == id) {
				corteEncontrado = corte;
				break;
			}
		}
		
		model.addAttribute("servicioCorte", corteEncontrado);
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
	public String modicarCorte(@ModelAttribute("servicioCorte")ServicioCorte servicioCorte) {
		// Actualiza los datos del corte de servicio en la lista de cortes existentes
		for(ServicioCorte corte : listaCorte.getServicioCortes()) {
			if(corte.getId() == servicioCorte.getId()) {
				corte.setPesoMinimo((byte)servicioCorte.getPesoMinimo());
				corte.setPesoMaximo((byte)servicioCorte.getPesoMaximo());
				corte.setInstrumento(servicioCorte.getInstrumento());
				corte.setPrecio(servicioCorte.getPrecio());
				break;
			}
		}
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
	    // Busca el corte de servicio correspondiente al ID y lo elimina de la lista
	    for (ServicioCorte corte : listaCorte.getServicioCortes()) {
	        if (corte.getId() == id) {
	            listaCorte.getServicioCortes().remove(corte);
	            break;
	        }
	    }
	    
	    return "redirect:/servicios/listado/corte";
	}
}
