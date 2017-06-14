package fiuba.algo3.ejemplo1.juego;

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
	
	private Celda obtenerCelda(Personaje personaje){
		return this.personajes.get(personaje);
	}
	
	public Boolean existePersonaje(Personaje personaje){
		return this.personajes.containsKey(personaje);
	}
	
	//ver de unir las dos. Ya sea usando una funcion o bien uniendo ataque con habilidad
	public void atacar(Personaje atacante, Personaje atacado){
		if(!existePersonaje(atacante)){
			throw new PersonajeInexistente();
		}
		if(existePersonaje(atacante)){
			throw new AtaqueAliadoInvalido();
		}
		this.tablero.verificarAtaque(atacante.obtenerDistanciaDeAtaque(),obtenerCelda(atacante), obtenerCelda(atacado)); //verificar que este dentro del rango
		atacante.atacar(atacado);
	}
	
	public void lanzarHablidadEspecial(Personaje atacante, Personaje atacado){
		if(!existePersonaje(atacante)){
			throw new PersonajeInexistente();
		}
		if(existePersonaje(atacado)){
			throw new AtaqueAliadoInvalido();
		}
		this.tablero.verificarAtaque(atacante.obtenerDistanciaDeAtaque(), obtenerCelda(atacante), obtenerCelda(atacado)); 
		atacante.lanzarHabilidadEspecial(atacado);
	}
	
	public void mover(Personaje personaje, int filaNueva, int colNueva){
		int filaActual = this.personajes.get(personaje).obtenerFila();
		int colActual = this.personajes.get(personaje).obtenerColumna();
		this.tablero.moverPersonaje(filaActual, colActual, filaNueva, colNueva); 
	}
}
