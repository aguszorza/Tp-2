package fiuba.algo3.ejemplo1;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.tablero.Celda;
import junit.framework.Assert;

public class CeldaTest {
	
	@Test
	public void testEstaVaciaDelvuelveFalseSiNoTieneUnPersonaje(){
		Celda celda = new Celda(1,1);
		Assert.assertTrue("No devolvio true", celda.estaVacia());
	}
	
	@Test
	public void testCrearCeldaLaCreaVacia() {
		Celda celda = new Celda(1,1);
		Assert.assertTrue("No se creo vacia", celda.estaVacia());
	}

	@Test
	public void testObtenerFilaDevuelveLaFila() {
		Celda celda = new Celda(1,3);
		Assert.assertEquals("No devolvio 1", 1, celda.obtenerFila());
	}
	
	@Test
	public void testObtenerColumnaDevuelveLaColumna() {
		Celda celda = new Celda(1,3);
		Assert.assertEquals("No devolvio 3", 3, celda.obtenerColumna());
	}
	
	@Test
	public void testAgregarPersonajeAgregaAlPersonaje() {
		Celda celda = new Celda(1,3);
		Goku personaje = new Goku();
		celda.agregarPersonaje(personaje);
		Assert.assertFalse("No tiene un personaje", celda.estaVacia());
	}
	
	@Test
	public void testObtenerPersonajeDevuelveElPersonaje() {
		Celda celda = new Celda(1,3);
		Goku personaje = new Goku();
		celda.agregarPersonaje(personaje);
		Assert.assertTrue("No tiene un personaje", personaje == celda.obtenerPersonaje());
	}
	
	@Test
	public void testEsAdyacenteDevuelveTrueEnTodasLasCeldasAdyacentes(){
		Celda celda = new Celda(2,3);
		Boolean estado = true;
		for (int i = 1; i < 4; i++){
			for (int j = 2; j < 5; j ++){
				Celda celda2= new Celda(i, j);
				estado = estado && celda.esAdyacente(celda2);
			}
		}
		Assert.assertTrue("No devolvio true en una celda adyacente", estado);
	}
	
	@Test
	public void testEsAdyacenteDevuelveFalseSiLaCeldaNoEsAdyacente(){
		Celda celda = new Celda(2,3);
		Celda celda2= new Celda(3, 5);
		Assert.assertFalse("No devolvio false con una celda no adyacente", celda.esAdyacente(celda2));
	}
	
	@Test
	public void testRemoverPersonajeRemueveElPersonaje(){
		Celda celda = new Celda(2,3);
		Goku personaje = new Goku();
		celda.agregarPersonaje(personaje);
		celda.removerPersonaje();
		Assert.assertTrue("La celda no esta vacia", celda.estaVacia());
	}
}
