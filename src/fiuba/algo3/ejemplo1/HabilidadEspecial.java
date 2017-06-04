package fiuba.algo3.ejemplo1;

import fiuba.algo3.ejemplo1.Personaje.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class HabilidadEspecial {

	private int costoKi;
	protected Personaje personaje;
	
	public HabilidadEspecial(int costoKi, Personaje personaje){
		this.personaje = personaje;
		this.costoKi = costoKi;
	}
	
	public float lanzarHabilidad(){
		if (this.personaje.ki() < this.costoKi){
			throw new KiInsuficiente();
		}
		this.personaje.reducirKi(this.costoKi);
		return this.personaje.obtenerPoderDePelea();
	}
}
