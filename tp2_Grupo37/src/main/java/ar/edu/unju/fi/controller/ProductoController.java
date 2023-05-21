package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;



@Controller
@RequestMapping("/Producto")
public class ProductoController {

	ListaProducto listaproducto= new ListaProducto();
	
	@GetMapping("/listas")
	public String getProductoPage(Model model) {
		model.addAttribute("productos", listaproducto.getProductos());
		return "productos";
	}
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("productos", new Producto());
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	
	
	@PostMapping("/guardarse")
	public ModelAndView getGuardarNuevaPage(@ModelAttribute("productos")Producto producto) {
		ModelAndView modelandview = new ModelAndView("productos");
		listaproducto.getProductos().add(producto);
		modelandview.addObject("productos", listaproducto.getProductos());
		return modelandview;
	}
	
	
	
	@GetMapping("/modificarse/{nombrecod}")
	public String getModificarProductoPage(Model model, @PathVariable(value="nombrecod")String nombrecod) {
		Producto productoEncontrado = new Producto();
		boolean edicion=true;
		for(Producto produ : listaproducto.getProductos()) {
			if(produ.getNombrecod().equals(nombrecod)) {
				productoEncontrado=produ;
				break;
			}
		}
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	@PostMapping("/modificarse")
	public String modificarProducto(@ModelAttribute("producto")Producto producto) {
		for(Producto produ: listaproducto.getProductos()) {
			if(produ.getNombrecod().equals(producto.getNombrecod())) {
				produ.setCategoria(producto.getCategoria());
				produ.setCodigo(producto.getCodigo());
				produ.setDescuento(producto.getDescuento());
				produ.setPrecio(producto.getPrecio());
				}
		}
		return "redirect:/Producto/listas";
	}
	
	@GetMapping("/eliminarse/{nombrecod}")
	public String eliminarProducto(@PathVariable(value="nombrecod")String nombrecod) {
		for(Producto produ : listaproducto.getProductos()) {
		if(produ.getNombrecod().equals(nombrecod)) {
			listaproducto.getProductos().remove(produ);
			break;
		}
	}
		return "redirect:/Producto/listas";
}
	
}
