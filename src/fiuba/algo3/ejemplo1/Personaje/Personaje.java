package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.HabilidadesEspeciales.HabilidadEspecial;
import fiuba.algo3.ejemplo1.ModosDePelea.Modo;
import fiuba.algo3.ejemplo1.ModosDePelea.ModoChocolate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.function.Function;

public class Personaje {
	
	private static final int TURNOS_CHOCOLATE = 3;

	protected int vidaActual;
	protected int vidaMaxima;
	protected String nombre;
	protected int ki;
	protected Modo modoDePelea;
	protected HabilidadEspecial habilidad;
	protected Equipo aliados;
	private Hashtable <String, Consumible> consumiblesActivos;

	public Personaje(int vida, String nombre, Modo modo){
		this.vidaActual = vida;
		this.vidaMaxima = vida;
		this.nombre = nombre;
		this.ki = 0;
		this.modoDePelea = modo;
        this.consumiblesActivos = new  Hashtable <String, Consumible>();
	}
	
	public void agregarAliados(Equipo aliados){
		this.aliados = aliados;
	}
	
	public Equipo obtenerAliados(){
		return this.aliados;
	}
	
	public void aumentarKi(){
		this.ki = this.ki + this.modoDePelea.aumentarKi();
	}
	
	public void reducirKi(int costoKi){
		this.ki = this.ki - costoKi;
	}
	
	public void aumentarVida(int cantidad){
		if(this.vidaActual + cantidad > this.vidaMaxima){
			this.vidaActual = this.vidaMaxima;
		}
		else{
			this.vidaActual = this.vidaActual + cantidad;
		}
	}
	//ver que hacer cuando llega a cero
	public void reducirVida(int cantidad){
		this.vidaActual = this.vidaActual - cantidad;
	}
	
	public int ki(){
		return this.ki;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int obtenerVida(){
		return this.vidaActual;
	}
	
	public int obtenerPorcentajeDeVida(){
		return this.vidaActual * 100/this.vidaMaxima;
	}
	
	public float obtenerPoderDePelea(){
		return this.modoDePelea.obtenerPoderDePelea();
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.modoDePelea.obtenerDistanciaDeAtaque();
	}
	
	public int obtenerVelocidad(){
		return this.modoDePelea.obtenerVelocidad();
	}
	
	public void transformar(){
		Modo modoNuevo = this.modoDePelea.transformar(this);
		this.modoDePelea = modoNuevo;
		this.ki = this.ki - modoNuevo.obtenerCostoDeKi();
	}
	
	/*public void validarTransformacion(Modo modoNuevo){
		System.out.println("Mal");
		System.out.println(modoNuevo.getClass());
	}*/
	
	public void transformarEnChocolate(){
		this.modoDePelea = new ModoChocolate (this.modoDePelea, TURNOS_CHOCOLATE );
	}

	// recordar recuperar modo de pelea todos los turnos para los guerreros Z
	// crear excepcion para cuando se pida obtener ataque y esas cosas
	public void recuperarModoDePelea(){
		this.modoDePelea = this.modoDePelea.recuperarModoDePelea();
	}

	public void pasarTurno(){
		Function <Consumible, Void> funcion;
		funcion = (Consumible consumible) -> {
		consumible.pasarTurno();
		return null;};
		actualizarConsumibles(funcion);
		this.modoDePelea.pasarTurno();
	}
	
	public void atacar(Personaje enemigo){
		float danio = this.obtenerDanioDeAtaque(enemigo);
		enemigo.reducirVida((int)danio);
		Function <Consumible, Void> funcion;
		funcion = (Consumible consumible) -> {
		consumible.atacar();
		return null;};
		actualizarConsumibles(funcion);
	}
	
	public float obtenerDanioDeAtaque(Personaje enemigo){
		return this.modoDePelea.obtenerDanioDeAtaque(enemigo);
	}
	
	public void lanzarHabilidadEspecial(Personaje enemigo){
		float danio = this.habilidad.lanzarHabilidad(enemigo);
		enemigo.reducirVida((int)danio);
		Function <Consumible, Void> funcion;
		funcion = (Consumible consumible) -> {
		consumible.atacar();
		return null;};
		actualizarConsumibles(funcion);
	}

	public void consumir(Consumible consumible) {
		this.consumiblesActivos.put(consumible.obtenerNombre(), consumible);
		consumible.afectar(this);
		consumible.afectar(modoDePelea);
	}

	public void actualizarConsumibles(Function <Consumible, Void> funcion) {
		Iterator <Consumible> iterador = this.consumiblesActivos.values().iterator();
		// Uso el Consumible y Guardo los caducados.
		while(iterador.hasNext()){
			Consumible consumible = iterador.next();
			funcion.apply(consumible);
			//consumible.pasarTurno();
			if(consumible.caducoEfecto()){
				consumible.desafectar(this);
				consumible.desafectar(this.modoDePelea);
				iterador.remove();
			}
		}
		/*for(int i = 0; i <= this.consumiblesActivos.size(); i++) {
			Consumible consumible = this.consumiblesActivos.get(i);
			consumible.usarConsumible();
			if( consumible.caducoEfecto() ) {
				consumible.desafectar(this);
				consumible.desafectar(this.modoDePelea);
				consumiblesCaducados.add(consumible);
			}
		}
		// Elimino de los Activos los caducados.
		for(int i = 0; i <= consumiblesCaducados.size(); i++) {
			this.consumiblesActivos.remove(consumiblesCaducados.get(i));
		}*/
	}
}
