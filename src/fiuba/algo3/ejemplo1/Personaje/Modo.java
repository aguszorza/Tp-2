package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;

import java.util.ArrayList;


public class Modo {

	private int poderDePeleaOriginal;
	private int distanciaDeAtaqueOriginal;
	private int velocidadOriginal;
	private int costoDeKi;
	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidad;

	//Habria que ver si para los distintos modos creamos subclases o
	//lo hacemos a mano como esta hecho ahora en cada personaje 
	public Modo(int poder, int distancia, int velocidad, int costoDeKi){
		this.poderDePelea = this.poderDePeleaOriginal = poder;
		this.distanciaDeAtaque = this.distanciaDeAtaqueOriginal = distancia;
		this.velocidad = this.velocidadOriginal = velocidad;
		this.costoDeKi = costoDeKi;
	}
	
	public int obtenerCostoDeKi(){
		return this.costoDeKi;
	}

	public int obtenerPoderDePelea(){
		return this.poderDePelea;
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.distanciaDeAtaque;
	}
	
	public int obtenerVelocidad(){
		return this.velocidad;
	}

	public void incrementarPoderPelea(int porcentaje) {
		this.poderDePelea *= (int)(porcentaje/100.0);
	}

	public void actualizarPoderPeleaOriginal() {
		this.poderDePelea = this.poderDePeleaOriginal;
	}

	public void incrementarVelocidad(int porcentaje) {
		this.velocidad *= (int)(porcentaje/100.0);
	}

	public void actualizarVelocidadOriginal() {
		this.velocidad = this.velocidadOriginal;
	}
}
