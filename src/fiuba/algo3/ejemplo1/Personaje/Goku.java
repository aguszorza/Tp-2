package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Kamehameha;

public class Goku extends Personaje {

	float danioAdicional;
	
	public Goku(){
		super(500, "Goku", new FabricaDeModos().gokuNormal());
		this.danioAdicional = (float)1.2;
		this.habilidad = new Kamehameha(this);
	}
	
	public float obtenerPoderDePelea(){
		if (this.vidaActual < this.vidaMaxima * 30 / 100){
			return super.obtenerPoderDePelea() * this.danioAdicional;
		}
		return super.obtenerPoderDePelea();
	}
	
	public void kaioKen(){
		this.transformar(new FabricaDeModos().gokuKaioKen(this.modoDePelea));
	}
	
	public void SuperSaiyajin(){
		this.transformar(new FabricaDeModos().gokuSuperSaiyajin(this.modoDePelea));
	}	
}
