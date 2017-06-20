package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Excepciones.PersonajeInexistente;
import fiuba.algo3.ejemplo1.Excepciones.PersonajeNoMovilizable;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Juego;
import fiuba.algo3.ejemplo1.juego.Jugador;
import fiuba.algo3.ejemplo1.juego.Turno;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import junit.framework.Assert;

public class TurnoTest {
	
	@Test
	public void testMoverPersonajeLoMueveSiEsSuTurnoYEsSuyo() {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje goku = tablero.obtenerCelda(1, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(1, 6);
		turno.mover(goku, celdaFinal);
		Assert.assertEquals("No paso: ", goku, tablero.obtenerCelda(1, 6).obtenerPersonaje());
	}

	@Test(expected = PersonajeInexistente.class)
	public void testMoverPersonajeLevantaExcepcionSiElPersonajeNoEsSuyo() {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje freezer = tablero.obtenerCelda(9, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(9, 6);
		turno.mover(freezer, celdaFinal);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testPasarTurnoCambiaElTurnoDelJugador() {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje freezer = tablero.obtenerCelda(9, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(9, 6);
		turno.pasarTurno();
		turno.mover(freezer, celdaFinal);
		Assert.assertEquals("No paso: ", freezer, tablero.obtenerCelda(9, 6).obtenerPersonaje());
	}
	
	@Test (expected = PersonajeInexistente.class)
	public void testMoverPersonajeLevantaExcepcionAlMoverUnPersonajeDelOtroJugadorCuandoSePasoTurno() {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje goku = tablero.obtenerCelda(1, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(1, 6);
		turno.pasarTurno();
		turno.mover(goku, celdaFinal);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = PersonajeNoMovilizable.class)
	public void testMoverPersonajeNoPermiteMoverDosPersonajesDistintos() {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje piccolo =  tablero.obtenerCelda(1, 9).obtenerPersonaje();
		Celda celdaPiccolo = tablero.obtenerCelda(1, 8);
		Personaje goku = tablero.obtenerCelda(1, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(1, 6);
		turno.mover(goku, celdaFinal);
		turno.mover(piccolo, celdaPiccolo);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = PersonajeNoMovilizable.class)
	public void testMoverPersonajeSePuedeUtilizarHastaQueElPersonajeNoTengaMasMovimientos() {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje goku = tablero.obtenerCelda(1, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(1, 6);
		turno.mover(goku, celdaFinal);
		celdaFinal = tablero.obtenerCelda(1, 7);
		turno.mover(goku, celdaFinal);
		celdaFinal = tablero.obtenerCelda(1, 8);
		turno.mover(goku, celdaFinal);
		Assert.fail("No levanto excepcion");
	}
	
	@Test 
	public void testMoverPersonajeNoLevantaExcepcionSiNoSeAlcanzoElLimiteDeMovimientos(){
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		if(turno.obtenerJugador() != guerreros)
			turno.pasarTurno();
		Personaje goku = tablero.obtenerCelda(1, 5).obtenerPersonaje();
		Celda celdaFinal = tablero.obtenerCelda(1, 6);
		turno.mover(goku, celdaFinal);
		celdaFinal = tablero.obtenerCelda(1, 7);
		turno.mover(goku, celdaFinal);
		Assert.assertEquals("No paso: ", goku, tablero.obtenerCelda(1, 7).obtenerPersonaje());
	}
}
