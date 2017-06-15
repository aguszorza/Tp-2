package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

import fiuba.algo3.ejemplo1.Excepciones.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class HabilidadEspecial{

	private int costoKi;
	protected Personaje personaje;
	
	public HabilidadEspecial(int costoKi, Personaje personaje){
		this.personaje = personaje;
		this.costoKi = costoKi;
	}
	
	public float lanzarHabilidad(Personaje enemigo){
		if (this.personaje.ki() < this.costoKi){
			throw new KiInsuficiente();
		}
		this.personaje.reducirKi(this.costoKi);
		return this.personaje.obtenerDanioDeAtaque(enemigo);
	}
}
