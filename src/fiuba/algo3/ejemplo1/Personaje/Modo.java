package fiuba.algo3.ejemplo1.Personaje;

public class Modo {

	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidad;
	
	public Modo(int poder, int distancia, int velocidad){
		this.poderDePelea = poder;
		this.distanciaDeAtaque = distancia;
		this.velocidad = velocidad;
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
}
