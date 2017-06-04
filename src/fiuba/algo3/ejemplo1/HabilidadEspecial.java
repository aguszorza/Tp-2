package fiuba.algo3.ejemplo1;

public class HabilidadEspecial {

	private int costoKi;
	protected Personaje personaje;
	
	public HabilidadEspecial(int costoKi, Personaje personaje){
		this.personaje = personaje;
		this.costoKi = costoKi;
	}
	
	public float lanzarHabilidad(Personaje personaje){
		if (personaje.ki() < this.costoKi){
			//Excepcion
		}
		personaje.reducirKi(this.costoKi);
		return this.personaje.obtenerPoderDePelea();
	}
}
