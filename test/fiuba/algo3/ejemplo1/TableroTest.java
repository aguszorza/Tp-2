package fiuba.algo3.ejemplo1;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.CeldaVacia;
import fiuba.algo3.ejemplo1.tablero.MovimientoInvalido;
import fiuba.algo3.ejemplo1.tablero.CeldaOcupada;
import fiuba.algo3.ejemplo1.tablero.PosicionFueraDelTablero;
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
		tablero.agregarPersonaje(3,6,personaje);
		Assert.assertEquals("No paso", personaje, tablero.obtenerCelda(3, 6).obtenerPersonaje());
	}
	
	@Test
	public void testMoverPersonajeAOtraCeldaLoMueve() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		tablero.agregarPersonaje(3,6,personaje);
		tablero.moverPersonaje(3, 6, 4, 6);
		Assert.assertEquals("No paso", personaje, tablero.obtenerCelda(4, 6).obtenerPersonaje());
	}

	@Test (expected = PosicionFueraDelTablero.class)
	public void testIntentarMoverAUnaPosicionFueraDelTableroLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		tablero.agregarPersonaje(10,7,personaje);
		tablero.moverPersonaje(10, 7, 11, 7);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = CeldaVacia.class)
	public void testIntentarMoverDesdeUnaCeldaVaciaLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku();
		tablero.agregarPersonaje(10,7,personaje);
		tablero.moverPersonaje(9, 7, 9, 8);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = CeldaOcupada.class)
	public void testIntentarMoverAUnaCeldaOcupadaLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku(); 
		tablero.agregarPersonaje(10,7,personaje);
		Freezer personaje2 = new Freezer();
		tablero.agregarPersonaje(10,8,personaje2);
		tablero.moverPersonaje(10, 7, 10, 8);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = MovimientoInvalido.class)
	public void testIntentarMoverAUnaCeldaNoAdyacenteLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		Goku personaje = new Goku(); 
		tablero.agregarPersonaje(10,7,personaje);
		tablero.moverPersonaje(10, 7, 2, 1);
		Assert.fail("No levanto excepcion");
	}
}
