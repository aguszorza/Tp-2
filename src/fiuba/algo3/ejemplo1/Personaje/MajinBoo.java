package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.ConvierteteEnChocolate;
import fiuba.algo3.ejemplo1.ModosDePelea.FabricaDeModos;

public class MajinBoo extends Personaje {
	
	public MajinBoo(){
		super(300, "Majin Boo", new FabricaDeModos().majinBooNormal());
		this.habilidad = new ConvierteteEnChocolate(this);
	}
}
