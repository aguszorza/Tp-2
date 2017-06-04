package fiuba.algo3.ejemplo1;

public class Kamehameha extends HabilidadEspecial{

	private float danioAdicional;
	
	public Kamehameha(Goku personaje){
		super(20, personaje);
		this.danioAdicional = 3/2;
	}
	
	public float lanzarHabilidad(Personaje personaje){
		return this.danioAdicional * super.lanzarHabilidad(personaje);
	}
}

