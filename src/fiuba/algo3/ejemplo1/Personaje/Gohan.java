package fiuba.algo3.ejemplo1.Personaje;

public class Gohan extends Personaje {

	static int PODER = 15;
	static int DISTANCIA = 2;
	static int VELOCIDAD = 2;
	
	
	public Gohan(){
		super(300, "Gohan", new Modo(PODER, DISTANCIA, VELOCIDAD));
	}
	
	public void SuperSaiyajin1(){
		Modo SuperSaiyajin1 = new Modo(30, 2, 2);
		this.transformar(SuperSaiyajin1, 10);
	}
	
	//Agregar lo de la vida
	/*
	public void SuperSaiyajin2(){
		Modo SuperSaiyajin = new Modo(100, 4, 3);
		// falta la otra verificacion
		this.transformar(SuperSaiyajin, 50);
	}*/	
}
