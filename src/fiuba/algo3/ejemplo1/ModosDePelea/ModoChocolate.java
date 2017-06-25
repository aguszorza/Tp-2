package fiuba.algo3.ejemplo1.ModosDePelea;

import fiuba.algo3.ejemplo1.Excepciones.PersonajeInutilizado;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class ModoChocolate extends Modo{

	private Modo modoAnterior;
	
	public ModoChocolate(Modo modoAnterior,int turnos){
		super(new Ataque(0,0), 0, 0, (FabricaDeModos fabrica) -> 
		 {return fabrica.transformacionInvalida();});
		this.modoAnterior = modoAnterior;
		this.cantidadDeTurnosRestantes = turnos;
		this.guardarDireccion("file:src/fiuba/algo3/Imagenes/chocolate.png");
	}
	
	public int aumentarKi(){
		return 0;
	}
	
	public Modo recuperarModoDePelea(){
  		if(this.cantidadDeTurnosRestantes > 0){
			return this;
  		}
  		return this.modoAnterior;
  	}
	
	public float obtenerDanioDeAtaque(Personaje enemigo){
		throw new PersonajeInutilizado();
	}
}
