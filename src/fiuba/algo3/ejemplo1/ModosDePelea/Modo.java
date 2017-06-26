package fiuba.algo3.ejemplo1.ModosDePelea;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Ataque;

import java.util.function.Function;


public class Modo {

	private Ataque ataque;
	private float danioAdicional;
	private int velocidadAdicional;
	private int costoDeKi;
	protected int velocidad;
	protected int cantidadDeTurnosRestantes;
	protected Function <FabricaDeModos, Modo> nuevaTransformacion;
	protected String direccionImagen;

	public Modo(Ataque ataque, int velocidad, int costoDeKi,  Function <FabricaDeModos, Modo> funcion){
		this.ataque = ataque;
		this.velocidad = velocidad;
		this.costoDeKi = costoDeKi;
		this.danioAdicional = this.velocidadAdicional = 1;
		this.nuevaTransformacion = funcion;
		cantidadDeTurnosRestantes = 0;
	}
	
	public void guardarDireccion(String direccion){
		this.direccionImagen = direccion;
	}
	
	public String obtenerImagen(){
		return this.direccionImagen;
	}
	
	public int aumentarKi(){
		return 5;
	}
	
	public void igualarAdicionales(Modo modo){
		this.incrementarVelocidad(modo.velocidadAdicional());
		this.incrementarPoderPelea(modo.danioAdicional());
	}
	
	public Boolean validarTransformacion(Personaje personaje, int costoKi){
		if(personaje.ki() < costoKi){
			return false;
		}
		return true;
	}
	
	public Modo transformar(Personaje personaje){
		Modo modoNuevo = this.nuevaTransformacion.apply(new FabricaDeModos());
		if (modoNuevo == null || !modoNuevo.validarTransformacion(personaje, modoNuevo.obtenerCostoDeKi())){
			return null;
		}		
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
		return this.calcularDanio(enemigo);
	}
	
	public float calcularDanio(Personaje enemigo){
		float danio = this.obtenerPoderDePelea();
		if(enemigo.obtenerPoderDePelea() > danio)
			danio = danio * (float)0.8;
		return danio;
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
		this.cantidadDeTurnosRestantes --;
	}
	
	public Modo recuperarModoDePelea() {
		return this;
	}
}
