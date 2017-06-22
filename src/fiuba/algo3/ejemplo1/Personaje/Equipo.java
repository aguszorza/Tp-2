package fiuba.algo3.ejemplo1.Personaje;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;

public class Equipo {

	private ArrayList <Personaje> equipo;
	private int cantidadEsferas;
	
	public Equipo(){
		this.equipo = new ArrayList <Personaje>();
		this.cantidadEsferas = 0;
	}
	
	public void add(Personaje personaje){
		this.equipo.add(personaje);
	}
	
	public Iterator <Personaje> iterator(){
		return this.equipo.iterator();
	}
	
	public void consumir(Consumible consumible){
		this.cantidadEsferas += consumible.afectar(this);
	}
	
	public int cantidadEsferas(){
		return this.cantidadEsferas;
	}
}
