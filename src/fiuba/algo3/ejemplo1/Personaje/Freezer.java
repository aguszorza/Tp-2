package fiuba.algo3.ejemplo1.Personaje;

public class Freezer extends Personaje{

	public Freezer(){
		super(400, "Freezer", new FabricaDeModos().freezerNormal());
	}
	
	public void segundaForma(){
		this.transformar(new FabricaDeModos().freezerSegundaForma(this.modoDePelea));
	}
	
	public void definitivo(){
		this.transformar(new FabricaDeModos().freezerDefinitivo(this.modoDePelea));
	}
}
