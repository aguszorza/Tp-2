package fiuba.algo3.ejemplo1.juego;

import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Ataque extends Accion{
	
	private int danio;
	private int distanciaDeAtaque;
	
	public Ataque(int danio, int distancia){
		this.danio = danio;
		this.distanciaDeAtaque = distancia;
	}
	
	public int obtenerDanio(){
		return this.danio;
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.distanciaDeAtaque;
	}

	public float calcularDanio(Personaje enemigo){
		float danio = this.obtenerDanio();
		if(enemigo.obtenerPoderDePelea() > danio)
			danio = danio * (float)0.8;
		return danio;
	}
	
}
