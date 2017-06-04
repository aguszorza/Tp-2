package fiuba.algo3.ejemplo1.Personaje;

public class Goku extends Personaje {

	static int PODER = 20;
	static int DISTANCIA = 2;
	static int VELOCIDAD = 2;
	
	private float danioAdicional;
	
	
	public Goku(){
		super(500, "Goku", new Modo(PODER, DISTANCIA, VELOCIDAD));
		this.danioAdicional = (float)1.2;
	}
	
	public float obtenerPoderDePelea(){
		if (this.vida < 150){
			return this.obtenerPoderDePelea() * this.danioAdicional;
		}
		return this.obtenerPoderDePelea();
	}
	
	public void kaioKen(){
		Modo kaioKen = new Modo(40, 4, 3);
		this.transformar(kaioKen, 20);
	}
	
	public void SuperSaiyajin(){
		Modo SuperSaiyajin = new Modo(60, 4, 5);
		this.transformar(SuperSaiyajin, 50);
	}	
}
