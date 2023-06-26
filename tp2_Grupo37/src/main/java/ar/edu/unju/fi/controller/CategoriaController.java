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

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.service.ICategoriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;

	
	/**
	 * Muestra la lista de categorias.
	 * @param modelo utilizado para pasar la lista a la vista.
	 * @return vista "categorias" que muestra la lista de categorias.
	 */
	@GetMapping("/listado")
	public String mostrarCategorias(Model model) {
		model.addAttribute("categorias", categoriaService.getListaCategorias());
	    return "categorias";
	}
	
	/**
	 * Muestra el formulario para crear un nueva categoria.
	 * @param modelo utilizado para pasar la nueva categoria a la vista.
	 * @return vista "nueva_categoria" que muestra el formulario para crear un nueva categoria.
	 */
	@GetMapping("/nueva_categoria")
	public String getNuevaCategoria(Model model) {
		boolean edicion = false;
		
		model.addAttribute("categoria", categoriaService.nuevaCategoria());
		model.addAttribute("edicion", edicion);
		
		return "nueva_categoria";
	}
	
	/**
	 * Guarda un nueva categoria.
	 * @param objeto de tipo Categoria a guardar.
	 * @param result objeto BindingResult que contiene los resultados de la validación.
	 * @return modelo y vista "categorias" que muestra la lista actualizada de las categorias.
	 */
	@PostMapping("/guardar_categoria")
	public ModelAndView getGuardarCategoria(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result) {
		
		ModelAndView modelView = new ModelAndView("categorias");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_categoria");
			modelView.addObject("categoria", categoria);
			return modelView;
		}
		categoriaService.guardarCategoria(categoria);
		modelView.addObject("categorias", categoriaService.getListaCategorias());
		
		return modelView;
	}
	
	/**
	 * Muestra el formulario para modificar una categoria.
	 * @param modelo utilizado para pasar la categoria encontrada a la vista.
	 * @param id de la categoria a modificar.
	 * @return vista "nueva_categoria" que muestra el formulario para modificar una categoria.
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarCategoria(Model model, @PathVariable(value="id") Long id) {
		boolean edicion = true;
		
		model.addAttribute("categoria", categoriaService.findCategoriaById(id));
		model.addAttribute("edicion", edicion);
		return "nueva_categoria";
	}
	
	/**
	 * Modifica una categoria existente.
	 * @param categoriaModificada objeto de tipo Categoria con los datos modificados.
	 * @param result objeto BindingResult que contiene los resultados de la validación.
	 * @param model modelo utilizado para pasar datos a la vista.
	 * @return redirección a la lista de categorias
	 */
	@PostMapping("/modificar_categoria")
	public String modificarCategoria(@Valid @ModelAttribute("categoria") Categoria categoriaModificada, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("categoria", categoriaModificada);
			model.addAttribute("edicion", true);
			return "nueva_categoria";
		}
		
		categoriaService.modificarCategoria(categoriaModificada);
		
		return "redirect:/categorias/listado";
	}
	
	/**
	 * Elimina una categoria.
	 * @param id de la categoria a eliminar.
	 * @return redirección a la lista de categorias.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(value="id") Long id) {
		
		categoriaService.eliminarCategoria(categoriaService.findCategoriaById(id));
		
		return "redirect:/categorias/listado";
	}
}
