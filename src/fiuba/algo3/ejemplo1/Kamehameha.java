package fiuba.algo3.ejemplo1;

import fiuba.algo3.ejemplo1.Personaje.Goku;

public class Kamehameha extends HabilidadEspecial{

	private float danioAdicional;
	
	public Kamehameha(Goku personaje){
		super(20, personaje);
		this.danioAdicional = (float)1.5;
	}
	
	public float lanzarHabilidad(){
		return this.danioAdicional * super.lanzarHabilidad();
	}
}

