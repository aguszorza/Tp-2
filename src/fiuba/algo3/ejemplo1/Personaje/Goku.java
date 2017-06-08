package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Kamehameha;
import fiuba.algo3.ejemplo1.Consumibles.FabricaDeModos;

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
		Modo kaioKen =  new FabricaDeModos().gokuKaioKen();
		this.transformar(kaioKen, 20);
	}
	
	public void SuperSaiyajin(){
		Modo SuperSaiyajin = new FabricaDeModos().gokuSuperSaiyajin();
		this.transformar(SuperSaiyajin, 50);
	}	
}
