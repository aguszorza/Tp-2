package fiuba.algo3.ejemplo1.ModosDePelea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

import fiuba.algo3.ejemplo1.Excepciones.RequisitosDeTransformacionInsuficientes;
import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class GohanSSJ2 extends Modo {
	
	static Function <FabricaDeModos, Modo> transformacion = (FabricaDeModos fabrica) -> 
	{return fabrica.transformacionInvalida();};

	public GohanSSJ2(){
		super(new Ataque(100, 4), 3, 30, transformacion);
		this.guardarDireccion("file:src/fiuba/algo3/Imagenes/Gohan_SSJ2.png");
	}
	
	public void validarTransformacion(Personaje personaje, int costoKi){
		super.validarTransformacion(personaje, costoKi);
		Equipo aliados = personaje.obtenerAliados();
		Iterator <Personaje> it = aliados.iterator();
		while(it.hasNext()){
			Personaje aliado = it.next();
			if (aliado.getNombre() == "Gohan"){
				continue;
			}
			if (aliado.obtenerPorcentajeDeVida() >= 30){
				throw new RequisitosDeTransformacionInsuficientes();
			}
		}
	}
}
