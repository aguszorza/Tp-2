package fiuba.algo3.ejemplo1.Personaje;

public class Cell extends Personaje{
	
	private int cantidadAbsorciones;

	public Cell(){
		super(500, "Cell", new FabricaDeModos().cellNormal());
		this.cantidadAbsorciones = 0;
	}
	
	public void semiPerfecto(){
		if (this.cantidadAbsorciones < 4){
			throw new AbsorcionesInsuficientes();
		}
		this.transformar(new FabricaDeModos().cellSemiPerfecto());
	}
	
	public void Perfecto(){
		if (this.cantidadAbsorciones < 8){
			throw new AbsorcionesInsuficientes();
		}
		this.transformar(new FabricaDeModos().cellPerfecto());
	}
	
	public void aumentarAbsorciones(){
		this.cantidadAbsorciones ++;
	}
}
