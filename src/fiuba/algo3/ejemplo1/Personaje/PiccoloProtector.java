package fiuba.algo3.ejemplo1.Personaje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

import fiuba.algo3.ejemplo1.Ataque;

public class PiccoloProtector extends Modo {
	
	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.transformacionInvalida();};
	
	public PiccoloProtector(){
		super(new Ataque(60, 6), 4, 0, transformacion);
	}

	public void validarTransformacion(Personaje personaje, int costoKi){
		super.validarTransformacion(personaje, costoKi);
		ArrayList <Personaje> aliados = personaje.obtenerAliados();
		Iterator <Personaje> it = aliados.iterator();
		while(it.hasNext()){
			Personaje aliado = it.next();
			if (aliado.getNombre() == "Gohan" && aliado.obtenerPorcentajeDeVida() >= 30){
				throw new RequisitosDeTransformacionInsuficientes();
			}
		}
	}
}
