package fiuba.algo3.ejemplo1;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import junit.framework.Assert;

public class TableroTest {
	
	@Test
	public void testAgregarPersonajeAgregaAlPersonajeEnLaCeldaCorrecta() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		Celda celda = tablero.obtenerCelda(3, 6);
		tablero.agregarPersonaje(celda,personaje);
		Assert.assertEquals("No paso", personaje, celda.obtenerPersonaje());
	}
	
	@Test
	public void testAgregarConsumibleLoAgregaEnLaCeldaCorrecta() {
		Tablero tablero = new Tablero(10);
		EsferaDragon esfera = new EsferaDragon();
		Celda celda = tablero.obtenerCelda(3, 6);
		tablero.agregarConsumible(celda, esfera);
		Assert.assertEquals("No agrego el consumible", esfera, celda.obtenerConsumible());
	}
	
	@Test
	public void testMoverPersonajeACeldaConConsumibleLoConsume() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		Equipo equipo = new Equipo(); 
		equipo.add(personaje);
		personaje.agregarAliados(equipo);
		EsferaDragon esfera = new EsferaDragon();
		Celda celda = tablero.obtenerCelda(3, 6);
		Celda celdaPersonaje = tablero.obtenerCelda(3, 7);
		celdaPersonaje.agregarPersonaje(personaje);
		tablero.agregarConsumible(celda, esfera);
		tablero.moverPersonaje(personaje, celdaPersonaje, celda);
		//tablero.agregarPersonaje(celda,personaje);
		Assert.assertEquals("No agrego el consumible", (float)25, personaje.obtenerPoderDePelea());		
	}
	
	@Test
	public void testMoverPersonajeAOtraCeldaLoMueve() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		Celda celdaInicial = tablero.obtenerCelda(3, 6);
		tablero.agregarPersonaje(celdaInicial, personaje);
		Celda celdaFinal = tablero.obtenerCelda(4, 6);
		tablero.moverPersonaje(personaje, celdaInicial, celdaFinal);
		Assert.assertEquals("No movio el personaje", personaje, celdaFinal.obtenerPersonaje());
	}

	@Test
	public void testMoverPersonajeAOtraCeldaDevuelveTrue() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		Celda celdaInicial = tablero.obtenerCelda(3, 6);
		tablero.agregarPersonaje(celdaInicial, personaje);
		Celda celdaFinal = tablero.obtenerCelda(4, 6);
		Assert.assertTrue("No devolvio true", tablero.moverPersonaje(personaje, celdaInicial, celdaFinal));
	}
	
	@Test 
	public void testIntentarMoverAUnaPosicionFueraDelTableroDevuelveFalso() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		Celda celda = tablero.obtenerCelda(10, 7);
		tablero.agregarPersonaje(celda,personaje);
		Celda celda2 = new Celda(11,7);
		Assert.assertFalse("No devolvio falso", tablero.moverPersonaje(personaje, celda, celda2));
	}
	
	
	@Test
	public void testIntentarMoverAUnaCeldaOcupadaDevuelveFalso() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku(); 
		Celda celda = tablero.obtenerCelda(10, 7);
		tablero.agregarPersonaje(celda,personaje);
		Freezer personaje2 = new Freezer();
		Celda celda2 = tablero.obtenerCelda(10, 8);
		tablero.agregarPersonaje(celda2,personaje2);
		Assert.assertFalse("No devolvio falso", tablero.moverPersonaje(personaje, celda, celda2));
	}
	
	@Test 
	public void testIntentarMoverAUnaCeldaNoAdyacenteDevuelveFalso() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku(); 
		Celda celdaInicial = tablero.obtenerCelda(10, 7);
		Celda celdaFinal = tablero.obtenerCelda(2, 1);
		tablero.agregarPersonaje(celdaInicial,personaje);
		tablero.moverPersonaje(personaje, celdaInicial, celdaFinal);
		Assert.assertFalse("No devolvio falso", tablero.moverPersonaje(personaje, celdaInicial, celdaFinal));
	}
}
