package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import junit.framework.Assert;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.Personaje.Piccolo;
import fiuba.algo3.ejemplo1.Personaje.RequisitosDeTransformacionInsuficientes;

public class GohanTest {

	@Test
	public void testObtenerNombreDevuelveElNombreCorrecto() {
		Gohan gohan = new Gohan();
		Assert.assertEquals("No paso: no devolvio Goku como nombre", "Gohan", gohan.getNombre());
	}

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		Gohan gohan = new Gohan();
		int ki = gohan.ki();
		gohan.aumentarKi();
		ki = gohan.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		Gohan gohan = new Gohan();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.aumentarKi();
		int ki = gohan.ki();
		gohan.reducirKi(10);
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: no devolvio 10", 10, ki);
	}
	
	@Test
	public void testReducirVidaDisminuyeLaVidaEnElValorPasado() {
		Gohan gohan = new Gohan();
		int vida = gohan.obtenerVida();
		gohan.reducirVida(20);
		vida = vida - gohan.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		Gohan gohan = new Gohan();
		gohan.reducirVida(200);
		int vida = gohan.obtenerVida();
		gohan.aumentarVida(100);
		vida = gohan.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		Gohan gohan = new Gohan();
		gohan.reducirVida(30);
		gohan.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 300", 300, gohan.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		Gohan gohan = new Gohan();
		Assert.assertEquals("No paso: no devolvio 300", 300, gohan.obtenerVida());
	}
	
	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		Gohan gohan = new Gohan();
		Assert.assertEquals("No paso: no devolvio 15", (float)15, gohan.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		Gohan gohan = new Gohan();
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		Gohan gohan = new Gohan();
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerVelocidad());
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testSuperSaiyajinLevantaExcepcionSiNoSeTieneElKiSuficinte(){
		Gohan gohan = new Gohan();
		gohan.SuperSaiyajin();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testSuperSaiyajinCambiaElPoderDePelea(){
		Gohan gohan = new Gohan();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.SuperSaiyajin();
		Assert.assertEquals("No paso: no devolvio 30", (float)30, gohan.obtenerPoderDePelea());
	}
	
	@Test
	public void testSuperSaiyajinCambiaLaDistanciaDeAtaque(){
		Gohan gohan = new Gohan();
		gohan.aumentarKi();
		gohan.aumentarKi();		
		gohan.SuperSaiyajin();
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testSuperSaiyajinCambiaLaVelocidad(){
		Gohan gohan = new Gohan();
		gohan.aumentarKi();
		gohan.aumentarKi();	
		gohan.SuperSaiyajin();
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerVelocidad());
	}
	
	@Test
	public void testSuperSaiyajinReduceElKi(){
		Gohan gohan = new Gohan();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.aumentarKi();
		int ki = gohan.ki();
		gohan.SuperSaiyajin();
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: el ki se redujo", 10, ki);
	}
	
	@Test(expected = RequisitosDeTransformacionInsuficientes.class)
	public void testSuperSaiyajin2LevantaExcepcionSiSusAliadosTienenMasDel30PorcientoDeVida(){
		Gohan gohan = new Gohan();
		Goku goku = new Goku();
		Piccolo piccolo = new Piccolo();
		ArrayList <Personaje> personajes = new ArrayList <Personaje>();
		personajes.add(goku);
		personajes.add(piccolo);
		gohan.SuperSaiyajin2(personajes);
		Assert.fail("No levanto excepcion");
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testSuperSaiyajin2LevantaExcepcionSiNoTieneElKiNecesario(){
		Gohan gohan = new Gohan();
		Goku goku = new Goku();
		Piccolo piccolo = new Piccolo();
		goku.reducirVida(351);
		piccolo.reducirVida(351);
		ArrayList <Personaje> personajes = new ArrayList <Personaje>();
		personajes.add(goku);
		personajes.add(piccolo);
		gohan.SuperSaiyajin2(personajes);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testSuperSaiyajin2AumentaLosStats(){
		Gohan gohan = new Gohan();
		Boolean estado = true;
		for(int i = 0; i < 8; i++){
			gohan.aumentarKi();
		}
		Goku goku = new Goku();
		Piccolo piccolo = new Piccolo();
		goku.reducirVida(351);
		piccolo.reducirVida(351);
		ArrayList <Personaje> personajes = new ArrayList <Personaje>();
		personajes.add(goku);
		personajes.add(piccolo);
		gohan.SuperSaiyajin2(personajes);
		estado = estado && gohan.obtenerVelocidad() == 3;
		estado = estado && gohan.obtenerDistanciaDeAtaque() == 4;
		estado = estado && gohan.obtenerPoderDePelea() == 100;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testSuperSaiyajin2DisminuyeElKi(){
		Gohan gohan = new Gohan();
		for(int i = 0; i < 8; i++){
			gohan.aumentarKi();
		}
		int ki = gohan.ki();
		Goku goku = new Goku();
		Piccolo piccolo = new Piccolo();
		goku.reducirVida(351);
		piccolo.reducirVida(351);
		ArrayList <Personaje> personajes = new ArrayList <Personaje>();
		personajes.add(goku);
		personajes.add(piccolo);
		gohan.SuperSaiyajin2(personajes);
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: el ki se redujo", 30, ki);
	}
	
	@Test
	public void testAtacarReduceLaVidaDelEnemigo(){
		Gohan gohan = new Gohan();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.SuperSaiyajin();
		Freezer freezer = new Freezer();
		float danio = gohan.obtenerPoderDePelea();
		int vida = freezer.obtenerVida();
		gohan.atacar(freezer);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)danio, vida);
	}
	
	@Test
	public void testAtacarHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Gohan gohan = new Gohan();
		MajinBoo majin = new MajinBoo();
		float danio = gohan.obtenerPoderDePelea();
		int vida = majin.obtenerVida();
		gohan.atacar(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)(danio * 0.8), vida);
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testLanzarHabilidadEspecialLanzaExcepcionSiNoSeTieneElKiSuficiente(){
		Gohan gohan = new Gohan();
		Freezer freezer = new Freezer();
		gohan.lanzarHabilidadEspecial(freezer);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceLaVidaDelEnemigo(){
		Gohan gohan = new Gohan();
		Freezer freezer = new Freezer();
		int vida = freezer.obtenerVida();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.SuperSaiyajin();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.lanzarHabilidadEspecial(freezer);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 37, vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceElKi(){
		Gohan gohan = new Gohan();
		Freezer freezer = new Freezer();
		gohan.aumentarKi();
		gohan.aumentarKi();
		int ki = gohan.ki();
		gohan.lanzarHabilidadEspecial(freezer);
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: no se redujo el ki", 10, ki);
	}
	
	@Test
	public void testLanzarHabilidadEspecialHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Gohan gohan = new Gohan();
		MajinBoo majin = new MajinBoo();
		int vida = majin.obtenerVida();
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.lanzarHabilidadEspecial(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 15, vida);
	}
}
