package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;
import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
import fiuba.algo3.ejemplo1.Excepciones.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.Personaje.Piccolo;

public class FreezerTest {

	@Test
	public void testObtenerNombreDevuelveElNombreCorrecto() {
		Freezer freezer = new Freezer();
		Assert.assertEquals("No paso: no devolvio Freezer como nombre", "Freezer", freezer.getNombre());
	}

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		Freezer freezer = new Freezer();
		int ki = freezer.ki();
		freezer.aumentarKi();
		ki = freezer.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		int ki = freezer.ki();
		freezer.reducirKi(10);
		ki = ki - freezer.ki();
		Assert.assertEquals("No paso: no devolvio 10", 10, ki);
	}
	
	@Test
	public void testReducirVidaDisminuyeLaVidaEnElValorPasado() {
		Freezer freezer = new Freezer();
		int vida = freezer.obtenerVida();
		freezer.reducirVida(20);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		Freezer freezer = new Freezer();
		freezer.reducirVida(200);
		int vida = freezer.obtenerVida();
		freezer.aumentarVida(100);
		vida = freezer.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		Freezer freezer = new Freezer();
		freezer.reducirVida(30);
		freezer.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 400", 400, freezer.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		Freezer freezer = new Freezer();
		Assert.assertEquals("No paso: no devolvio 400", 400, freezer.obtenerVida());
	}
	
	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		Freezer freezer = new Freezer();
		Assert.assertEquals("No paso: no devolvio 20", (float)20, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		Freezer freezer = new Freezer();
		Assert.assertEquals("No paso: no devolvio 2", 2, freezer.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		Freezer freezer = new Freezer();
		Assert.assertEquals("No paso: no devolvio 4", 4, freezer.obtenerVelocidad());
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testSegundaFormaLevantaExcepcionSiNoSeTieneElKiSuficinte(){
		Freezer freezer = new Freezer();
		freezer.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testSegundaFormaCambiaElPoderDePelea(){
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.transformar();
		Assert.assertEquals("No paso: no devolvio 40", (float)40, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testSegundaFormaCambiaLaDistanciaDeAtaque(){
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.transformar();
		Assert.assertEquals("No paso: no devolvio 3", 3, freezer.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testSegundaFormaCambiaLaVelocidad(){
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.transformar();
		Assert.assertEquals("No paso: no devolvio 4", 4, freezer.obtenerVelocidad());
	}
	
	@Test
	public void testSuperSaiyajinReduceElKi(){
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		int ki = freezer.ki();
		freezer.transformar();
		ki = ki - freezer.ki();
		Assert.assertEquals("No paso: el ki se redujo", 20, ki);
	}

	@Test(expected = KiInsuficiente.class)
	public void testDefinitivoLevantaExcepcionSiNoTieneElKiNecesario(){
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.transformar();
		freezer.transformar();
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testDefinitivoAumentaLosStats(){
		Freezer freezer = new Freezer();
		Boolean estado = true;
		for(int i = 0; i < 14; i++){
			freezer.aumentarKi();
		}
		freezer.transformar();
		freezer.transformar();
		estado = estado && freezer.obtenerVelocidad() == 6;
		estado = estado && freezer.obtenerDistanciaDeAtaque() == 3;
		estado = estado && freezer.obtenerPoderDePelea() == 50;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testDefinitivoDisminuyeElKi(){
		Freezer freezer = new Freezer();
		for(int i = 0; i < 14; i++){
			freezer.aumentarKi();
		}
		freezer.transformar();
		int ki = freezer.ki();
		freezer.transformar();
		ki = ki - freezer.ki();
		Assert.assertEquals("No paso: el ki se redujo", 50, ki);
	}
	
	@Test
	public void testAtacarReduceLaVidaDelEnemigo(){
		Freezer freezer = new Freezer();
		freezer.aumentarKi();
		freezer.aumentarKi();
		Gohan gohan = new Gohan();
		float danio = freezer.obtenerPoderDePelea();
		int vida = gohan.obtenerVida();
		freezer.atacar(gohan);
		vida = vida - gohan.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)danio, vida);
	}
	
	@Test
	public void testAtacarHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Freezer freezer = new Freezer();
		MajinBoo majin = new MajinBoo();
		float danio = freezer.obtenerPoderDePelea();
		int vida = majin.obtenerVida();
		freezer.atacar(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)(danio * 0.8), vida);
	}
	
	@Test(expected = KiInsuficiente.class)
	public void testLanzarHabilidadEspecialLanzaExcepcionSiNoSeTieneElKiSuficiente(){
		Freezer freezer = new Freezer();
		Gohan gohan = new Gohan();
		freezer.lanzarHabilidadEspecial(gohan);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceLaVidaDelEnemigo(){
		Freezer freezer = new Freezer();
		Gohan gohan = new Gohan();
		int vida = gohan.obtenerVida();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.lanzarHabilidadEspecial(gohan);
		vida = vida - gohan.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 30, vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceElKi(){
		Freezer freezer = new Freezer();
		Gohan gohan = new Gohan();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		int ki = freezer.ki();
		freezer.lanzarHabilidadEspecial(gohan);
		ki = ki - gohan.ki();
		Assert.assertEquals("No paso: no se redujo el ki", 20, ki);
	}
	
	@Test
	public void testLanzarHabilidadEspecialHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Freezer freezer = new Freezer();
		MajinBoo majin = new MajinBoo();
		int vida = majin.obtenerVida();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.aumentarKi();
		freezer.lanzarHabilidadEspecial(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 24, vida);
	}
	
	@Test
	public void testConsumirEsferaDelDragonAumentaElDanioDeAtaque(){
		Freezer freezer = new Freezer();
		EsferaDragon esfera = new EsferaDragon();
		freezer.consumir(esfera);
		float danio = 25;
		Assert.assertEquals("No paso: no aumento el danio de ataque", danio, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testPasarDeTurnoNoReduceElEfectoDeLaEsferaDelDragon(){
		Freezer freezer = new Freezer();
		EsferaDragon esfera = new EsferaDragon();
		freezer.consumir(esfera);
		freezer.pasarTurno();
		freezer.pasarTurno();
		float danio = 25;
		Assert.assertEquals("No paso: se termino el efecto al pasar de turno", danio, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarNoReduceElEfectoDeLaEsferaDelDragonTrasUnUso(){
		Freezer freezer = new Freezer();
		EsferaDragon esfera = new EsferaDragon();
		freezer.consumir(esfera);
		Gohan gohan = new Gohan();
		freezer.atacar(gohan);
		float danio = 25;
		Assert.assertEquals("No paso: se termino el efecto con un solo ataque", danio, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarReduceElEfectoDeLaEsferaDelDragonTrasDosUsos(){
		Freezer freezer = new Freezer();
		EsferaDragon esfera = new EsferaDragon();
		freezer.consumir(esfera);
		Gohan gohan = new Gohan();
		freezer.atacar(gohan);
		freezer.atacar(gohan);
		float danio = 20;
		Assert.assertEquals("No paso: no se termino el efecto tras dos ataques", danio, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testLanzarHabilidadNoReduceElEfectoDeLaEsferaDelDragonTrasUnUso(){
		Freezer freezer = new Freezer();
		EsferaDragon esfera = new EsferaDragon();
		freezer.consumir(esfera);
		for(int i = 0; i < 10; i++)
			freezer.aumentarKi();
		Gohan gohan = new Gohan();
		freezer.lanzarHabilidadEspecial(gohan);
		float danio = 25;
		Assert.assertEquals("No paso: se termino el efecto con un solo ataque", danio, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testLanzarHabilidadReduceElEfectoDeLaEsferaDelDragonTrasDosUsos(){
		Freezer freezer = new Freezer();
		EsferaDragon esfera = new EsferaDragon();
		freezer.consumir(esfera);
		Gohan gohan = new Gohan();
		for(int i = 0; i < 10; i++)
			freezer.aumentarKi();
		freezer.lanzarHabilidadEspecial(gohan);
		freezer.lanzarHabilidadEspecial(gohan);
		float danio = 20;
		Assert.assertEquals("No paso: no se termino el efecto tras dos ataques", danio, freezer.obtenerPoderDePelea());
	}
	
	@Test
	public void testConsumirSemillaErmitanioAumentaLaVidaEnCien(){
		Freezer freezer = new Freezer();
		freezer.reducirVida(200);
		int vida = freezer.obtenerVida();
		SemillaErmitanio semilla = new SemillaErmitanio();
		freezer.consumir(semilla);
		vida = freezer.obtenerVida() - vida;
		Assert.assertEquals("No paso: no aumento en 100 la vida", 100, vida);
	}
	
	@Test
	public void testConsumirNubeVoladoraAumentaLaVelocidadAlDoble(){
		Freezer freezer = new Freezer();
		int velocidad = freezer.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		freezer.consumir(nube);
		velocidad = freezer.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: no aumento al doble la velocidad", 2, velocidad);
	}
	
	@Test
	public void testPasarUnTurnoNoEliminaElEfectoDeLaNubeVoladora(){
		Freezer freezer = new Freezer();
		int velocidad = freezer.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		freezer.consumir(nube);
		freezer.pasarTurno();
		velocidad = freezer.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: se termino el efecto tras un turno", 2, velocidad);
	}
	
	@Test
	public void testPasarDosTurnoEliminaElEfectoDeLaNubeVoladora(){
		Freezer freezer = new Freezer();
		int velocidad = freezer.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		freezer.consumir(nube);
		freezer.pasarTurno();
		freezer.pasarTurno();
		velocidad = freezer.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: no se termino el efecto tras dos turnos", 1, velocidad);
	}
	
	@Test
	public void testAtacarNoReduceElEfectoDeLaNubeVoladora(){
		Freezer freezer = new Freezer();
		int velocidad = freezer.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		freezer.consumir(nube);
		Gohan gohan = new Gohan();
		freezer.atacar(gohan);
		freezer.atacar(gohan);
		velocidad = freezer.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: atacar elimino el efecto", 2, velocidad);
	}
}
