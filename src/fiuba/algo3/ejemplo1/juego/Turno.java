package fiuba.algo3.ejemplo1.juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
import fiuba.algo3.ejemplo1.Excepciones.AtaqueNoValido;
import fiuba.algo3.ejemplo1.Excepciones.PersonajeInexistente;
import fiuba.algo3.ejemplo1.Excepciones.PersonajeNoMovilizable;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;

public class Turno {

	private Personaje personajeEnMovimiento;
	private Boolean ataque;
	private int movimientos;
	private Queue<Jugador> cola;
	private ArrayList <Consumible> consumibles;
	
	
	public Turno(Jugador jugador1, Jugador jugador2){
		this.cola = new LinkedList<Jugador> ();
		guardarAleatoriamente(jugador1, jugador2);
		//this.cola.add(jugador1);
		//this.cola.add(jugador2);
		SemillaErmitanio semilla = new SemillaErmitanio();
		EsferaDragon esfera = new EsferaDragon();
		NubeVoladora nube = new NubeVoladora();
		this.consumibles = new ArrayList <Consumible>();
		this.consumibles.add(semilla);
		this.consumibles.add(esfera);
		this.consumibles.add(nube);
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
	
	private void agregarConsumible(){
		int posicionAleatoria = (new Random()).nextInt(consumibles.size());
		Consumible consumible = consumibles.get(posicionAleatoria);
		this.cola.element().obtenerTablero().agregarConsumibleAleatoriamente(consumible);
	}
	
	public Boolean existePersonaje(Personaje personaje){
		return this.cola.element().existePersonaje(personaje);
	}
	
	public Jugador obtenerJugador(){
		return this.cola.element();
	}
	
	private void inicializarTurno(){
		this.ataque = false;
		this.movimientos = 0;
		this.personajeEnMovimiento = null;
		this.cola.element().aumentarKi();
		this.agregarConsumible();
	}
	
	public void pasarTurno(){
		this.cola.element().pasarTurno();
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
		if (!existePersonaje(personaje)){
			throw new PersonajeInexistente("El personaje seleccionado no es del jugador");
		}
		if(this.personajeEnMovimiento != null && personaje != this.personajeEnMovimiento){
			throw new PersonajeNoMovilizable("El personaje seleccionado no es movilizable para este turno");
		}
		if (this.personajeEnMovimiento == null){
			this.personajeEnMovimiento = personaje;
		}
		if (this.movimientos >= this.personajeEnMovimiento.obtenerVelocidad()){
			throw new PersonajeNoMovilizable("El personaje no puede moverse mas posiciones");
		}
		this.cola.element().mover(personaje, celdaFinal);
		this.movimientos ++;
		terminoTurno();
	}
	
	public void transformar(Personaje personaje){
		this.cola.element().transformar(personaje);
	}
	
	public void atacar(Personaje personaje, Personaje enemigo){
		if(this.ataque){
			throw new AtaqueNoValido("Ya has realizado un ataque en este turno");
		}
		this.cola.element().atacar(personaje, enemigo);
		this.ataque = true;
		terminoTurno();
	}
	
	public void lanzarHablidad(Personaje personaje, Personaje enemigo){
		if(this.ataque){
			throw new AtaqueNoValido("Ya has realizado un ataque en este turno");
		}
		this.cola.element().lanzarHablidadEspecial(personaje, enemigo);
		this.ataque = true;
		terminoTurno();
	}
	
	public String obtenerImagen(){
		return this.cola.element().obtenerImagen();
	}
}
