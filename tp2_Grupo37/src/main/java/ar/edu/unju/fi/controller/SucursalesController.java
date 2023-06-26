package ar.edu.unju.fi.controller;


import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	@Autowired
	private IProvinciaService provinciaService;
	
	@Autowired
	private Provincia provincia;
	
	
	/**
	 * Método que obtiene la lista de sucursales
	 * @param model utilizado para pasar datos a la vista
	 * @return retorna la vista "sucursales"
	 */
	@GetMapping("/listado")
	public 	String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		return "sucursales";
	}
	
	/**
	 * Solicitud GET para mostrar la página de creación de una nueva sucursal.
	 * @param model utilizado para pasar datos a la vista
	 * @return retorna la vista "nueva_sucursal"
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursalesPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", sucursalService.getSucursal());
		model.addAttribute("provincias", provinciaService.getListaProvincias());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	/**
	 * Solicitud POST para guardar una sucursal
	 * @param sucursal contiene los datos a guardar
	 * @param result recupera el resultado de las validaciones 
	 * @return retorna un objeto ModelAndView que representa la vista "sucursal"
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevaPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("sucursales");
		if(result.hasErrors()) {
			modelandview.setViewName("nueva_sucursal");
			modelandview.addObject("provincias", provinciaService.getListaProvincias());
			modelandview.addObject("sucursal", sucursal);
			return modelandview;
		}
		sucursalService.guardar(sucursal);
		
		provincia = provinciaService.findProvinciaById(sucursal.getProvincia().getId());
		
		sucursal.setProvincia(provincia);
		
		modelandview.addObject("sucursales", sucursalService.getLista());
		return modelandview;
	}
	
	/**
	 * Solicitud GET para modificar una sucursal
	 * @param model utilizado para pasar datos a la vista
	 * @param nombre identificador de la sucursal a modificar
	 * @return retorna la vista "nueva_sucursal" con la modificacion de la sucursal
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="id") Long id) {

		boolean edicion=true;
		model.addAttribute("sucursal", sucursalService.getById(id));
		model.addAttribute("provincias", provinciaService.getListaProvincias());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	/**
	 * Solicitud POST para modificar una sucursal
	 * @param sucursal contiene los datos de la sucursal a modificar
	 * @param result recupera el resultado de las validaciones 
	 * @param model utilizado para pasar datos a la vista
	 * @return redirige a la página de listado de sucursales actualizada
	 */
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("sucursal", sucursal);
			model.addAttribute("provincias", provinciaService.getListaProvincias());
			model.addAttribute("edicion", true);
			return "nueva_sucursal";
		}
		
		sucursalService.modificar(sucursal);
		return "redirect:/sucursal/listado";
	}
	
	/**
	 * Solicitud GET para eliminar una sucursal
	 * @param id identificador de la sucursal a eliminar
	 * @return redirige a la página de listado de sucursales actualizada
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value="id")Long id) {
		sucursalService.eliminar(sucursalService.getById(id));
		return "redirect:/sucursal/listado";
	}
	
	
	@PostMapping("/filtro_sucursal")
    public String recibirFecha(Model model, @RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaInicioFormateada = fechaInicio.format(formatter);
        String fechaFinFormateada = fechaFin.format(formatter);

        model.addAttribute("fechaInicio", fechaInicioFormateada);
        model.addAttribute("fechaFin", fechaFinFormateada);
        model.addAttribute("mensaje", true);
        
        model.addAttribute("sucursales", sucursalService.filtroSucursal(fechaInicio, fechaFin));
        
        

        return "sucursales";
    }
	
	@GetMapping("/gestion")
	public String getGestionSucursales(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		model.addAttribute("acciones", true);
		return "sucursales";
	}
}	