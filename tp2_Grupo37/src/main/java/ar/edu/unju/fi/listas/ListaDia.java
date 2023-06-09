package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaDia {
	private List<String> dias;
	
	/**
	 * Constructor por defecto donde inicializa la lista con los días de la semana.
	 */
	public ListaDia() {
		dias = new ArrayList<String>();
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Miercoles");
		dias.add("Jueves");
		dias.add("Viernes");
		dias.add("Sabado");
	}
	
	/**
	 * Obtiene la lista de días.
	 *
	 * @return la lista de días
	 */
	public List<String> getDias(){
		return dias;
	}
	
	public void setDias(List<String> dias) {
		this.dias = dias;
	}
}
