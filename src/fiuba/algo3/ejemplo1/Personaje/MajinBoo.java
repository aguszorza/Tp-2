package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.FabricaDeModos;

public class MajinBoo extends Personaje {

	static int PODER = 30;
	static int DISTANCIA = 2;
	static int VELOCIDAD = 2;
	
	public MajinBoo(){
		super(300, "Majin Boo", new FabricaDeModos().majinBooNormal());
	}
	
	public void BooMalo(){
		Modo BooMalo = new FabricaDeModos().majinBooMalo();
		this.transformar(BooMalo, 20);
	}
	
	public void BooOriginal(){
		Modo BooOriginal = new FabricaDeModos().majinBooOriginal();
		this.transformar(BooOriginal, 50);
	}	
}
