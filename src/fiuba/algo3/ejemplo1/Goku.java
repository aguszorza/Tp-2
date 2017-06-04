package fiuba.algo3.ejemplo1;

public class Goku extends Personaje {

	static int VIDA = 20;
	static int DISTANCIA = 20;
	static int VELOCIDAD = 20;
	
	
	public Goku(){
		super(500, "Goku", new Modo(VIDA, DISTANCIA, VELOCIDAD));
	}
	
	public void kaioKen(){
		Modo kaioKen = new Modo(40, 4, 3);
		this.transformar(kaioKen, 20);
	}
	
	public void SuperSaiyajin(){
		Modo SuperSaiyajin = new Modo(60, 4, 5);
		this.transformar(SuperSaiyajin, 50);
	}	
}
