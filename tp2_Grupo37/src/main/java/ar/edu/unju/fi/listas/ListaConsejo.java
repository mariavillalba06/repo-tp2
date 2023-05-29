package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Consejo;
@Component
public class ListaConsejo {
	private List<Consejo> consejos;
	
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
		
		consejos.add(new Consejo(1,
				"Antes que nada, visita al veterinario",
				"Tener una mascota de manera responsable comienza con visitas regulares al veterinario. Dada su esperanza de vida, tu perrito o mínimo deberían hacerse un chequeo una o dos veces al año. Pero el establecer y mantener la buena salud de tu mascota significa mantenerse al día con las visitas al veterinario a medida que envejecen.",
				"antes de salir camino hacia el veterinario, sácalos de paseo. Esto se hace para que no asocien entrar al carro con ir al veterinario."));
		
		consejos.add(new Consejo(2,
				"Proporciona un entorno de vida seguro, cómodo y enriquecedor",
				"Así como los seres humanos necesitamos un hogar en el que podamos sentirnos cómodos y seguros, también lo necesitan nuestras mascotas.",
				"las mascotas que son demasiado jóvenes o ya tienen varios años encima pierden su capacidad para regular la temperatura corporal eficientemente. Es importante ofrecerles una manta y una cama que les proporcione confort y calor. Sobre todo en las horas de la noche."));
		
		consejos.add(new Consejo(3,
				"Atiende sus necesidades nutricionales",
				"Todos los organismos vivos necesitan alimento para sobrevivir. Lamentablemente, muchas mascotas sufren de obesidad y otros problemas metabólicos por mala alimentación. Lo que más adelante se puede derivar en otros problemas de salud.",
				"selecciona una fórmula de alimento para mascotas que sea apropiada para su edad, sus condiciones de salud y el nivel de actividad de tu mascota."));
		
		consejos.add(new Consejo(4,
				"Esteriliza a tu mascota",
				"Esterilizar a tu mascota evita una serie de problemas de salud (ASPCA, s.f.), incluídos embarazos complicados y ayuda a la reducción de animales sin hogar. Debido a que la esterilización o castración es una cirugía que requiere anestesia general, es probable que tu mascota pase la noche en el consultorio del veterinario. Esto, durante al menos una noche para observación y recuperación.",
				"trata de practicar este procedimiento en una edad temprana para tu peludito. De esta manera su recuperación y su proceso de cicatrización será rápida."));
		
		consejos.add(new Consejo(5,
				"Aplica las vacunas a tiempo",
				"Poco después de llegar a tu hogar, la primera salida debe ser al veterinario. Acto seguido se establecerá un calendario de vacunación para tu pequeño cachorro o gatito. Esto, con el objetivo de protegerlos de enfermedades como la rabia o el moquillo en el caso de los perros. Los gatos también se benefician de las vacunas que previenen el virus del herpes felino, la leucemia felina y la rabia.",
				"si adoptaste una mascota en edad avanzada, asegúrate de que también esté protegido. Las vacunas necesitan renovación y no son solo para mascotas jóvenes."));
	}
	
	public List<Consejo> getConsejos() {
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
}