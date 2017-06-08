package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.FabricaDeModos;

public class Freezer extends Personaje{

	public Freezer(){
		super(400, "Freezer", new FabricaDeModos().freezerNormal());
	}
	
	public void segundaForma(){
		Modo segundaForma = new FabricaDeModos().freezerSegundaForma();
		this.transformar(segundaForma, 20);
	}
	
	public void definitivo(){
		Modo definitivo = new FabricaDeModos().freezerDefinitivo();
		this.transformar(definitivo, 50);
	}
}
