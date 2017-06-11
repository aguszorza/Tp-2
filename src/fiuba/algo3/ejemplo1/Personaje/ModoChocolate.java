package fiuba.algo3.ejemplo1.Personaje;

public class ModoChocolate extends Modo{

	private int cantidadDeTurnos;
	private Modo modoAnterior;
	
	public ModoChocolate(Modo modoAnterior,int turnos){
		super(0, 0, 0, 0);
		this.modoAnterior = modoAnterior;
		this.cantidadDeTurnos = turnos;
	}
	
	public Modo modoAnterior(){
		return this.modoAnterior;
	}
	
	public int cantidadDeTurnos(){
		return this.cantidadDeTurnos;
	}
	
	public void reducirTurnos(){
		this.cantidadDeTurnos --;
	}
}
