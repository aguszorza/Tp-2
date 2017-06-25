package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.Masenko;
import fiuba.algo3.ejemplo1.ModosDePelea.FabricaDeModos;


public class Gohan extends Personaje {
		
	public Gohan(){
		super(300, "Gohan", new FabricaDeModos().gohanNormal());
		this.habilidad = new Masenko(this);
	}
}
