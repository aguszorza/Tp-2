package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Cell;

public class Absorber extends HabilidadEspecial{

	public Absorber(Cell cell){
		super(5, cell);
	}
	
	public float lanzarHabilidad(){
		float danio = super.lanzarHabilidad();
		this.personaje.aumentarVida((int) danio);
		((Cell)this.personaje).aumentarAbsorciones();
		return danio;
	}
}
