package fiuba.algo3.ejemplo1.tablero;

import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Personaje;

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
	
	private void comprobaPosicion(int filaAct, int colAct){
		if( filaAct > this.tamanio || filaAct < 1){
			//levantar excepcion
		}
		if( colAct > this.tamanio || colAct < 1){
			//levantar excepcion
		}
		if(this.filas.get(filaAct).obtenerCelda(colAct).estaVacia()){
			//levantar excepcion
		}
	}
	
	public void comprobarAdyacencia(){
		
	}
	//unir las dos funciones
	private void comprobarNuevaPosicion(int fila, int columna){
		// como es un tablero cuadrado
		if(!this.filas.containsKey(fila) || this.filas.containsKey(columna)){
			throw new PosicionFueraDelTablero();
		}
		if(!this.filas.get(fila).obtenerCelda(columna).estaVacia()){
			//levantar excepcion
		}
	}

	public Celda obtenerCelda(int fila, int columna){
		return this.filas.get(fila).obtenerCelda(columna);
	}
	
	public void agregarPersonaje(int fila, int columna, Personaje personaje){
		this.filas.get(fila).obtenerCelda(columna).agregarPersonaje(personaje);
	}
	
	public void moverPersonaje(int filaAct, int colAct, int nuevaFila, int nuevaCol){
		comprobaPosicion(filaAct, colAct); // verifica que haya un personaje y que sea parte del tablero
		comprobarNuevaPosicion (nuevaFila, nuevaCol); // verifica que sea parte del tablero y que no haya un personaje
		Personaje personaje = this.filas.get(filaAct).removerPersonaje(colAct);
		this.filas.get(nuevaFila).agregarPersonaje(nuevaCol, personaje);
	}
}
