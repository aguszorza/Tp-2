package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
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
	
	@Test
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
		Assert.assertFalse("No devolvio falso",turno.mover(piccolo, celdaPiccolo));
	}
	
	@Test
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
		Assert.assertFalse("No devolvio falso",turno.mover(goku, celdaFinal));
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
	
	
	@Test 
	public void testConsumirEsferaAumentaEnUnoLaCantidadDeEsferasDelEquipo(){
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Personaje personaje = guerreros.obtenerPersonajesAliados().nextElement();
		EsferaDragon esfera = new EsferaDragon();
		int cantidad = personaje.cantidadEsferas();
		personaje.consumir(esfera);
		cantidad = personaje.cantidadEsferas() - cantidad;
		Assert.assertEquals("No paso: ", 1, cantidad);
	}
	
	@Test 
	public void testConsumirNubeNoAumentaLaCantidadDeEsferasDelEquipo(){
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Personaje personaje = guerreros.obtenerPersonajesAliados().nextElement();
		NubeVoladora esfera = new NubeVoladora();
		int cantidad = personaje.cantidadEsferas();
		personaje.consumir(esfera);
		cantidad = personaje.cantidadEsferas() - cantidad;
		Assert.assertEquals("No paso: ", 0, cantidad);
	}
	
	@Test 
	public void testConsumirSemillaNoAumentaLaCantidadDeEsferasDelEquipo(){
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Personaje personaje = guerreros.obtenerPersonajesAliados().nextElement();
		SemillaErmitanio esfera = new SemillaErmitanio();
		int cantidad = personaje.cantidadEsferas();
		personaje.consumir(esfera);
		cantidad = personaje.cantidadEsferas() - cantidad;
		Assert.assertEquals("No paso: ", 0, cantidad);
	}
	
	@Test 
	public void testPasarTurnoNoAumentaLaCantidadDeEsferas(){
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Personaje personaje = guerreros.obtenerPersonajesAliados().nextElement();
		EsferaDragon esfera = new EsferaDragon();
		int cantidad = personaje.cantidadEsferas();
		personaje.consumir(esfera);
		personaje.pasarTurno();
		cantidad = personaje.cantidadEsferas() - cantidad;
		Assert.assertEquals("No paso: ", 1, cantidad);
	}
}
