package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.RayoMortal;

public class Freezer extends Personaje{

	public Freezer(){
		super(400, "Freezer", new FabricaDeModos().freezerNormal());
		this.habilidad = new RayoMortal(this);
	}
	
	public void segundaForma(){
		this.transformar(new FabricaDeModos().freezerSegundaForma(this.modoDePelea));
	}
	
	public void definitivo(){
		this.transformar(new FabricaDeModos().freezerDefinitivo(this.modoDePelea));
	}
}
