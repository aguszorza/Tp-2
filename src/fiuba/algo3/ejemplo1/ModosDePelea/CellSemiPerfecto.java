package fiuba.algo3.ejemplo1.ModosDePelea;

import java.util.function.Function;

import fiuba.algo3.ejemplo1.Personaje.Cell;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class CellSemiPerfecto extends Modo{

	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.cellPerfecto();};
	
	int costoAbsorciones;

	public CellSemiPerfecto(){
		super(new Ataque(40, 4), 3, 0, transformacion);
		this.costoAbsorciones = 4;
		this.guardarDireccion("file:src/fiuba/algo3/Imagenes/cellSemi.png");
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