package fiuba.algo3.ejemplo1.juego;

import java.util.LinkedList;
import java.util.Queue;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;

public class Turno {

	private Personaje personajeEnMovimiento;
	private Boolean ataque;
	private int movimientos;
	private Queue<Jugador> cola;
	
	
	public Turno(Jugador jugador1, Jugador jugador2){
		this.cola = new LinkedList<Jugador> ();
		this.cola.add(jugador1);
		this.cola.add(jugador1);
		inicializarTurno();
	}
	
	private void inicializarTurno(){
		this.ataque = false;
		this.movimientos = 0;
		this.personajeEnMovimiento = null;
		this.cola.element().aumentarKi();
	}
	
	public void pasarTurno(){
		this.cola.add(this.cola.remove());
		inicializarTurno();
	}
	
	public void terminoTurno(){
		if(!this.ataque || this.personajeEnMovimiento == null)
			return;
		if(this.movimientos < this.personajeEnMovimiento.obtenerVelocidad())
			return;
		pasarTurno();
	}
	
	public void mover(Personaje personaje, Celda celdaFinal){
		if(this.personajeEnMovimiento != null && personaje != this.personajeEnMovimiento){
			//excepcion
		}
		this.cola.element().mover(personaje, celdaFinal);
		if (this.personajeEnMovimiento == null){
			this.personajeEnMovimiento = personaje;
		}
		this.movimientos ++;
		terminoTurno();
	}
	
	public void atacar(Personaje personaje, Personaje enemigo){
		if(this.ataque){
			//excepcion
		}
		this.cola.element().atacar(personaje, enemigo);
		this.ataque = true;
		terminoTurno();
	}
	
	public void lanzarHablidad(Personaje personaje, Personaje enemigo){
		if(this.ataque){
			//excepcion
		}
		this.cola.element().lanzarHablidadEspecial(personaje, enemigo);
		this.ataque = true;
		terminoTurno();
	}
}
