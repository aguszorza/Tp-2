package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.Personaje.Piccolo;

public class Makankosappo extends HabilidadEspecial{
	
	private float danioAdicional;

	public Makankosappo(Piccolo piccolo){
		super(10, piccolo);
		this.danioAdicional = (float) 1.25;
	}
	
	public float lanzarHabilidad(Personaje enemigo){
		return this.danioAdicional * super.lanzarHabilidad(enemigo);
	}
}
