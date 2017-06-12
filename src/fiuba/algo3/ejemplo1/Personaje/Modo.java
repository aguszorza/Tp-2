package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Ataque;
import fiuba.algo3.ejemplo1.Consumibles.Consumible;

import java.util.ArrayList;


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

	public Modo(int poder, int distancia, int velocidad, int costoDeKi){
		this.ataque = new Ataque(poder, distancia);
		//this.poderDePelea = this.poderDePeleaOriginal = poder;
		//this.distanciaDeAtaque = this.distanciaDeAtaqueOriginal = distancia;
		//this.velocidad = this.velocidadOriginal = velocidad;
		this.velocidad = velocidad;
		this.costoDeKi = costoDeKi;
		this.danioAdicional = this.velocidadAdicional = 1;
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
		return this.ataque.atacar(enemigo) * this.danioAdicional;
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
}
