package fiuba.algo3.ejemplo1.ModosDePelea;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Excepciones.KiInsuficiente;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

import java.util.ArrayList;
import java.util.function.Function;


public class Modo {

	private Ataque ataque;
	private float danioAdicional;
	private int velocidadAdicional;
	//private int poderDePeleaOriginal;
	//private int distanciaDeAtaqueOriginal;
	//private int velocidadOriginal;
	private int costoDeKi;
	//protected int poderDePelea;
	//protected int distanciaDeAtaque;
	protected int velocidad;
	protected int cantidadDeTurnos;
	protected Function <FabricaDeModos, Modo> nuevaTransformacion;

	public Modo(Ataque ataque, int velocidad, int costoDeKi,  Function <FabricaDeModos, Modo> funcion){
		this.ataque = ataque;
		//this.poderDePelea = this.poderDePeleaOriginal = poder;
		//this.distanciaDeAtaque = this.distanciaDeAtaqueOriginal = distancia;
		//this.velocidad = this.velocidadOriginal = velocidad;
		this.velocidad = velocidad;
		this.costoDeKi = costoDeKi;
		this.danioAdicional = this.velocidadAdicional = 1;
		this.nuevaTransformacion = funcion;
		cantidadDeTurnos = 0;
	}
	
	public int aumentarKi(){
		return 5;
	}
	
	public void igualarAdicionales(Modo modo){
		this.incrementarVelocidad(modo.velocidadAdicional());
		this.incrementarPoderPelea(modo.danioAdicional());
	}
	
	public void validarTransformacion(Personaje personaje, int costoKi){
		if(personaje.ki() < costoKi){
			throw new KiInsuficiente();
		}
	}
	
	public Modo transformar(Personaje personaje){
		Modo modoNuevo = this.nuevaTransformacion.apply(new FabricaDeModos());
		modoNuevo.validarTransformacion(personaje, modoNuevo.obtenerCostoDeKi());
		modoNuevo.igualarAdicionales(this);
		return modoNuevo;
	}
	
	public int obtenerCostoDeKi(){
		return this.costoDeKi;
	}

	public float obtenerPoderDePelea(){
		return this.ataque.obtenerDanio() * this.danioAdicional;
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.ataque.obtenerDistanciaDeAtaque();
	}
	
	public int obtenerVelocidad(){
		return this.velocidad * this.velocidadAdicional;
	}
	
	public float obtenerDanioDeAtaque(Personaje enemigo){
		return this.ataque.calcularDanio(enemigo) * this.danioAdicional;
	}

	public void incrementarPoderPelea(float danioAdicional) {
		this.danioAdicional = danioAdicional;
	}

	public void actualizarPoderPeleaOriginal() {
		this.danioAdicional = 1;
	}

	public void incrementarVelocidad(int velocidadAdicional) {
		this.velocidadAdicional = velocidadAdicional;
	}

	public void actualizarVelocidadOriginal() {
		this.velocidadAdicional = 1;
	}
	
	public int velocidadAdicional(){
		return this.velocidadAdicional;
	}
	
	public float danioAdicional(){
		return this.danioAdicional;
	}
	
	public void pasarTurno(){
		this.cantidadDeTurnos++;
	}
	
	public Modo recuperarModoDePelea() {
		return this;
	}
}
