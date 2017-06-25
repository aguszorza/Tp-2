package fiuba.algo3.ejemplo1.tablero;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Celda {
	
	private int fila;
	private int columna;
	private Personaje personaje;
	private Consumible consumible;
	
	public Celda(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		this.personaje = null;
		this.consumible = null;
	}
	
	public String obtenerImagen(){
		if(!this.estaVacia())
			return this.personaje.obtenerImagen();
		if(this.hayConsumible())
			return this.consumible.obtenerImagen();
		return "file:";
	}
	
	public Boolean hayConsumible(){
		return this.consumible != null;
	}
	
	public int obtenerFila(){
		return this.fila;
	}
	
	public int obtenerColumna(){
		return this.columna;
	}
	
	public void agregarConsumible(Consumible consumible){
		this.consumible = consumible;
	}
	
	public void agregarPersonaje(Personaje personaje){
		this.personaje = personaje;
		if(this.hayConsumible()){
			personaje.consumir(this.consumible);
			this.consumible = null;
		}
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
	
	public Consumible obtenerConsumible(){
		return this.consumible;
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
