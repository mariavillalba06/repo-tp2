package ar.edu.unju.fi.listas;

import java.util.List;

import ar.edu.unju.fi.model.ServicioCorte;

import java.util.ArrayList;


public class ListaServicioCorte {
	private List<ServicioCorte> servicioCortes;
	
	/**
     * Constructor de la clase ListaServicioCorte
     * Permite inicializar la lista de servicioCortes con algunos bojetos percargados
     */
	public ListaServicioCorte() {
		servicioCortes = new ArrayList<ServicioCorte>();
		
		servicioCortes.add(new ServicioCorte(1,(byte)1, (byte)4,"Tijera",1000));
		servicioCortes.add(new ServicioCorte(2,(byte)5, (byte)9,"Máquina",2000));
		servicioCortes.add(new ServicioCorte(3,(byte)10, (byte)14,"Tijera",3000));
		servicioCortes.add(new ServicioCorte(4,(byte)15, (byte)19,"Tijera",4000));
		servicioCortes.add(new ServicioCorte(5,(byte)20, (byte)24,"Máquina",5000));
	}
	
	/**
     * Retorna la lista de servicioCortes
     */
	public List<ServicioCorte> getServicioCortes() {
		return servicioCortes;
	}
	
	public void setServicioCortes(List<ServicioCorte> servicioCortes) {
		this.servicioCortes = servicioCortes;
	}
}
