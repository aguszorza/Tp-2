package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.FabricaDeModos;

public class Gohan extends Personaje {
		
	public Gohan(){
		super(300, "Gohan", new FabricaDeModos().gohanNormal());
	}
	
	public void SuperSaiyajin(){
		Modo SuperSaiyajin1 = new FabricaDeModos().gohanSuperSaiyajin();
		this.transformar(SuperSaiyajin1, 10);
	}
	
	//Agregar lo de la vida
	/*
	public void SuperSaiyajin2(){
		Modo SuperSaiyajin = new FabricaDeModos().gohanSuperSaiyajin2();
		// falta la otra verificacion
		this.transformar(SuperSaiyajin, 50);
	}*/	
}
