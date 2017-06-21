package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;
import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
import fiuba.algo3.ejemplo1.Excepciones.KiInsuficiente;
import fiuba.algo3.ejemplo1.Excepciones.PersonajeInutilizado;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
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
	
	@Test (expected = KiInsuficiente.class)
	public void testLanzarHabilidadEspecialLanzaExcepcionSiNoSeTieneElKiSuficiente(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		majin.lanzarHabilidadEspecial(goku);
		Assert.fail("No levanto excepcion");
	}
	
	@Test
	public void testLanzarHabilidadEspecialNoPermiteQueElEnemigoAumenteElKi(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		goku.aumentarKi();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		int ki = goku.ki();
		goku.aumentarKi();
		ki = ki - goku.ki();
		Assert.assertEquals("No paso: aumento el ki", 0, ki);
	}
	
	@Test (expected = PersonajeInutilizado.class)
	public void testAtacarLevantaExcepcionSiElPersonajeFueConvertidoEnChocolate(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.atacar(majin);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = PersonajeInutilizado.class)
	public void testLanzarHabilidadLevantaExcepcionSiElPersonajeFueConvertidoEnChocolate(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
			goku.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.lanzarHabilidadEspecial(majin);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = PersonajeInutilizado.class)
	public void testObtenerVelocidadLevantaExcepcionSiElPersonajeFueConvertidoEnChocolate(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.obtenerVelocidad();
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = PersonajeInutilizado.class)
	public void testObtenerDistanciaDeAtaqueLevantaExcepcionSiElPersonajeFueConvertidoEnChocolate(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.obtenerDistanciaDeAtaque();
		Assert.fail("No levanto excepcion");
	}
		

	@Test (expected = PersonajeInutilizado.class)
	public void testObtenerDanioDeAtaqueLevantaExcepcionSiElPersonajeFueConvertidoEnChocolate(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.obtenerDanioDeAtaque(majin);
		Assert.fail("No levanto excepcion");
	}
	
	@Test (expected = PersonajeInutilizado.class)
	public void testRecuperarModoDePeleaNoCambiaElModoDePeleaSiNoPasaronTresTurnos(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		//goku.recuperarModoDePelea();
		goku.atacar(majin);
		Assert.fail("No levanto excepcion");
	}

	@Test
	public void testRecuperarModoDePeleaCambiaElModoDePeleaSiPasaronTresTurnos(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.pasarTurno();
		goku.pasarTurno();
		goku.pasarTurno();
		//goku.recuperarModoDePelea();
		int vida = majin.obtenerVida();
		goku.atacar(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no disminuyo la vida del enemigo", 16, vida);
	}
	
	@Test
	public void testAumentarKiAumentaElKiTrasRecuperarElModoDePelea(){
		MajinBoo majin = new MajinBoo();
		Goku goku = new Goku();
		for (int i = 0; i < 6; i++){
			majin.aumentarKi();
		}
		majin.lanzarHabilidadEspecial(goku);
		goku.pasarTurno();
		goku.pasarTurno();
		goku.pasarTurno();
		//goku.recuperarModoDePelea();
		int ki = goku.ki();
		goku.aumentarKi();
		ki = goku.ki() - ki;
		Assert.assertEquals("No paso: no aumento en 5 el ki", 5, ki);
	}
	
	@Test
	public void testConsumirEsferaDelDragonAumentaElDanioDeAtaque(){
		MajinBoo majin = new MajinBoo();
		EsferaDragon esfera = new EsferaDragon();
		majin.consumir(esfera);
		float danio = (float)37.5;
		Assert.assertEquals("No paso: no aumento el danio de ataque", danio, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testPasarDeTurnoNoReduceElEfectoDeLaEsferaDelDragon(){
		MajinBoo majin = new MajinBoo();
		EsferaDragon esfera = new EsferaDragon();
		majin.consumir(esfera);
		majin.pasarTurno();
		majin.pasarTurno();
		float danio = (float)37.5;
		Assert.assertEquals("No paso: se termino el efecto al pasar de turno", danio, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarNoReduceElEfectoDeLaEsferaDelDragonTrasUnUso(){
		MajinBoo majin = new MajinBoo();
		EsferaDragon esfera = new EsferaDragon();
		majin.consumir(esfera);
		Gohan gohan = new Gohan();
		majin.atacar(gohan);
		float danio = (float)37.5;
		Assert.assertEquals("No paso: se termino el efecto con un solo ataque", danio, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarReduceElEfectoDeLaEsferaDelDragonTrasDosUsos(){
		MajinBoo majin = new MajinBoo();
		EsferaDragon esfera = new EsferaDragon();
		majin.consumir(esfera);
		Gohan gohan = new Gohan();
		majin.atacar(gohan);
		majin.atacar(gohan);
		float danio = 30;
		Assert.assertEquals("No paso: no se termino el efecto tras dos ataques", danio, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testLanzarHabilidadNoReduceElEfectoDeLaEsferaDelDragonTrasUnUso(){
		MajinBoo majin = new MajinBoo();
		EsferaDragon esfera = new EsferaDragon();
		majin.consumir(esfera);
		for(int i = 0; i < 10; i++)
			majin.aumentarKi();
		Gohan gohan = new Gohan();
		majin.lanzarHabilidadEspecial(gohan);
		float danio = (float)37.5;
		Assert.assertEquals("No paso: se termino el efecto con un solo ataque", danio, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testLanzarHabilidadReduceElEfectoDeLaEsferaDelDragonTrasDosUsos(){
		MajinBoo majin = new MajinBoo();
		EsferaDragon esfera = new EsferaDragon();
		majin.consumir(esfera);
		Gohan gohan = new Gohan();
		for(int i = 0; i < 12; i++)
			majin.aumentarKi();
		majin.lanzarHabilidadEspecial(gohan);
		majin.lanzarHabilidadEspecial(gohan);
		float danio = 30;
		Assert.assertEquals("No paso: no se termino el efecto tras dos ataques", danio, majin.obtenerPoderDePelea());
	}
	
	@Test
	public void testConsumirSemillaErmitanioAumentaLaVidaEnCien(){
		MajinBoo majin = new MajinBoo();
		majin.reducirVida(200);
		int vida = majin.obtenerVida();
		SemillaErmitanio semilla = new SemillaErmitanio();
		majin.consumir(semilla);
		vida = majin.obtenerVida() - vida;
		Assert.assertEquals("No paso: no aumento en 100 la vida", 100, vida);
	}
	
	@Test
	public void testConsumirNubeVoladoraAumentaLaVelocidadAlDoble(){
		MajinBoo majin = new MajinBoo();
		int velocidad = majin.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		majin.consumir(nube);
		velocidad = majin.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: no aumento al doble la velocidad", 2, velocidad);
	}
	
	@Test
	public void testPasarUnTurnoNoEliminaElEfectoDeLaNubeVoladora(){
		MajinBoo majin = new MajinBoo();
		int velocidad = majin.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		majin.consumir(nube);
		majin.pasarTurno();
		velocidad = majin.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: se termino el efecto tras un turno", 2, velocidad);
	}
	
	@Test
	public void testPasarDosTurnoEliminaElEfectoDeLaNubeVoladora(){
		MajinBoo majin = new MajinBoo();
		int velocidad = majin.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		majin.consumir(nube);
		majin.pasarTurno();
		majin.pasarTurno();
		velocidad = majin.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: no se termino el efecto tras dos turnos", 1, velocidad);
	}
	
	@Test
	public void testAtacarNoReduceElEfectoDeLaNubeVoladora(){
		MajinBoo majin = new MajinBoo();
		int velocidad = majin.obtenerVelocidad();
		NubeVoladora nube = new NubeVoladora();
		majin.consumir(nube);
		Gohan gohan = new Gohan();
		majin.atacar(gohan);
		majin.atacar(gohan);
		velocidad = majin.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: atacar elimino el efecto", 2, velocidad);
	}
}
