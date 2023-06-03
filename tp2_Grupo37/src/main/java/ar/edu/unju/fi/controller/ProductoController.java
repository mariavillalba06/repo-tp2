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

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
	@Autowired
	private ListaProducto listaProducto;
	
	@Autowired
	private Producto producto;
	
	@GetMapping("/listas")
	public String getProductoPage(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("productos", producto);
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	
	
	@PostMapping("/guardarse")
	public ModelAndView getGuardarNuevaPage(@Valid @ModelAttribute("productos")Producto producto, BindingResult result) {
		int ultimaId=0;
		ModelAndView modelandview = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelandview.setViewName("nuevo_producto");
			modelandview.addObject("productos", producto);
			return modelandview;
		}
		for(Producto ultimoElemento : listaProducto.getProductos()) {
			ultimaId = ultimoElemento.getCodigo();
		}
		ultimaId++;
		producto.setPrecioTotal(producto.calcularDescuento());
		producto.setCodigo(ultimaId);
		listaProducto.getProductos().add(producto);
		modelandview.addObject("productos", listaProducto.getProductos());
		return modelandview;
	}
	
	
	
	@GetMapping("/modificarse/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
		Producto productoEncontrado = new Producto();
		boolean edicion=true;
		for(Producto produ : listaProducto.getProductos()) {
			if(produ.getCodigo() == codigo) {
				productoEncontrado=produ;
				break;
			}
		}
		model.addAttribute("productos", productoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/modificarse")
	public String modificarProducto(@ModelAttribute("producto")Producto producto) {
		for(Producto produ: listaProducto.getProductos()) {
			if(produ.getCodigo() == producto.getCodigo()) {
				produ.setNombre(producto.getNombre());
				produ.setCategoria(producto.getCategoria());
				produ.setDescuento(producto.getDescuento());
				produ.setPrecio(producto.getPrecio());
				produ.setPrecioTotal(producto.calcularDescuento());
				break;
				}
		}	
		return "redirect:/Producto/listas";
	}
	
	@GetMapping("/eliminarse/{codigo}")
	public String eliminarProducto(@PathVariable(value="codigo")int codigo) {
		for(Producto produ : listaProducto.getProductos()) {
		if(produ.getCodigo() == codigo) {
			listaProducto.getProductos().remove(produ);
			break;
		}
	}
		return "redirect:/Producto/listas";
}
	
}
