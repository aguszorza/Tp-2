package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class ConvierteteEnChocolate extends HabilidadEspecial{

	public ConvierteteEnChocolate(MajinBoo majin){
		super(30, majin);
	}
	
	public float lanzarHabilidad(Personaje enemigo){
		if(super.lanzarHabilidad(enemigo) < 0){
			return -1;
		}
		enemigo.transformarEnChocolate();
		return 0;
	}
}
