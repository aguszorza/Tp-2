package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.Makankosappo;
import fiuba.algo3.ejemplo1.ModosDePelea.FabricaDeModos;

public class Piccolo extends Personaje{

	public Piccolo(){
		super(500, "Piccolo", new FabricaDeModos().piccoloNormal());
		this.habilidad = new Makankosappo (this);
	}
}
