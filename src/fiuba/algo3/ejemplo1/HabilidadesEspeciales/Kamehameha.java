package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Kamehameha extends HabilidadEspecial{

	private float danioAdicional;
	
	public Kamehameha(Goku personaje){
		super(20, personaje);
		this.danioAdicional = (float)1.5;
	}
	
	public float lanzarHabilidad(Personaje enemigo){
		return this.danioAdicional * super.lanzarHabilidad(enemigo);
	}
}

