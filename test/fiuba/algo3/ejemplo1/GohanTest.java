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
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		Assert.assertEquals("No paso: no devolvio Gohan como nombre", "Gohan", gohan.getNombre());
	}

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		int ki = gohan.ki();
		gohan.aumentarKi();
		ki = gohan.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
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
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		int vida = gohan.obtenerVida();
		gohan.reducirVida(20);
		vida = vida - gohan.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.reducirVida(200);
		int vida = gohan.obtenerVida();
		gohan.aumentarVida(100);
		vida = gohan.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.reducirVida(30);
		gohan.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 300", 300, gohan.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		Assert.assertEquals("No paso: no devolvio 300", 300, gohan.obtenerVida());
	}
	
	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		Assert.assertEquals("No paso: no devolvio 15", (float)15, gohan.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerVelocidad());
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testSuperSaiyajinLevantaExcepcionSiNoSeTieneElKiSuficinte(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testSuperSaiyajinCambiaElPoderDePelea(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.transformar();
		Assert.assertEquals("No paso: no devolvio 30", (float)30, gohan.obtenerPoderDePelea());
	}
	
	@Test
	public void testSuperSaiyajinCambiaLaDistanciaDeAtaque(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.aumentarKi();
		gohan.aumentarKi();		
		gohan.transformar();
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testSuperSaiyajinCambiaLaVelocidad(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.aumentarKi();
		gohan.aumentarKi();	
		gohan.transformar();
		Assert.assertEquals("No paso: no devolvio 2", 2, gohan.obtenerVelocidad());
	}
	
	@Test
	public void testSuperSaiyajinReduceElKi(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.aumentarKi();
		int ki = gohan.ki();
		gohan.transformar();
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: el ki se redujo", 10, ki);
	}
	
	@Test(expected = RequisitosDeTransformacionInsuficientes.class)
	public void testSuperSaiyajin2LevantaExcepcionSiSusAliadosTienenMasDel30PorcientoDeVida(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		for(int i = 0; i < 10; i++){
			gohan.aumentarKi();
		}
		gohan.transformar();
		gohan.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testSuperSaiyajin2LevantaExcepcionSiNoTieneElKiNecesario(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		freezer.reducirVida(300);
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.transformar();
		gohan.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testSuperSaiyajin2AumentaLosStats(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		freezer.reducirVida(300);
		Boolean estado = true;
		for(int i = 0; i < 10; i++){
			gohan.aumentarKi();
		}
		gohan.transformar();
		gohan.transformar();
		estado = estado && gohan.obtenerVelocidad() == 3;
		estado = estado && gohan.obtenerDistanciaDeAtaque() == 4;
		estado = estado && gohan.obtenerPoderDePelea() == 100;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testSuperSaiyajin2DisminuyeElKi(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		gohan.agregarAliados(aliado);
		for(int i = 0; i < 10; i++){
			gohan.aumentarKi();
		}
		freezer.reducirVida(300);
		gohan.transformar();
		int ki = gohan.ki();
		gohan.transformar();
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: el ki se redujo", 30, ki);
	}
	
	@Test
	public void testAtacarReduceLaVidaDelEnemigo(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		aliado.add(freezer);
		gohan.aumentarKi();
		gohan.aumentarKi();
		gohan.transformar();
		Freezer enemigo = new Freezer();
		float danio = gohan.obtenerPoderDePelea();
		int vida = enemigo.obtenerVida();
		gohan.atacar(enemigo);
		vida = vida - enemigo.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)danio, vida);
	}
	
	@Test
	public void testAtacarHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Freezer freezer = new Freezer();
		ArrayList <Personaje> aliado = new ArrayList <Personaje>();
		aliado.add(freezer);
		Gohan gohan = new Gohan();
		aliado.add(freezer);
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
		gohan.transformar();
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
