package ar.edu.unju.fi.listas;

import java.util.List;
import ar.edu.unju.fi.model.Sucursal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales=new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("tienda de mascotas","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas2","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas3","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas4","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
		sucursales.add(new Sucursal("tienda de mascotas5","Gorriti 38","Jujuy", LocalDate.of(2020, 10, 10),"tiendamascotas@gmail.com","3884788093"));
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
}
