package fiuba.algo3.ejemplo1.juego;

import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;


public class Juego {
	
	public static final int TAMANIO_TABLERO = 10;
	private Jugador guerreroZ;
	private Jugador enemigoTierra;
	private Tablero tablero;
	
	
	public Juego(){
		this.tablero = new Tablero(TAMANIO_TABLERO);
		this.guerreroZ = new Jugador(inicializarGuerrerosZ());
		this.enemigoTierra = new Jugador(inicializarEnemigosDeLaTierra());
	}
	
	private Hashtable <Personaje, Celda> inicializarGuerrerosZ(){
		Hashtable <Personaje, Celda> personajes = new Hashtable <Personaje, Celda>();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Celda celdaGoku = new Celda(1,5);
		Celda celdaGohan = new Celda (1,1);
		this.tablero.agregarPersonaje(celdaGoku, goku);
		this.tablero.agregarPersonaje(celdaGohan, gohan);
		personajes.put(goku, celdaGoku);
		personajes.put(gohan, celdaGohan);
		return personajes;
	}
	
	private Hashtable <Personaje, Celda> inicializarEnemigosDeLaTierra(){
		Hashtable <Personaje, Celda> personajes = new Hashtable <Personaje, Celda>();
		Freezer freezer = new Freezer();
		MajinBoo boo = new MajinBoo();
		Celda celdaFreezer = new Celda(10,5);
		Celda celdaBoo = new Celda(10,10);
		this.tablero.agregarPersonaje(celdaFreezer, freezer);
		this.tablero.agregarPersonaje(celdaBoo, boo);
		personajes.put(freezer, celdaFreezer);
		personajes.put(boo, celdaBoo);
		return personajes;
	}
	
}