package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Consumibles.EsferaDragon;
import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
import fiuba.algo3.ejemplo1.Personaje.Cell;
import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import junit.framework.Assert;

public class CellTest {

	@Test
	public void testObtenerNombreDevuelveElNombreCorrecto() {
		Cell cell = new Cell();
		Assert.assertEquals("No paso: no devolvio Cell como nombre", "Cell", cell.getNombre());
	}

	@Test
	public void testAumentarKiAumentaEnCincoElKi() {
		Cell cell = new Cell();
		int ki = cell.ki();
		cell.aumentarKi();
		ki = cell.ki() - ki;
		Assert.assertEquals("No paso: no devolvio 5", 5, ki);
	}
	
	@Test
	public void testReducirKiDisminuyeElKiEnElValorPasado() {
		Cell cell = new Cell();
		cell.aumentarKi();
		cell.aumentarKi();
		cell.aumentarKi();
		int ki = cell.ki();
		cell.reducirKi(10);
		ki = ki - cell.ki();
		Assert.assertEquals("No paso: no devolvio 10", 10, ki);
	}
	
	@Test
	public void testReducirVidaDisminuyeLaVidaEnElValorPasado() {
		Cell cell = new Cell();
		int vida = cell.obtenerVida();
		cell.reducirVida(20);
		vida = vida - cell.obtenerVida();
		Assert.assertEquals("No paso: no devolvio 20", 20, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaEnElValorPasadoSiNoSobrepasaLaVidaMaxima() {
		Cell cell = new Cell();
		cell.reducirVida(200);
		int vida = cell.obtenerVida();
		cell.aumentarVida(100);
		vida = cell.obtenerVida() - vida;
		Assert.assertEquals("No paso: no devolvio 100", 100, vida);
	}
	
	@Test
	public void testAumentarVidaAumentaLaVidaHastaLaVidaMaximaSiElAumentoSobrepasaLaVidaMaxima() {
		Cell cell = new Cell();
		cell.reducirVida(30);
		cell.aumentarVida(100);
		Assert.assertEquals("No paso: no devolvio 500", 500, cell.obtenerVida());
	}

	@Test
	public void testObtenerVidaDevuelveLaVidaDelPersonaje() {
		Cell cell = new Cell();
		Assert.assertEquals("No paso: no devolvio 500", 500, cell.obtenerVida());
	}
	
	@Test
	public void testPoderDePeleaDevuelveElPoderDePeleaDelPersonaje() {
		Cell cell = new Cell();
		Assert.assertEquals("No paso: no devolvio 20", (float)20, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testDistanciaDeAtaqueDevuelveLaDistanciaDeAtaqueDelPersonaje() {
		Cell cell = new Cell();
		Assert.assertEquals("No paso: no devolvio 3", 3, cell.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testVelocidadDevuelveLaVelocidadDelPersonaje() {
		Cell cell = new Cell();
		Assert.assertEquals("No paso: no devolvio 2", 2, cell.obtenerVelocidad());
	}
	
	@Test
	public void testTransformarDevuelveFalseSiNoSeTieneAbsorcionesSuficinte(){
		Cell cell = new Cell();
		Assert.assertFalse("No levanto excepcion", cell.transformar());
	}
	
	@Test
	public void testSemiPerfectoCambiaElPoderDePelea(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		for(int i = 0; i < 4; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}
		cell.transformar();
		Assert.assertEquals("No paso: no devolvio 40", (float)40, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testSemiPerfectoCambiaLaDistanciaDeAtaque(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		for(int i = 0; i < 4; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}		
		cell.transformar();
		Assert.assertEquals("No paso: no devolvio 4", 4, cell.obtenerDistanciaDeAtaque());
	}
	
	@Test
	public void testSemiPerfectoCambiaLaVelocidad(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		for(int i = 0; i < 4; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}
		cell.transformar();
		Assert.assertEquals("No paso: no devolvio 3", 3, cell.obtenerVelocidad());
	}
	
	@Test
	public void testSemiPerfectoNoReduceElKi(){
		Cell cell = new Cell();
		cell.aumentarKi();
		Freezer freezer = new Freezer();
		for(int i = 0; i < 4; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}
		cell.transformar();
		Assert.assertEquals("No paso: el ki se redujo", 5, cell.ki());
	}
	
	@Test
	public void testPerfectoDevuelveFalseSiNoSeTieneLasAbsorcionesSuficientes(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		for(int i = 0; i < 4; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}
		cell.transformar();
		Assert.assertFalse("No levanto excepcion",cell.transformar());
	}
	
	@Test
	public void testPerfectoAumentaLosStats(){
		Cell cell = new Cell();
		Boolean estado = true;
		Freezer freezer = new Freezer();
		for(int i = 0; i < 12; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}
		cell.transformar();
		cell.transformar();
		estado = estado && cell.obtenerVelocidad() == 4;
		estado = estado && cell.obtenerDistanciaDeAtaque() == 4;
		estado = estado && cell.obtenerPoderDePelea() == 80;
		Assert.assertTrue("No paso: no se modificaron correctamente los stats", estado);
	}
	
	@Test
	public void testPerfectoNoDisminuyeElKi(){
		Cell cell = new Cell();
		cell.aumentarKi();
		Freezer freezer = new Freezer();
		for(int i = 0; i < 12; i++){
			cell.aumentarKi();
			cell.lanzarHabilidadEspecial(freezer);
		}
		cell.transformar();
		Assert.assertEquals("No paso: el ki se redujo", 5, cell.ki());
	}
	
	@Test
	public void testAtacarReduceLaVidaDelEnemigo(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		float danio = cell.obtenerPoderDePelea();
		int vida = freezer.obtenerVida();
		cell.atacar(freezer);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)danio, vida);
	}
	
	@Test
	public void testAtacarHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Cell cell = new Cell();
		MajinBoo majin = new MajinBoo();
		float danio = cell.obtenerPoderDePelea();
		int vida = majin.obtenerVida();
		cell.atacar(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", (int)(danio * 0.8), vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialDevuelveFalseSiNoSeTieneElKiSuficiente(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		Assert.assertFalse("No levanto excepcion", cell.lanzarHabilidadEspecial(freezer));
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceLaVidaDelEnemigo(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		int vida = freezer.obtenerVida();
		cell.aumentarKi();
		cell.lanzarHabilidadEspecial(freezer);
		vida = vida - freezer.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 20, vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialAumentaLaVidaDeCell(){
		Cell cell = new Cell();
		cell.reducirVida(40);
		Freezer freezer = new Freezer();
		int vida = cell.obtenerVida();
		cell.aumentarKi();
		cell.lanzarHabilidadEspecial(freezer);
		vida = cell.obtenerVida() - vida;
		Assert.assertEquals("No paso: no aumento la vida de Cell", 20, vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialAumentaEnUnoLaCantidadDeAbsorciones(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		int absorciones = cell.obtenerAbsorciones();
		cell.aumentarKi();
		cell.lanzarHabilidadEspecial(freezer);
		absorciones = cell.obtenerAbsorciones() - absorciones;
		Assert.assertEquals("No paso: no aumento la cantidad de absorciones en 1", 1, absorciones);
	}
	
	@Test
	public void testLanzarHabilidadEspecialReduceElKi(){
		Cell cell = new Cell();
		Freezer freezer = new Freezer();
		cell.aumentarKi();
		int ki = cell.ki();
		cell.lanzarHabilidadEspecial(freezer);
		ki = ki - cell.ki();
		Assert.assertEquals("No paso: no se redujo el ki", 5, ki);
	}
	
	@Test
	public void testLanzarHabilidadEspecialHaceMenosDanioSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Cell cell = new Cell();
		MajinBoo majin = new MajinBoo();
		int vida = majin.obtenerVida();
		cell.aumentarKi();
		cell.lanzarHabilidadEspecial(majin);
		vida = vida - majin.obtenerVida();
		Assert.assertEquals("No paso: no se redujo la vida", 16, vida);
	}
	
	@Test
	public void testLanzarHabilidadEspecialCuraMenosVidaSiElPoderDeAtaqueDelEnemigoEsMayor(){
		Cell cell = new Cell();
		cell.reducirVida(50);
		MajinBoo majin = new MajinBoo();
		int vida = cell.obtenerVida();
		cell.aumentarKi();
		cell.lanzarHabilidadEspecial(majin);
		vida = cell.obtenerVida() - vida;
		Assert.assertEquals("No paso: no aumento la vida correctamente", 16, vida);
	}
	
	@Test
	public void testConsumirEsferaDelDragonAumentaElDanioDeAtaque(){
		Cell cell = new Cell();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		EsferaDragon esfera = new EsferaDragon();
		cell.consumir(esfera);
		float danio = 25;
		Assert.assertEquals("No paso: no aumento el danio de ataque", danio, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testPasarDeTurnoNoReduceElEfectoDeLaEsferaDelDragon(){
		Cell cell = new Cell();
		EsferaDragon esfera = new EsferaDragon();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		cell.consumir(esfera);
		cell.pasarTurno();
		cell.pasarTurno();
		float danio = 25;
		Assert.assertEquals("No paso: se termino el efecto al pasar de turno", danio, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarNoReduceElEfectoDeLaEsferaDelDragonTrasUnUso(){
		Cell cell = new Cell();
		EsferaDragon esfera = new EsferaDragon();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		cell.consumir(esfera);
		Gohan gohan = new Gohan();
		cell.atacar(gohan);
		float danio = 25;
		Assert.assertEquals("No paso: se termino el efecto con un solo ataque", danio, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testAtacarReduceElEfectoDeLaEsferaDelDragonTrasDosUsos(){
		Cell cell = new Cell();
		EsferaDragon esfera = new EsferaDragon();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		cell.consumir(esfera);
		Gohan gohan = new Gohan();
		cell.atacar(gohan);
		cell.atacar(gohan);
		float danio = 20;
		Assert.assertEquals("No paso: no se termino el efecto tras dos ataques", danio, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testLanzarHabilidadNoReduceElEfectoDeLaEsferaDelDragonTrasUnUso(){
		Cell cell = new Cell();
		EsferaDragon esfera = new EsferaDragon();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		cell.consumir(esfera);
		for(int i = 0; i < 10; i++)
			cell.aumentarKi();
		Gohan gohan = new Gohan();
		cell.lanzarHabilidadEspecial(gohan);
		float danio = 25;
		Assert.assertEquals("No paso: se termino el efecto con un solo ataque", danio, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testLanzarHabilidadReduceElEfectoDeLaEsferaDelDragonTrasDosUsos(){
		Cell cell = new Cell();
		EsferaDragon esfera = new EsferaDragon();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		cell.consumir(esfera);
		Gohan gohan = new Gohan();
		for(int i = 0; i < 10; i++)
			cell.aumentarKi();
		cell.lanzarHabilidadEspecial(gohan);
		cell.lanzarHabilidadEspecial(gohan);
		float danio = 20;
		Assert.assertEquals("No paso: no se termino el efecto tras dos ataques", danio, cell.obtenerPoderDePelea());
	}
	
	@Test
	public void testConsumirSemillaErmitanioAumentaLaVidaEnCien(){
		Cell cell = new Cell();
		cell.reducirVida(200);
		int vida = cell.obtenerVida();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		SemillaErmitanio semilla = new SemillaErmitanio();
		cell.consumir(semilla);
		vida = cell.obtenerVida() - vida;
		Assert.assertEquals("No paso: no aumento en 100 la vida", 100, vida);
	}
	
	@Test
	public void testConsumirNubeVoladoraAumentaLaVelocidadAlDoble(){
		Cell cell = new Cell();
		int velocidad = cell.obtenerVelocidad();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		NubeVoladora nube = new NubeVoladora();
		cell.consumir(nube);
		velocidad = cell.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: no aumento al doble la velocidad", 2, velocidad);
	}
	
	@Test
	public void testPasarUnTurnoNoEliminaElEfectoDeLaNubeVoladora(){
		Cell cell = new Cell();
		int velocidad = cell.obtenerVelocidad();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		NubeVoladora nube = new NubeVoladora();
		cell.consumir(nube);
		cell.pasarTurno();
		velocidad = cell.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: se termino el efecto tras un turno", 2, velocidad);
	}
	
	@Test
	public void testPasarDosTurnoEliminaElEfectoDeLaNubeVoladora(){
		Cell cell = new Cell();
		int velocidad = cell.obtenerVelocidad();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		NubeVoladora nube = new NubeVoladora();
		cell.consumir(nube);
		cell.pasarTurno();
		cell.pasarTurno();
		velocidad = cell.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: no se termino el efecto tras dos turnos", 1, velocidad);
	}
	
	@Test
	public void testAtacarNoReduceElEfectoDeLaNubeVoladora(){
		Cell cell = new Cell();
		int velocidad = cell.obtenerVelocidad();
		Equipo equipo = new Equipo(); 
		equipo.add(cell);
		cell.agregarAliados(equipo);
		NubeVoladora nube = new NubeVoladora();
		cell.consumir(nube);
		Gohan gohan = new Gohan();
		cell.atacar(gohan);
		cell.atacar(gohan);
		velocidad = cell.obtenerVelocidad()/velocidad;
		Assert.assertEquals("No paso: atacar elimino el efecto", 2, velocidad);
	}
}
