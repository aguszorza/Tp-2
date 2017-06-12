package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import junit.framework.Assert;

public class GokuTest {

	@Test
	public void testObtenerNombreDevuelveElNombreCorrecto() {
		Goku goku = new Goku();
		Assert.assertEquals("No paso: no devolvio Goku como nombre", "Goku", goku.getNombre());
	}

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
	
	@Test(expected = KiInsuficiente.class)
	public void testSuperSaiyajinLevantaExcepcionSiNoSeTieneElKiSuficiente(){
		Goku goku = new Goku();
		goku.SuperSaiyajin();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testSuperSaiyajinAumentaLosStats(){
		Goku goku = new Goku();
		Boolean estado = true;
		for(int i = 0; i < 10; i++){
			goku.aumentarKi();
		}
		goku.SuperSaiyajin();
		estado = estado && goku.obtenerVelocidad() == 5;
		estado = estado && goku.obtenerDistanciaDeAtaque() == 4;
		estado = estado && goku.obtenerPoderDePelea() == 60;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testSuperSaiyajinDisminuyeElKiEn50(){
		Goku goku = new Goku();
		for(int i = 0; i < 11; i++){
			goku.aumentarKi();
		}
		int ki = goku.ki();
		goku.SuperSaiyajin();
		ki = ki - goku.ki();
		Assert.assertEquals("No paso: no disminuyo en 50 el ki", 50, ki);
	}
	
	@Test
	public void testPoderDePeleaAumentaUn20PorcientoSiTieneMenosDe150DeVida() {
		Goku goku = new Goku();
		goku.reducirVida(351);
		Assert.assertEquals("No paso: no devolvio 24", (float)24, goku.obtenerPoderDePelea());
	}
	
	@Test
	public void testPoderDePeleaAumentaUn20PorcientoSiTieneMenosDe150DeVidaEnModoKaioKen() {
		Goku goku = new Goku();
		for(int i = 0; i < 10; i++)
			goku.aumentarKi();
		goku.kaioKen();
		goku.reducirVida(351);
		Assert.assertEquals("No paso: no devolvio 48", (float)48, goku.obtenerPoderDePelea());
	}
	
	@Test
	public void testPoderDePeleaAumentaUn20PorcientoSiTieneMenosDe150DeVidaEnModoSuperSaiyajin() {
		Goku goku = new Goku();
		for(int i = 0; i < 10; i++)
			goku.aumentarKi();
		goku.SuperSaiyajin();
		goku.reducirVida(351);
		Assert.assertEquals("No paso: no devolvio 72", (float)72, goku.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarReduceLaVidaDelEnemigo(){
		Goku goku = new Goku();
		Freezer freezer = new Freezer();
		float danio = goku.obtenerPoderDePelea();
		int vida = freezer.obtenerVida();
		goku.atacar(freezer);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)danio, vida);
	}
	
	@Test
	public void testAtacarHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Goku goku = new Goku();
		MajinBoo majin = new MajinBoo();
		float danio = goku.obtenerPoderDePelea();
		int vida = majin.obtenerVida();
		goku.atacar(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)(danio * 0.8), vida);
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testLanzarHabilidadEspecialLanzaExcepcionSiNoSeTieneElKiSuficiente(){
		Goku goku = new Goku();
		Freezer freezer = new Freezer();
		goku.lanzarHabilidadEspecial(freezer);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceLaVidaDelEnemigo(){
		Goku goku = new Goku();
		Freezer freezer = new Freezer();
		int vida = freezer.obtenerVida();
		for(int i = 0; i < 10; i++)
			goku.aumentarKi();
		goku.lanzarHabilidadEspecial(freezer);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 30, vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Goku goku = new Goku();
		MajinBoo majin = new MajinBoo();
		int vida = majin.obtenerVida();
		for(int i = 0; i < 10; i++)
			goku.aumentarKi();
		goku.lanzarHabilidadEspecial(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 24, vida);
	}

}
