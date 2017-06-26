package fiuba.algo3.ejemplo1.juego;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.function.Function;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
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
		Consumible consumible = consumibles.get(posicionAleatoria).obtenerCopia();
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
	
	public Jugador obtenerGanador(){
		Iterator<Jugador> iter = this.cola.iterator();
		while(iter.hasNext()){
			Jugador jugador = iter.next();
			if(jugador.gano()){
				return jugador;
			}
		}
		return null;
	}
	
	public Boolean mover(Personaje personaje, Celda celdaFinal){
		if(this.personajeEnMovimiento != null && personaje != this.personajeEnMovimiento){
			return false;
		}
		if(personaje.obtenerVelocidad() == 0){
			return false;
		}
		if (this.movimientos >= personaje.obtenerVelocidad()){
			return false;
		}
		if(!this.cola.element().mover(personaje, celdaFinal)){
			return false;
		}
		if (this.personajeEnMovimiento == null){
			this.personajeEnMovimiento = personaje;
		}
		this.movimientos ++;
		terminoTurno();
		return true;
	}
	
	public Boolean transformar(Personaje personaje){
		return this.cola.element().transformar(personaje);
	}
	
	private Boolean ataque(Function <Jugador, Boolean> funcion){
		if(this.ataque){
			return false;
		}
		if(!funcion.apply(this.cola.element())){
			return false;
		}
		this.ataque = true;
		terminoTurno();
		return true;
	}
	
	public Boolean atacar(Personaje personaje, Personaje enemigo){
		Function <Jugador, Boolean> funcion;
		funcion = (Jugador jugador) -> jugador.atacar(personaje, enemigo);
		return ataque(funcion);
	}
	
	public Boolean lanzarHablidad(Personaje personaje, Personaje enemigo){
		Function <Jugador, Boolean> funcion;
		funcion = (Jugador jugador) -> jugador.lanzarHabilidadEspecial(personaje, enemigo);
		return ataque(funcion);
	}
	
	public String obtenerImagen(){
		return this.cola.element().obtenerImagen();
	}
}
