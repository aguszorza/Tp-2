package fiuba.algo3.ejemplo1.tablero;

import java.util.Hashtable;
import java.util.Random;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Tablero {
	
	private Hashtable <Integer,ConjuntoCeldas> filas;
	private int tamanio;
	
	public Tablero(int tamanio){
		this.tamanio = tamanio;
		this.filas = new Hashtable <Integer, ConjuntoCeldas>();
		for (int i = 1; i <= tamanio; i ++){
			ConjuntoCeldas fila = new ConjuntoCeldas();
			for (int j = 1; j <= tamanio; j ++){
				Celda celda = new Celda (i, j);
				fila.agregarCelda(j, celda);
			}
			this.filas.put(i, fila);
		}
	}
	
	public Boolean existePosicion(int fila, int columna){
		return this.filas.containsKey(fila) && this.filas.containsKey(columna);
	}
	
	private Boolean comprobarAdyacencia(Celda celdaInicial, Celda celdaFinal){
		return celdaInicial.esAdyacente(celdaFinal);
			
	}
	
	private Boolean comprobarNuevaPosicion(int fila, int columna){
		// como es un tablero cuadrado, verifico que ambos numeros sean clave del tablero 
		if(!this.filas.containsKey(fila) || !this.filas.containsKey(columna)){
			return false;
		}
		if(!this.filas.get(fila).obtenerCelda(columna).estaVacia()){
			return false;
		}
		return true;
	}
	
	public Boolean verificarAtaque(int rango, Celda celdaAtacante, Celda celdaAtacado){
		if (Math.abs(celdaAtacante.obtenerFila() - celdaAtacado.obtenerFila()) > rango){
			return false;
		}
		if (Math.abs(celdaAtacante.obtenerColumna() - celdaAtacado.obtenerColumna()) > rango){
			return false;
		}
		return true;
	}

	public Celda obtenerCelda(int fila, int columna){
		return this.filas.get(fila).obtenerCelda(columna);
	}
	
	public void agregarPersonaje(Celda celda, Personaje personaje){
		int fila = celda.obtenerFila();
		int columna = celda.obtenerColumna(); 
		this.filas.get(fila).obtenerCelda(columna).agregarPersonaje(personaje);
	}
	
	public void agregarConsumible(Celda celda, Consumible consumible){
		int fila = celda.obtenerFila();
		int columna = celda.obtenerColumna(); 
		this.filas.get(fila).obtenerCelda(columna).agregarConsumible(consumible);
	}
	
	public void agregarConsumibleAleatoriamente(Consumible consumible){
		for(int i = 0; i < 20; i++){
			int fila = (new Random()).nextInt(tamanio) + 1;
			int columna = (new Random()).nextInt(tamanio) + 1;
			Celda celda = this.obtenerCelda(fila, columna);
			if(celda.estaVacia() && !celda.hayConsumible()){
				this.agregarConsumible(celda, consumible);
				break;
			}
		}
	}
	
	public Boolean moverPersonaje(Personaje personaje, Celda celdaAct, Celda celdaFin){
		int filaFinal = celdaFin.obtenerFila();
		int colFinal = celdaFin.obtenerColumna();
		if(!comprobarNuevaPosicion (filaFinal, colFinal)){// verifica que sea parte del tablero y que no haya un personaje
			return false;
		}
		if(!this.comprobarAdyacencia(celdaAct, celdaFin)){
			return false;
		}
		celdaAct.removerPersonaje();
		this.obtenerCelda(filaFinal, colFinal).agregarPersonaje(personaje);
		return true;
	}
}
