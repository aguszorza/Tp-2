package fiuba.algo3.ejemplo1.ModosDePelea;

import java.util.function.Function;

import fiuba.algo3.ejemplo1.Excepciones.AbsorcionesInsuficientes;
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
	
	public void validarTransformacion(Personaje personaje, int costoKi){
		super.validarTransformacion(personaje, costoKi);
		if(((Cell)personaje).obtenerAbsorciones() < this.costoAbsorciones){
			throw new AbsorcionesInsuficientes();
		}
		((Cell)personaje).disminuirAbsorciones(this.costoAbsorciones);
	}
}