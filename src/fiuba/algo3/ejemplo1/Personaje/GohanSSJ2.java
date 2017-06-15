package fiuba.algo3.ejemplo1.Personaje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

import fiuba.algo3.ejemplo1.Ataque;

public class GohanSSJ2 extends Modo {
	
	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.transformacionInvalida();};

	public GohanSSJ2(){
		super(new Ataque(100, 4), 3, 30, transformacion);
	}
	
	public void validarTransformacion(Personaje personaje, int costoKi){
		super.validarTransformacion(personaje, costoKi);
		ArrayList <Personaje> aliados = personaje.obtenerAliados();
		Iterator <Personaje> it = aliados.iterator();
		while(it.hasNext()){
			if (it.next().obtenerPorcentajeDeVida() >= 30){
				throw new RequisitosDeTransformacionInsuficientes();
			}
		}
	}
}
