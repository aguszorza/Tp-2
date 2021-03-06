package fiuba.algo3.ejemplo1.juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import fiuba.algo3.ejemplo1.Excepciones.PersonajeNoMovilizable;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;

public class Turno {

	private Personaje personajeEnMovimiento;
	private Boolean ataque;
	private int movimientos;
	private Queue<Jugador> cola;
	
	
	public Turno(Jugador jugador1, Jugador jugador2){
		this.cola = new LinkedList<Jugador> ();
		guardarAleatoriamente(jugador1, jugador2);
		//this.cola.add(jugador1);
		//this.cola.add(jugador2);
		inicializarTurno();
	}
	
	private void guardarAleatoriamente(Jugador jugador1, Jugador jugador2){
		ArrayList<Jugador> lista= new ArrayList<Jugador> ();
		lista.add(jugador1);
		lista.add(jugador2);
		int posicion = (new Random()).nextInt(lista.size());
		this.cola.add(lista.remove(posicion));
		this.cola.add(lista.get(0));
	}
	
	public Jugador obtenerJugador(){
		return this.cola.element();
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
			throw new PersonajeNoMovilizable();
		}
		if (this.personajeEnMovimiento == null){
			this.personajeEnMovimiento = personaje;
		}
		if (this.movimientos >= this.personajeEnMovimiento.obtenerVelocidad()){
			throw new PersonajeNoMovilizable();
		}
		this.cola.element().mover(personaje, celdaFinal);
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
