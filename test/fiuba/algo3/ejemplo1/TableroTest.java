package fiuba.algo3.ejemplo1;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Excepciones.CeldaOcupada;
import fiuba.algo3.ejemplo1.Excepciones.CeldaVacia;
import fiuba.algo3.ejemplo1.Excepciones.MovimientoInvalido;
import fiuba.algo3.ejemplo1.Excepciones.PosicionFueraDelTablero;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import junit.framework.Assert;

public class TableroTest {

	/*@Test
	public void testCrearTableroYObtenerCeldas() {
		Tablero tablero = new Tablero(10);
		int contador = 1;
		Boolean estado = true;
		for(int i = 1; i <= 10; i++){
			for(int j = 1; j <= 10; j++){
				Personaje personaje = new Personaje(100, Integer.toString(contador));
				tablero.agregarPersonaje(i, j, personaje);
				contador ++;
			}
		}
		contador = 1;
		Celda celda;
		for(int i = 1; i <= 10; i++){
			for(int j = 1; j <= 10; j++){
				celda = tablero.obtenerCelda(i, j);
				estado = (estado && (celda.obtenerPersonaje().getNombre().equals(Integer.toString(contador)))); 
				contador ++;
			}
		}
		Assert.assertTrue(estado);
	}*/
	
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
		EsferaDragon esfera = new EsferaDragon();
		Celda celda = tablero.obtenerCelda(3, 6);
		tablero.agregarConsumible(celda, esfera);
		tablero.agregarPersonaje(celda,personaje);
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

	@Test (expected = PosicionFueraDelTablero.class)
	public void testIntentarMoverAUnaPosicionFueraDelTableroLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		Celda celdaInicial = tablero.obtenerCelda(10, 7);
		tablero.agregarPersonaje(celdaInicial,personaje);
		Celda celdaFinal = new Celda(11,7);
		tablero.moverPersonaje(personaje, celdaInicial, celdaFinal);
		Assert.fail("No levanto excepcion");
	}
	
	
	@Test (expected = CeldaOcupada.class)
	public void testIntentarMoverAUnaCeldaOcupadaLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku(); 
		Celda celda = tablero.obtenerCelda(10, 7);
		tablero.agregarPersonaje(celda,personaje);
		Freezer personaje2 = new Freezer();
		Celda celda2 = tablero.obtenerCelda(10, 8);
		tablero.agregarPersonaje(celda2,personaje2);
		tablero.moverPersonaje(personaje, celda, celda2);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = MovimientoInvalido.class)
	public void testIntentarMoverAUnaCeldaNoAdyacenteLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku(); 
		Celda celdaInicial = tablero.obtenerCelda(10, 7);
		Celda celdaFinal = tablero.obtenerCelda(2, 1);
		tablero.agregarPersonaje(celdaInicial,personaje);
		tablero.moverPersonaje(personaje, celdaInicial, celdaFinal);
		
		Assert.fail("No levanto excepcion");
	}
}
