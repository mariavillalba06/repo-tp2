package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.ServicioPaseo;

import java.util.ArrayList;

@Component
public class ListaServicioPaseo {
	
	private List<ServicioPaseo> servicioPaseos;
	
	/**
     * Constructor de la clase ListaServicioPaseo
     * Permite inicializar la lista de servicioPaseos con algunos bojetos percargados
     */
	public ListaServicioPaseo() {
		servicioPaseos = new ArrayList<ServicioPaseo>();
		
		/*servicioPaseos.add(new ServicioPaseo(1, "Juan Perez", "Lunes", (byte)9, (byte)12));
		servicioPaseos.add(new ServicioPaseo(2, "Lucas Diaz", "Martes", (byte)16, (byte)18));
		servicioPaseos.add(new ServicioPaseo(3, "Juan Perez", "Miercoles", (byte)9, (byte)12));
		servicioPaseos.add(new ServicioPaseo(4, "María Gomez", "Jueves", (byte)16, (byte)18));
		servicioPaseos.add(new ServicioPaseo(5, "Lucas Diaz", "Viernes", (byte)9, (byte)12));
		servicioPaseos.add(new ServicioPaseo(6, "Roberto Vazquez", "Sábado", (byte)16, (byte)18));*/
	}
	
	/**
     * Retorna la lista de servicioPaseos
     */
	public List<ServicioPaseo> getServicioPaseos() {
		return servicioPaseos;
	}
	
	public void setServicioPaseos(List<ServicioPaseo> servicioPaseos) {
		this.servicioPaseos = servicioPaseos;
	}
}