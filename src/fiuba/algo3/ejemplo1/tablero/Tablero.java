package fiuba.algo3.ejemplo1.tablero;

import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Excepciones.AtaqueFueraDeRango;
import fiuba.algo3.ejemplo1.Excepciones.CeldaOcupada;
import fiuba.algo3.ejemplo1.Excepciones.MovimientoInvalido;
import fiuba.algo3.ejemplo1.Excepciones.PosicionFueraDelTablero;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Tablero {
	
	private Hashtable <Integer,ConjuntoCeldas> filas;
	private int tamanio;
	
	/*public Tablero(int tamanio){
		this.columnas = new Hashtable <Integer, ConjuntoCeldas>();
		this.filas = new Hashtable <Integer, ConjuntoCeldas>();
		crearColumnas(this.columnas, tamanio);
		for (int i = 1; i <= tamanio; i ++){
			ConjuntoCeldas fila = new ConjuntoCeldas();
			for (int j = 1; j <= tamanio; j ++){
				Celda celda = new Celda(fila, this.columnas.get(j));
				fila.agregarCelda(celda, i);
				this.columnas.get(j).agregarCelda(celda, j);
			}
			this.filas.put(i, fila);
		}
	}*/
	
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
	
	private void comprobarAdyacencia(Celda celdaInicial, Celda celdaFinal){
		if (!celdaInicial.esAdyacente(celdaFinal)){
			throw new MovimientoInvalido();
		}
	}
	
	private void comprobarNuevaPosicion(int fila, int columna){
		// como es un tablero cuadrado, verifico que ambos numeros sean clave del tablero 
		if(!this.filas.containsKey(fila) || !this.filas.containsKey(columna)){
			throw new PosicionFueraDelTablero("Posicion fuera del tablero");
		}
		if(!this.filas.get(fila).obtenerCelda(columna).estaVacia()){
			throw new CeldaOcupada("La celda está ocupada");
		}
	}
	
	public void verificarAtaque(int rango, Celda celdaAtacante, Celda celdaAtacado){
		if (Math.abs(celdaAtacante.obtenerFila() - celdaAtacado.obtenerFila()) > rango){
			throw new AtaqueFueraDeRango();
		}
		if (Math.abs(celdaAtacante.obtenerColumna() - celdaAtacado.obtenerColumna()) > rango){
			throw new AtaqueFueraDeRango();
		}
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
	
	public void moverPersonaje(Personaje personaje, Celda celdaAct, Celda celdaFin){
		int filaFinal = celdaFin.obtenerFila();
		int colFinal = celdaFin.obtenerColumna();
		comprobarNuevaPosicion (filaFinal, colFinal); // verifica que sea parte del tablero y que no haya un personaje
		//Celda celdaFin = this.obtenerCelda(filaFinal, colFinal);
		this.comprobarAdyacencia(celdaAct, celdaFin);
		celdaAct.removerPersonaje();
		this.obtenerCelda(filaFinal, colFinal).agregarPersonaje(personaje);
	}
}
