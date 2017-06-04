package fiuba.algo3.ejemplo1.Personaje;

public class Freezer extends Personaje{

	static int PODER = 20;
	static int DISTANCIA = 2;
	static int VELOCIDAD = 4;
	
	
	public Freezer(){
		super(400, "Freezer", new Modo(PODER, DISTANCIA, VELOCIDAD));
	}
	
	public void segundaForma(){
		Modo segundaForma = new Modo(40, 3, 4);
		this.transformar(segundaForma, 20);
	}
	
	public void definitivo(){
		Modo definitivo = new Modo(50, 3, 6);
		this.transformar(definitivo, 50);
	}
}
