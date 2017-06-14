package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;

public class MajinBooTest {

	@Test
	public void testObtenerNombreDevuelveElNombreCorrecto() {
		MajinBoo majin = new MajinBoo();
		Assert.assertEquals("No paso: no devolvio MajinBoo como nombre", "Majin Boo", majin.getNombre());
	}

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		MajinBoo majin = new MajinBoo();
		int ki = majin.ki();
		majin.aumentarKi();
		ki = majin.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		int ki = majin.ki();
		majin.reducirKi(10);
		ki = ki - majin.ki();
		Assert.assertEquals("No paso: no devolvio 10", 10, ki);
	}
	
	@Test
	public void testReducirVidaDisminuyeLaVidaEnElValorPasado() {
		MajinBoo majin = new MajinBoo();
		int vida = majin.obtenerVida();
		majin.reducirVida(20);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		MajinBoo majin = new MajinBoo();
		majin.reducirVida(200);
		int vida = majin.obtenerVida();
		majin.aumentarVida(100);
		vida = majin.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		MajinBoo majin = new MajinBoo();
		majin.reducirVida(30);
		majin.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 300", 300, majin.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		MajinBoo majin = new MajinBoo();
		Assert.assertEquals("No paso: no devolvio 300", 300, majin.obtenerVida());
	}
	
	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		MajinBoo majin = new MajinBoo();
		Assert.assertEquals("No paso: no devolvio 30", (float)30, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		MajinBoo majin = new MajinBoo();
		Assert.assertEquals("No paso: no devolvio 2", 2, majin.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		MajinBoo majin = new MajinBoo();
		Assert.assertEquals("No paso: no devolvio 2", 2, majin.obtenerVelocidad());
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testBooMaloLevantaExcepcionSiNoSeTieneElKiSuficinte(){
		MajinBoo majin = new MajinBoo();
		majin.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testBooMaloCambiaElPoderDePelea(){
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.transformar();
		Assert.assertEquals("No paso: no devolvio 50", (float)50, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testBooMaloCambiaLaDistanciaDeAtaque(){
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.transformar();
		Assert.assertEquals("No paso: no devolvio 2", 2, majin.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testBooMaloCambiaLaVelocidad(){
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.transformar();
		Assert.assertEquals("No paso: no devolvio 3", 3, majin.obtenerVelocidad());
	}
	
	@Test
	public void testBooMaloReduceElKi(){
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		int ki = majin.ki();
		majin.transformar();
		ki = ki - majin.ki();
		Assert.assertEquals("No paso: el ki se redujo", 20, ki);
	}

	@Test(expected = KiInsuficiente.class)
	public void testBooOriginalLevantaExcepcionSiNoTieneElKiNecesario(){
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.aumentarKi();
		majin.transformar();
		majin.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testBooOriginalAumentaLosStats(){
		MajinBoo majin = new MajinBoo();
		Boolean estado = true;
		for(int i = 0; i < 14; i++){
			majin.aumentarKi();
		}
		majin.transformar();
		majin.transformar();
		estado = estado && majin.obtenerVelocidad() == 4;
		estado = estado && majin.obtenerDistanciaDeAtaque() == 3;
		estado = estado && majin.obtenerPoderDePelea() == 60;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testBooOriginalDisminuyeElKi(){
		MajinBoo majin = new MajinBoo();
		for(int i = 0; i < 14; i++){
			majin.aumentarKi();
		}
		majin.transformar();
		int ki = majin.ki();
		majin.transformar();
		ki = ki - majin.ki();
		Assert.assertEquals("No paso: el ki se redujo", 50, ki);
	}
	
	@Test
	public void testAtacarReduceLaVidaDelEnemigo(){
		MajinBoo majin = new MajinBoo();
		majin.aumentarKi();
		majin.aumentarKi();
		Gohan gohan = new Gohan();
		float danio = majin.obtenerPoderDePelea();
		int vida = gohan.obtenerVida();
		majin.atacar(gohan);
		vida = vida - gohan.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)danio, vida);
	}
	
	@Test
	public void testAtacarHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.aumentarKi();
		goku.transformar();
		float danio = majin.obtenerPoderDePelea();
		int vida = goku.obtenerVida();
		majin.atacar(goku);
		vida = vida - goku.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)(danio * 0.8), vida);
	}
	
	//AGREGAR PRUEBAS DE LA HABILIDAD ESPECIAL
}
