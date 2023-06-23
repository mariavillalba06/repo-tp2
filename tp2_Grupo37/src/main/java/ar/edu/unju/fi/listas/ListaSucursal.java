package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class ListaSucursal {
	
	private List<Sucursal> sucursales;
	
	/**
     * Constructor de la clase ListaSucursal
     * Permite inicializar la lista de sucursales con algunos bojetos percargados
     */
	public ListaSucursal() {
		sucursales=new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("tienda de mascotas","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas2","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas3","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas4","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas5","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
	}
	/**
     * Retorna la lista de Sucursales
     */
	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
}
