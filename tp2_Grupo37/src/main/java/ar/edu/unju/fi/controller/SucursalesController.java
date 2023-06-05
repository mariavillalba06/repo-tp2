package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

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

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	@Autowired
	private ListaSucursal listasucursal;
	
	@Autowired
	private Sucursal sucursal;
	
	@GetMapping("/listado")
	public 	String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", listasucursal.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalesPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevaPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("sucursales");
		if(result.hasErrors()) {
			modelandview.setViewName("nueva_sucursal");
			modelandview.addObject("sucursal", sucursal);
			return modelandview;
		}
		listasucursal.getSucursales().add(sucursal);
		modelandview.addObject("sucursales", listasucursal.getSucursales());
		return modelandview;
	}
	@GetMapping("/modificar/{nombre}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="nombre")String nombre) {
		Sucursal sucursalEncontrada = new Sucursal();
		boolean edicion=true;
		for(Sucursal sucu : listasucursal.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				sucursalEncontrada=sucu;
				break;
			}
		}
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("sucursal", sucursal);
			model.addAttribute("edicion", true);
			return "nueva_sucursal";
		}
		
		
		for(Sucursal sucu : listasucursal.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setEmail(sucursal.getEmail());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				}
			
		}
		return "redirect:/sucursal/listado";
	}
	@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value="nombre")String nombre) {
		for(Sucursal sucu : listasucursal.getSucursales()) {
		if(sucu.getNombre().equals(nombre)) {
			listasucursal.getSucursales().remove(sucu);
			break;
		}
	}
		return "redirect:/sucursal/listado";
}
}
	