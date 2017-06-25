package fiuba.algo3.ejemplo1.ModosDePelea;

import java.util.Iterator;
import java.util.function.Function;

import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class PiccoloProtector extends Modo {
	
	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.transformacionInvalida();};
	
	public PiccoloProtector(){
		super(new Ataque(60, 6), 4, 0, transformacion);
		this.guardarDireccion("file:src/fiuba/algo3/Imagenes/Piccolo_protector.png");
	}

	public Boolean validarTransformacion(Personaje personaje, int costoKi){
		if(!super.validarTransformacion(personaje, costoKi)){
			return false;
		}
		Equipo aliados = personaje.obtenerAliados();
		Iterator <Personaje> it = aliados.iterator();
		while(it.hasNext()){
			Personaje aliado = it.next();
			if (aliado.getNombre() == "Gohan" && aliado.obtenerPorcentajeDeVida() >= 20){
				return false;
			}
		}
		return true;
	}
}
