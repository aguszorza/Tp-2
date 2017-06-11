package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.Makankosappo;

public class Piccolo extends Personaje{

	public Piccolo(){
		super(500, "Piccolo", new FabricaDeModos().piccoloNormal());
		this.habilidad = new Makankosappo (this);
	}
	
	public void fortalecido(){
		this.transformar(new FabricaDeModos().piccoloFortalecido(this.modoDePelea));
	}
	
	public void protector(Gohan gohan){
		if (gohan.obtenerPorcentajeDeVida() >= 20){
			//excepcion
		}
		this.transformar(new FabricaDeModos().piccoloProtector());
	}
}
