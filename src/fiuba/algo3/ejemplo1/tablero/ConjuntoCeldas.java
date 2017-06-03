package fiuba.algo3.ejemplo1.tablero;

import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Personaje;

public class ConjuntoCeldas {

	private Hashtable <Integer,Celda> celdas;
	
	public ConjuntoCeldas(){
		this.celdas = new Hashtable <Integer,Celda> ();
	}
	
	public Celda obtenerCelda(int posicion){
		return this.celdas.get(posicion);
	}
	
	public void agregarCelda(int posicion, Celda celda){
		this.celdas.put(posicion, celda);
	}
	
	public void agregarPersonaje(int posicion, Personaje personaje){
		this.celdas.get(posicion).agregarPersonaje(personaje);
	}
	
	public Personaje removerPersonaje(int posicion){
		return this.celdas.get(posicion).removerPersonaje();
	}
}
