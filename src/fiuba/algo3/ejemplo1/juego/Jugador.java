package fiuba.algo3.ejemplo1.juego;

import java.util.Enumeration;
import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Excepciones.AtaqueAliadoInvalido;
import fiuba.algo3.ejemplo1.Excepciones.PersonajeInexistente;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;

public class Jugador {

	//se me ocurrio que ahi quede guardado la celda en la que se encuentra el personaje
	private Hashtable <Personaje, Celda> personajes;
	private Hashtable <Personaje, Celda> enemigos;
	private Tablero tablero;
	private ControladorJugador controlador;
	
	public Jugador(Hashtable <Personaje, Celda> personajes,  Hashtable <Personaje, Celda> enemigos, Tablero tablero){
		this.personajes = personajes;
		this.enemigos = enemigos;
		this.tablero = tablero;
	}
	
	public Enumeration<Personaje> obtenerPersonajesAliados(){
		return this.personajes.keys();
	}
	
	public Enumeration<Personaje> obtenerPersonajesEnemigos(){
		return this.enemigos.keys();
	}
	
	public Celda obtenerCelda(Personaje personaje){
		return this.personajes.get(personaje);
	}
	
	public Boolean existePersonaje(Personaje personaje){
		return this.personajes.containsKey(personaje);
	}
	
	public void verificarAtaque(Personaje atacante, Personaje atacado){
		if(!existePersonaje(atacante)){
			throw new PersonajeInexistente();
		}
		if(existePersonaje(atacado)){
			throw new AtaqueAliadoInvalido();
		}
		this.tablero.verificarAtaque(atacante.obtenerDistanciaDeAtaque(), obtenerCelda(atacante), obtenerCelda(atacado)); 
	}
	//ver de unir las dos. Ya sea usando una funcion o bien uniendo ataque con habilidad
	
	public void aumentarKi(){
		Enumeration<Personaje> personajes = this.obtenerPersonajesAliados();
		while(personajes.hasMoreElements())
			personajes.nextElement().aumentarKi();
	}
	
	public void mover(Personaje personaje, Celda celdaFinal){
		if(!this.existePersonaje(personaje)){
			throw new PersonajeInexistente();
		}
		Celda celdaAct = this.obtenerCelda(personaje);
		this.tablero.moverPersonaje(personaje, celdaAct, celdaFinal);
		this.personajes.put(personaje, celdaFinal);
	}
	
	public void atacar(Personaje personaje, Personaje enemigo){
		if (enemigo == null)
			//excepcion
		this.verificarAtaque(personaje, enemigo);
		//Personaje enemigo = celdaEnemigo.obtenerPersonaje();
		Celda celdaPersonaje = this.personajes.get(personaje);
		Celda celdaEnemigo = this.enemigos.get(enemigo);
		this.tablero.verificarAtaque(personaje.obtenerDistanciaDeAtaque(), celdaPersonaje, celdaEnemigo);
		personaje.atacar(enemigo);
	}
	
	public void lanzarHablidadEspecial(Personaje atacante, Personaje atacado){
		if (atacado == null)
		verificarAtaque(atacante,atacado);
		Celda celdaPersonaje = this.personajes.get(atacante);
		Celda celdaEnemigo = this.enemigos.get(atacado);
		this.tablero.verificarAtaque(atacante.obtenerDistanciaDeAtaque(), celdaPersonaje, celdaEnemigo);
		atacante.lanzarHabilidadEspecial(atacado);
	}
	
	
	public Boolean sigueVivo(){
		return personajes.size() != 0;
	}
	
	//delegar a controlador?

	
	
	private Personaje seleccionarPersonajeAliado(){
		return this.controlador.seleccionarPersonajeAliado();
	}
	
	private Personaje seleccionarPersonajeEnemigo(){
		return this.controlador.seleccionarPersonajeEnemigo();
	}
	
	private void accionar(Personaje personaje, Accion accion){
		accion.realizar(personaje);
	}
	
	private Accion seleccionarAccion(){
		return this.controlador.seleccionarAccion();
	}
	
	public Tablero obtenerTablero(){
		return this.tablero;
	}
	
	public void jugar(){
		int acciones = 0;
		while(acciones < 2){
			Personaje personajeSeleccionado = this.seleccionarPersonajeAliado();
			Accion accion = this.seleccionarAccion();
			this.accionar(personajeSeleccionado, accion);
			acciones++;
		}
	}
}