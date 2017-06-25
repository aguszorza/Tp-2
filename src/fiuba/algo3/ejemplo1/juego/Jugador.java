package fiuba.algo3.ejemplo1.juego;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.function.Function;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;

public class Jugador {

	//se me ocurrio que ahi quede guardado la celda en la que se encuentra el personaje
	private Hashtable <Personaje, Celda> personajes;
	private Hashtable <Personaje, Celda> enemigos;
	private Tablero tablero;
	private String nombre;
	private String imagenGanador;
	private int cantidadEsferas;
	
	public Jugador(Hashtable <Personaje, Celda> personajes,  Hashtable <Personaje, Celda> enemigos, Tablero tablero, String nombre){
		this.personajes = personajes;
		this.enemigos = enemigos;
		this.tablero = tablero;
		this.nombre = nombre;
		this.cantidadEsferas = 0;
	}
	
	public void guardarImagen(String nombre){
		this.imagenGanador = nombre;
	}
	
	public String obtenerImagen(){
		return this.imagenGanador;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public Enumeration<Personaje> obtenerPersonajesAliados(){
		return this.personajes.keys();
	}
	
	public Enumeration<Personaje> obtenerPersonajesEnemigos(){
		return this.enemigos.keys();
	}
	
	public Celda obtenerCelda( Hashtable <Personaje, Celda> celdas, Personaje personaje){
		return celdas.get(personaje);
	}
	
	public Boolean existePersonaje(Personaje personaje){
		return this.personajes.containsKey(personaje);
	}
	
	public Boolean verificarAtaque(Personaje atacante, Personaje atacado){
		if(!existePersonaje(atacante)){
			return false;
		}
		if(existePersonaje(atacado)){
			return false;
		}
		return this.tablero.verificarAtaque(atacante.obtenerDistanciaDeAtaque(), obtenerCelda(this.personajes, atacante), obtenerCelda(this.enemigos, atacado)); 
	}
	
	public void aumentarKi(){
		Enumeration<Personaje> personajes = this.obtenerPersonajesAliados();
		while(personajes.hasMoreElements())
			personajes.nextElement().aumentarKi();
	}
	
	public Boolean mover(Personaje personaje, Celda celdaFinal){
		int fila = celdaFinal.obtenerFila();
		int columna = celdaFinal.obtenerColumna();
		if(!this.existePersonaje(personaje)){
			return false;
		}
		if(!this.tablero.existePosicion(fila, columna)){
			return false;
		}
		Celda celdaFin = this.tablero.obtenerCelda(fila, columna);
		Celda celdaAct = this.obtenerCelda(this.personajes, personaje);
		if(!this.tablero.moverPersonaje(personaje, celdaAct, celdaFin)){
			return false;
		}
		this.personajes.put(personaje, celdaFin);
		this.cantidadEsferas = personaje.cantidadEsferas();
		return true;
	}
	
	private Boolean ataque(Personaje personaje, Personaje enemigo, Function <Personaje, Boolean> funcion){
		if(!this.verificarAtaque(personaje, enemigo)){
			return false;
		}
		Celda celdaEnemigo = this.enemigos.get(enemigo);
		if(!funcion.apply(personaje)){
			return false;
		}
		if(enemigo.obtenerVida() <= 0){
			celdaEnemigo.removerPersonaje();
			this.enemigos.remove(enemigo);
		}
		return true;
	}
	
	public Boolean atacar(Personaje personaje, Personaje enemigo){
		Function <Personaje, Boolean> funcion;
		funcion = (Personaje persona) -> persona.atacar(enemigo);
		return ataque(personaje, enemigo, funcion);
	}
	
	public Boolean lanzarHabilidadEspecial(Personaje atacante, Personaje atacado){
		Function <Personaje, Boolean> funcion;
		funcion = (Personaje persona) -> persona.lanzarHabilidadEspecial(atacado);
		return ataque(atacante, atacado, funcion);
	}
	
	public Boolean transformar(Personaje personaje){
		return personaje.transformar();
	}
	
	public void pasarTurno(){
		Enumeration <Personaje> personajes = this.obtenerPersonajesAliados();
		while(personajes.hasMoreElements()){
			personajes.nextElement().pasarTurno();
		}
	}
	
	public Boolean gano(){
		if(this.enemigos.size() == 0 || this.cantidadEsferas == 7){
			return true;
		}
		return false;
	}
	
	public Tablero obtenerTablero(){
		return this.tablero;
	}
}