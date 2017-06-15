package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Ataque;

public class ModoChocolate extends Modo{

	private Modo modoAnterior;
	private int turnos;
	
	public ModoChocolate(Modo modoAnterior,int turnos){
		super(new Ataque(0,0), 0, 0, (FabricaDeModos fabrica) -> 
		{return fabrica.transformacionInvalida();});
		this.modoAnterior = modoAnterior;
		this.turnos = turnos;
	}
	
	public Modo recuperarModoDePelea(){
		if(this.turnos > 0){
			return this;
		}
		return this.modoAnterior;
	}
	
	public void pasarTurno(){
		this.cantidadDeTurnos++;
		this.turnos--;		
	}
}
