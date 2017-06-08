package fiuba.algo3.ejemplo1.Personaje;

public class Gohan extends Personaje {
		
	public Gohan(){
		super(300, "Gohan", new FabricaDeModos().gohanNormal());
	}
	
	public void SuperSaiyajin(){
		this.transformar(new FabricaDeModos().gohanSuperSaiyajin(this.modoDePelea));
	}
	
	//Agregar lo de la vida
	/*
	public void SuperSaiyajin2(){
		Modo SuperSaiyajin = new FabricaDeModos().gohanSuperSaiyajin2();
		// falta la otra verificacion
		this.transformar(SuperSaiyajin);
	}*/	
}
