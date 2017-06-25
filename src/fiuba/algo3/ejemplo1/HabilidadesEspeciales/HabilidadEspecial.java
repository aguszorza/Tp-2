package fiuba.algo3.ejemplo1.HabilidadesEspeciales;

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
			return -1;
		}
		this.personaje.reducirKi(this.costoKi);
		return this.personaje.obtenerDanioDeAtaque(enemigo);
	}
}
