package fiuba.algo3.ejemplo1.Personaje;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.Masenko;


public class Gohan extends Personaje {
	
	ArrayList <Personaje> aliados;
		
	public Gohan(){
		super(300, "Gohan", new FabricaDeModos().gohanNormal());
		this.habilidad = new Masenko(this);
	}
	
	/*public void SuperSaiyajin(){
		this.transformar(new FabricaDeModos().gohanSuperSaiyajin(this.modoDePelea));
	}
	
	//Agregar lo de la vida
	
	public void SuperSaiyajin2( ArrayList <Personaje> personajes){
		Iterator <Personaje> it = personajes.iterator();
		while(it.hasNext()){
			if (it.next().obtenerPorcentajeDeVida() >= 30){
				throw new RequisitosDeTransformacionInsuficientes();
			}
		}
		this.transformar(new FabricaDeModos().gohanSuperSaiyajin2(this.modoDePelea));
	}*/
}
