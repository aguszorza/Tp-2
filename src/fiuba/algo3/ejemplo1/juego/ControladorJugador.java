package fiuba.algo3.ejemplo1.juego;

import java.util.Enumeration;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;

public class ControladorJugador {
	
	private Jugador jugador;
	private Enumeration<Accion> acciones;
	
	public ControladorJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
	public Personaje elejir(Enumeration <Personaje> personajes){
		return null;
	}
	
	public Celda pedirCelda() {
		int fila = 0;
		int columna = 0; // cambiar para que sea variable y no constante
		Celda celda = new Celda(fila,columna);
		return celda;
	}

	public Personaje seleccionarPersonajeAliado() {
		Personaje personaje = this.elejir(this.jugador.obtenerPersonajesAliados());
		return personaje;
	}

	public Personaje seleccionarPersonajeEnemigo() {
		Personaje personaje = this.elejir(this.jugador.obtenerPersonajesEnemigos());
		return personaje;
	}
	
	public Accion seleccionarAccion() {
		return null;
	}

	public void verificarAtaque(Personaje atacante, Personaje enemigo) {
		this.jugador.verificarAtaque(atacante, enemigo);
		
	}

	public Tablero obtenerTablero(){
		return this.jugador.obtenerTablero();
		
	}

	public Celda obtenerOrigen(Personaje personaje) {
		return this.jugador.obtenerCelda(personaje);
		
	}
}