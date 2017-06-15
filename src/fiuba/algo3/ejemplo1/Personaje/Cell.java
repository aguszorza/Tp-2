package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.HabilidadesEspeciales.Absorber;
import fiuba.algo3.ejemplo1.ModosDePelea.FabricaDeModos;

public class Cell extends Personaje{
	
	private int cantidadAbsorciones;

	public Cell(){
		super(500, "Cell", new FabricaDeModos().cellNormal());
		this.cantidadAbsorciones = 0;
		this.habilidad = new Absorber(this);
	}
	
	/*public void semiPerfecto(){
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
	}*/
	
	public void aumentarAbsorciones(){
		this.cantidadAbsorciones ++;
	}
	
	public void disminuirAbsorciones(int cantidad){
		this.cantidadAbsorciones -= cantidad;
	}
	
	public int obtenerAbsorciones(){
		return this.cantidadAbsorciones;
	}
}
