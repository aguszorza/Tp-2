package fiuba.algo3.ejemplo1.juego;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;

public class Mover extends Accion{
	
	public void realizar(Personaje personaje){
		int movimientos = 0;
		while(movimientos != personaje.obtenerVelocidad()){
			Celda celdaNueva = this.controlador.pedirCelda();
			Celda celdaOrigen = this.controlador.obtenerOrigen(personaje);
			Tablero tablero = this.controlador.obtenerTablero();
			tablero.moverPersonaje(personaje, celdaOrigen, celdaNueva); 
			movimientos++;
			// cortar a voluntad debe ser aniadido
		}
	}
}
