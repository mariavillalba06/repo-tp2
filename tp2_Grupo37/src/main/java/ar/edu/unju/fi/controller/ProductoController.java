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
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
	
	/*@Autowired
	private IListaService listaService;*/
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private Categoria categoria;
	
	/**
	 * Método que obtiene la lista de producto
	 * @param model utilizado para pasar datos a la vista
	 * @return retorna la vista "productos"
	 */
	@GetMapping("/listas")
	public String getProductoPage(Model model) {
		model.addAttribute("productos", productoService.getLista());
		model.addAttribute("categorias", categoriaService.getListaCategorias());
		return "productos";
	}
	
	/**
	 * Solicitud GET para mostrar la página de creación de un nuevo producto.
	 * @param model utilizado para pasar datos a la vista
	 * @return retorna la vista "nuevo_producto"
	 */
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("productos", productoService.getProducto());
		//model.addAttribute("Categorias", listaService.getCategorias());
		model.addAttribute("categorias", categoriaService.getListaCategorias());
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	
	/**
	 * Solicitud POST para guardar un producto
	 * @param producto contiene los datos a guardar
	 * @param result  recupera el resultado de las validaciones 
	 * @return retorna un objeto ModelAndView que representa la vista "productos"
	 */
	@PostMapping("/guardarse")
	public ModelAndView getGuardarNuevaPage(@Valid @ModelAttribute("productos")Producto producto, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelandview.setViewName("nuevo_producto");
			//modelandview.addObject("categorias", listaService.getCategorias());
			modelandview.addObject("categorias", categoriaService.getListaCategorias());
			modelandview.addObject("productos", producto);
			return modelandview;
		}
		
		productoService.guardarse(producto);
		
		categoria = categoriaService.findCategoriaById(producto.getCategoria().getId());
		
		producto.setCategoria(categoria);
		modelandview.addObject("productos", productoService.getLista());
		return modelandview;
	}
	
	
	/**
	 * Solicitud GET para modificar un producto
	 * @param model utilizado para pasar datos a la vista
	 * @param codigo identificador del producto a modificar
	 * @return retorna la vista "nuevo_producto" con la modificacion del producto
	 */
	@GetMapping("/modificarse/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")Long codigo) {
		//Producto productoEncontrado = productoService.getBy(codigo);
		boolean edicion=true;
		
		model.addAttribute("productos", productoService.getBy(codigo));
		model.addAttribute("categorias", categoriaService.getListaCategorias());
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	
	/**
	 * Solicitud POST para modificar un producto
	 * @param producto contiene los datos del producto a modificar
	 * @param result recupera el resultado de las validaciones 
	 * @param model utilizado para pasar datos a la vista
	 * @return redirige a la página de listado de productos actualizada
	 */
	@PostMapping("/modificarse")
	public String modificarProducto(@Valid @ModelAttribute("productos")Producto producto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("productos", producto);
			model.addAttribute("categorias", categoriaService.getListaCategorias());
			model.addAttribute("edicion", true);
			return "nuevo_producto";
		}
		
		productoService.modificarse(producto);
		
		return "redirect:/Producto/listas";
	}
	
	/**
	 * Solicitud GET para eliminar un producto
	 * @param codigo identificador del producto a eliminar
	 * @param productoEncontrado es la variable donde se gurda el codigo
	 * @return redirige a la página de listado de productos actualizada
	 */
	@GetMapping("/eliminarse/{codigo}")
	public String eliminarProducto(@PathVariable(value="codigo")Long codigo) {
		//Producto productoEncontrado = productoService.getBy(codigo);
		productoService.eliminarse(productoService.getBy(codigo));
		return "redirect:/Producto/listas";
	}
	
	@GetMapping("/gestion")
	public String getGestionProductos(Model model) {
		model.addAttribute("productos", productoService.getLista());
		model.addAttribute("acciones", true);
		return "productos";
	}
	
}
