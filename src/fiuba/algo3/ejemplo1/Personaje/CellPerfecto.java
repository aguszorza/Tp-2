package fiuba.algo3.ejemplo1.Personaje;

import java.util.function.Function;

import fiuba.algo3.ejemplo1.Ataque;

public class CellPerfecto extends Modo{

	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.transformacionInvalida();};
	
	int costoAbsorciones;

	public CellPerfecto(){
		super(new Ataque(80, 4), 4, 0, transformacion);
		this.costoAbsorciones = 8;
	}
	
	public int obtenerCostoAbsorciones(){
		return this.costoAbsorciones;
	}
	
	public void validarTransformacion(Personaje personaje, int costoKi){
		super.validarTransformacion(personaje, costoKi);
		if(((Cell)personaje).obtenerAbsorciones() < this.costoAbsorciones){
			throw new AbsorcionesInsuficientes();
		}
		((Cell)personaje).disminuirAbsorciones(this.costoAbsorciones);
	}
}
