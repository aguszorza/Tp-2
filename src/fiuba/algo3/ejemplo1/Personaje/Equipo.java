package fiuba.algo3.ejemplo1.Personaje;

import java.util.ArrayList;
import java.util.Iterator;

public class Equipo {

	ArrayList <Personaje> equipo;
	
	public Equipo(){
		this.equipo = new ArrayList <Personaje>();
	}
	
	public void add(Personaje personaje){
		this.equipo.add(personaje);
	}
	
	public Iterator <Personaje> iterator(){
		return this.equipo.iterator();
	}
	
}
