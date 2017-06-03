package fiuba.algo3.ejemplo1.tablero;

import fiuba.algo3.ejemplo1.Personaje;

public class Celda {
	
	private int fila;
	private int columna;
	private Personaje personaje;
	
	public Celda(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		this.personaje = null; // se podria llegar a cambiar a que tenga un personaje vacio
	}
	
	public int obtenerFila(){
		return this.fila;
	}
	
	public int obtenerColumna(){
		return this.columna;
	}
	
	public void agregarPersonaje(Personaje personaje){
		this.personaje = personaje;
	}
	
	public Personaje removerPersonaje(){
		Personaje personaje= this.personaje;
		this.personaje = null;
		return personaje;
	}
	
	public Boolean estaVacia(){
		return this.personaje == null;
	}
	
	public Personaje obtenerPersonaje(){
		return this.personaje;
	}
	
	public Boolean esAdyacente(Celda celda){
		if(Math.abs(celda.obtenerFila() - this.fila) > 1){
			return false;
		}
		if (Math.abs(celda.obtenerColumna() - this.columna) > 1){
			return false;
		}
		return true;
	}

}
