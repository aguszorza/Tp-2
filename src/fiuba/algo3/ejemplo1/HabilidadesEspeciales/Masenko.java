package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Masenko extends HabilidadEspecial{
	
	private float danioAdicional;
	
	public Masenko (Gohan gohan){
		super(10, gohan);
		this.danioAdicional = (float)1.25;
	}

	public float lanzarHabilidad(Personaje enemigo){
		return this.danioAdicional * super.lanzarHabilidad(enemigo);
	}
}
