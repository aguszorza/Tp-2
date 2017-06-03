package fiuba.algo3.ejemplo1;

public class Personaje {

	int vida;
	String nombre;
	int ki;

	public Personaje(int vida, String nombre){
		this.vida = vida;
		this.nombre = nombre;
		this.ki = 0;
	}
	
	public void aumentarKi(){
		this.ki = this.ki + 5;
	}
	
	public void reducirKi(int costoKi){
		this.ki = this.ki - costoKi;
	}
	
	public int ki(){
		return this.ki;
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
