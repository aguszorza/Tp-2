package fiuba.algo3.ejemplo1.ModosDePelea;

import fiuba.algo3.ejemplo1.Excepciones.PersonajeInutilizado;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class ModoChocolate extends Modo{

	private Modo modoAnterior;
	//private int turnos;
	
	public ModoChocolate(Modo modoAnterior,int turnos){
		super(new Ataque(0,0), 0, 0, (FabricaDeModos fabrica) -> 
		 {return fabrica.transformacionInvalida();});
		this.modoAnterior = modoAnterior;
		//this.turnos = turnos;
		this.cantidadDeTurnosRestantes = turnos;
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

	/*public void pasarTurno(){
		this.cantidadDeTurnosRestantes --;
		//this.turnos --;
	}*/
	
	/*public float obtenerPoderDePelea(){
		throw new PersonajeInutilizado();
	}*/
	
	public int obtenerDistanciaDeAtaque(){
		throw new PersonajeInutilizado();
	}
	
	public int obtenerVelocidad(){
		throw new PersonajeInutilizado();
	}
	
	public float obtenerDanioDeAtaque(Personaje enemigo){
		throw new PersonajeInutilizado();
	}
}
