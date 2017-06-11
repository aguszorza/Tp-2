package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class RayoMortal extends HabilidadEspecial{
	
	private float danioAdicional;
	
	public RayoMortal(Freezer freezer){
		super(20, freezer);
		this.danioAdicional = (float)1.5;
	}

	public float lanzarHabilidad(Personaje enemigo){
		return this.danioAdicional * super.lanzarHabilidad(enemigo);
	}
}
