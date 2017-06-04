package fiuba.algo3.ejemplo1;

public class Personaje {

	int vida;
	String nombre;
	int ki;
	Modo modoDePelea;
	HabilidadEspecial habilidad;

	public Personaje(int vida, String nombre, Modo modo){
		this.vida = vida;
		this.nombre = nombre;
		this.ki = 0;
		this.modoDePelea = modo;
	}
	
	public void aumentarKi(){
		this.ki = this.ki + 5;
	}
	
	public void reducirKi(int costoKi){
		this.ki = this.ki - costoKi;
	}
	
	public void aumentarVida(int cantidad){
		this.ki = this.vida + cantidad;
	}
	
	public void reducirVida(int cantidad){
		this.ki = this.ki - cantidad;
	}
	
	public int ki(){
		return this.ki;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int obtenerVida(){
		return this.vida;
	}
	
	public int obtenerPoderDePelea(){
		return this.modoDePelea.obtenerPoderDePelea();
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.modoDePelea.obtenerDistanciaDeAtaque();
	}
	
	public int obtenerVelocidad(){
		return this.modoDePelea.obtenerVelocidad();
	}
	
	public void transformar(Modo modo, int costoKi){
		if (this.ki() < costoKi){
			//levantar excepcion
		}
		this.modoDePelea = modo;
		this.ki = this.ki - costoKi;
	}
}
