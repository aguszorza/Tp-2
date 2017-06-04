package fiuba.algo3.ejemplo1;

import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;

public class Juego {

	private Jugador guerreroZ;
	private Jugador enemigoTierra;
	private Tablero tablero;
	
	public Juego(){
		this.tablero = new Tablero(10);
		this.guerreroZ = new Jugador(inicializarGuerrerosZ(tablero));
		this.enemigoTierra = new Jugador(inicializarEnemigosDeLaTierra(tablero));
	}
	
	private Hashtable <Personaje, Celda> inicializarGuerrerosZ(Tablero tablero){
		Hashtable <Personaje, Celda> personajes = new Hashtable <Personaje, Celda>();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		tablero.agregarPersonaje(1, 5, goku);
		tablero.agregarPersonaje(1, 1, gohan);
		personajes.put(goku, tablero.obtenerCelda(1, 5));
		personajes.put(gohan, tablero.obtenerCelda(1, 1));
		return personajes;
	}
	
	private Hashtable <Personaje, Celda> inicializarEnemigosDeLaTierra(Tablero tablero){
		Hashtable <Personaje, Celda> personajes = new Hashtable <Personaje, Celda>();
		Freezer freezer = new Freezer();
		MajinBoo boo = new MajinBoo();
		tablero.agregarPersonaje(10, 5, freezer);
		tablero.agregarPersonaje(10, 10, boo);
		personajes.put(freezer, tablero.obtenerCelda(10, 5));
		personajes.put(boo, tablero.obtenerCelda(10, 10));
		return personajes;
	}
	
}
