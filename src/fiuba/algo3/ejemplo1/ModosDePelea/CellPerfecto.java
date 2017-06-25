package fiuba.algo3.ejemplo1.ModosDePelea;

import java.util.function.Function;

import fiuba.algo3.ejemplo1.Personaje.Cell;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class CellPerfecto extends Modo{

	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.transformacionInvalida();};
	
	int costoAbsorciones;

	public CellPerfecto(){
		super(new Ataque(80, 4), 4, 0, transformacion);
		this.costoAbsorciones = 8;
		this.guardarDireccion("file:src/fiuba/algo3/Imagenes/Cell_Perfecto.png");
	}
	
	public Boolean validarTransformacion(Personaje personaje, int costoKi){
		if(!super.validarTransformacion(personaje, costoKi)){
			return false;
		}
		if(((Cell)personaje).obtenerAbsorciones() < this.costoAbsorciones){
			return false;
		}
		((Cell)personaje).disminuirAbsorciones(this.costoAbsorciones);
		return true;
	}
}
