package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;
import fiuba.algo3.ejemplo1.Personaje.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.Piccolo;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.RequisitosDeTransformacionInsuficientes;

public class PiccoloTest {

	@Test
	public void testObtenerNombreDevuelveElNombreCorrecto() {
		Piccolo piccolo = new Piccolo();
		Assert.assertEquals("No paso: no devolvio Goku como nombre", "Piccolo", piccolo.getNombre());
	}

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		Piccolo piccolo = new Piccolo();
		int ki = piccolo.ki();
		piccolo.aumentarKi();
		ki = piccolo.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		Piccolo piccolo = new Piccolo();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		int ki = piccolo.ki();
		piccolo.reducirKi(10);
		ki = ki - piccolo.ki();
		Assert.assertEquals("No paso: no devolvio 10", 10, ki);
	}
	
	@Test
	public void testReducirVidaDisminuyeLaVidaEnElValorPasado() {
		Piccolo piccolo = new Piccolo();
		int vida = piccolo.obtenerVida();
		piccolo.reducirVida(20);
		vida = vida - piccolo.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		Piccolo piccolo = new Piccolo();
		piccolo.reducirVida(200);
		int vida = piccolo.obtenerVida();
		piccolo.aumentarVida(100);
		vida = piccolo.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		Piccolo piccolo = new Piccolo();
		piccolo.reducirVida(30);
		piccolo.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 500", 500, piccolo.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		Piccolo piccolo = new Piccolo();
		Assert.assertEquals("No paso: no devolvio 500", 500, piccolo.obtenerVida());
	}

	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		Piccolo piccolo = new Piccolo();
		Assert.assertEquals("No paso: no devolvio 20", (float)20, piccolo.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		Piccolo piccolo = new Piccolo();
		Assert.assertEquals("No paso: no devolvio 2", 2, piccolo.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		Piccolo piccolo = new Piccolo();
		Assert.assertEquals("No paso: no devolvio 2", 2, piccolo.obtenerVelocidad());
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testFortalecidoLevantaExcepcionSiNoSeTieneElKiSuficinte(){
		Piccolo piccolo = new Piccolo();
		piccolo.fortalecido();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testFortalecidoCambiaElPoderDePelea(){
		Piccolo piccolo = new Piccolo();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.fortalecido();
		Assert.assertEquals("No paso: no devolvio 40", (float)40, piccolo.obtenerPoderDePelea());
	}
	
	@Test
	public void testFortalecidoCambiaLaDistanciaDeAtaque(){
		Piccolo piccolo = new Piccolo();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.fortalecido();
		Assert.assertEquals("No paso: no devolvio 4", 4, piccolo.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testFortalecidoCambiaLaVelocidad(){
		Piccolo piccolo = new Piccolo();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.fortalecido();
		Assert.assertEquals("No paso: no devolvio 3", 3, piccolo.obtenerVelocidad());
	}
	
	@Test
	public void testFortalecidoReduceElKi(){
		Piccolo piccolo = new Piccolo();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		piccolo.aumentarKi();
		int ki = piccolo.ki();
		piccolo.fortalecido();
		ki = ki - piccolo.ki();
		Assert.assertEquals("No paso: el ki se redujo", 20, ki);
	}
	
	@Test(expected = RequisitosDeTransformacionInsuficientes.class)
	public void testProtectorLevantaExcepcionSiGohanTieneMasDel20PorcientoDeVida(){
		Piccolo piccolo = new Piccolo();
		Gohan gohan = new Gohan();
		piccolo.protector(gohan);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testProtectorAumentaLosStats(){
		Piccolo piccolo = new Piccolo();
		Boolean estado = true;
		Gohan gohan = new Gohan();
		gohan.reducirVida(241);
		piccolo.protector(gohan);
		estado = estado && piccolo.obtenerVelocidad() == 4;
		estado = estado && piccolo.obtenerDistanciaDeAtaque() == 6;
		estado = estado && piccolo.obtenerPoderDePelea() == 60;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testProtectorNoDisminuyeElKi(){
		Piccolo piccolo = new Piccolo();
		piccolo.aumentarKi();
		int ki = piccolo.ki();
		Gohan gohan = new Gohan();
		gohan.reducirVida(241);
		piccolo.protector(gohan);
		ki = ki - piccolo.ki();
		Assert.assertEquals("No paso: el ki se redujo", 0, ki);
	}
}
