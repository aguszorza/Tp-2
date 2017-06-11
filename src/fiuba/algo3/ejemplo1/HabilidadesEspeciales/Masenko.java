package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Gohan;

public class Masenko extends HabilidadEspecial{
	
	private float danioAdicional;
	
	public Masenko (Gohan gohan){
		super(10, gohan);
		this.danioAdicional = (float)1.25;
	}

	public float lanzarHabilidad(){
		return this.danioAdicional * super.lanzarHabilidad();
	}
}
