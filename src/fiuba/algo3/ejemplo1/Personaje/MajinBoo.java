package fiuba.algo3.ejemplo1.Personaje;

public class MajinBoo extends Personaje {
	
	public MajinBoo(){
		super(300, "Majin Boo", new FabricaDeModos().majinBooNormal());
	}
	
	public void BooMalo(){
		this.transformar(new FabricaDeModos().majinBooMalo(this.modoDePelea));
	}
	
	public void BooOriginal(){
		this.transformar(new FabricaDeModos().majinBooOriginal(this.modoDePelea));
	}	
}
