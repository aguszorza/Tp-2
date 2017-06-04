package fiuba.algo3.ejemplo1.Personaje;

public class MajinBoo extends Personaje {

	static int PODER = 30;
	static int DISTANCIA = 2;
	static int VELOCIDAD = 2;
	
	public MajinBoo(){
		super(300, "Majin Boo", new Modo(PODER, DISTANCIA, VELOCIDAD));
	}
	
	public void BooMalo(){
		Modo BooMalo = new Modo(50, 2, 3);
		this.transformar(BooMalo, 20);
	}
	
	public void BooOriginal(){
		Modo BooOriginal = new Modo(60, 3, 4);
		this.transformar(BooOriginal, 50);
	}	
}
