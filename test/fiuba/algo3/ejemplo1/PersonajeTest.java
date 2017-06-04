package fiuba.algo3.ejemplo1;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.KiInsuficiente;
import junit.framework.Assert;

public class PersonajeTest {

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		Goku goku = new Goku();
		int ki = goku.ki();
		goku.aumentarKi();
		ki = goku.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		Goku goku = new Goku();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		int ki = goku.ki();
		goku.reducirKi(10);
		ki = ki - goku.ki();
		Assert.assertEquals("No paso: no devolvio 10", 10, ki);
	}
	
	@Test
	public void testReducirVidaDisminuyeLaVidaEnElValorPasado() {
		Goku goku = new Goku();
		int vida = goku.obtenerVida();
		goku.reducirVida(20);
		vida = vida - goku.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		Goku goku = new Goku();
		goku.reducirVida(200);
		int vida = goku.obtenerVida();
		goku.aumentarVida(100);
		vida = goku.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		Goku goku = new Goku();
		goku.reducirVida(30);
		goku.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 500", 500, goku.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		Goku goku = new Goku();
		Assert.assertEquals("No paso: no devolvio 500", 500, goku.obtenerVida());
	}
	
	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		Goku goku = new Goku();
		Assert.assertEquals("No paso: no devolvio 20", (float)20, goku.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		Goku goku = new Goku();
		Assert.assertEquals("No paso: no devolvio 2", 2, goku.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		Goku goku = new Goku();
		Assert.assertEquals("No paso: no devolvio 2", 2, goku.obtenerVelocidad());
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testKaioKenLevantaExcepcionSiNoSeTieneElKiSuficinte(){
		Goku goku = new Goku();
		goku.kaioKen();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testKaioKenCambiaElPoderDePelea(){
		Goku goku = new Goku();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();		
		goku.kaioKen();
		Assert.assertEquals("No paso: no devolvio 40", (float)40, goku.obtenerPoderDePelea());
	}
	
	@Test
	public void testKaioKenCambiaLaDistanciaDeAtaque(){
		Goku goku = new Goku();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();		
		goku.kaioKen();
		Assert.assertEquals("No paso: no devolvio 4", 4, goku.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testKaioKenCambiaLaVelocidad(){
		Goku goku = new Goku();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();		
		goku.kaioKen();
		Assert.assertEquals("No paso: no devolvio 3", 3, goku.obtenerVelocidad());
	}
	
	@Test
	public void testKaioKenReduceEn20ElKi(){
		Goku goku = new Goku();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();		
		goku.kaioKen();
		Assert.assertEquals("No paso: no devolvio 0", 0, goku.ki());
	}
}
