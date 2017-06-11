package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Personaje.Cell;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Absorber extends HabilidadEspecial{

	public Absorber(Cell cell){
		super(5, cell);
	}
	
	public float lanzarHabilidad(Personaje enemigo){
		float danio = super.lanzarHabilidad(enemigo);
		this.personaje.aumentarVida((int) danio);
		((Cell)this.personaje).aumentarAbsorciones();
		return danio;
	}
}
