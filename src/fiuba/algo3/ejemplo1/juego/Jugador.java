package fiuba.algo3.ejemplo1;

import java.util.Enumeration;
import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;

public class Jugador {

	//se me ocurrio que ahi quede guardado la celda en la que se encuentra el personaje
	private Hashtable <Personaje, Celda> personajes;
	private Tablero tablero;
	
	public Jugador(Hashtable <Personaje, Celda> personajes){
		this.personajes = personajes;
	}
	
	public Enumeration<Personaje> obtenerPersonajes(){
		return this.personajes.keys();
	}
	
	public Boolean existePersonaje(Personaje personaje){
		return this.personajes.containsKey(personaje);
	}
	
	//ver de unir las dos. Ya sea usando una funcion o bien uniendo ataque con habilidad
	public void atacar(Celda atacante, Celda atacado){
		if(!existePersonaje(atacante.obtenerPersonaje())){ // no es un personaje del jugador
			//levantar excepcion
		}
		if(existePersonaje(atacado.obtenerPersonaje())){ // es un personaje aliado
			//levantar excepcion
		}
		this.tablero.verificarAtaque(atacante, atacado); //verificar que este dentro del rango
		atacante.obtenerPersonaje().atacar(atacado.obtenerPersonaje());
	}
	
	public void lanzarHablidadEspecial(Celda atacante, Celda atacado){
		if(!existePersonaje(atacante.obtenerPersonaje())){ // no es un personaje del jugador
			//levantar excepcion
		}
		if(existePersonaje(atacado.obtenerPersonaje())){ // es un personaje aliado
			//levantar excepcion
		}
		this.tablero.verificarAtaque(atacante, atacado); 
		atacante.obtenerPersonaje().lanzarHabilidadEspecial(atacado.obtenerPersonaje());
	}
	
	public void mover(Personaje personaje, int filaNueva, int colNueva){
		int filaActual = this.personajes.get(personaje).obtenerFila();
		int colActual = this.personajes.get(personaje).obtenerColumna();
		this.tablero.moverPersonaje(filaActual, colActual, filaNueva, colNueva); 
	}
}
