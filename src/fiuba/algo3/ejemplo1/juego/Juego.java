package fiuba.algo3.ejemplo1.juego;

import java.util.ArrayList;
import java.util.Hashtable;

import fiuba.algo3.ejemplo1.Personaje.Cell;
import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Gohan;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.Personaje.Piccolo;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;


public class Juego {
	
	String IMAGEN_GUERREROS = "file:src/fiuba/algo3/ImagenesMenu/finJuegoGuerreros.png";
	String IMAGEN_ENEMIGOS = "file:src/fiuba/algo3/ImagenesMenu/finJuegoEnemigos.png";
	
	public static final int TAMANIO_TABLERO = 9;
	private Jugador guerreroZ;
	private Jugador enemigoTierra;
	private Tablero tablero;
	
	
	public Juego(){
		this.tablero = new Tablero(TAMANIO_TABLERO);
		Hashtable <Personaje, Celda> guerrerosZ = inicializarGuerrerosZ();
		Hashtable <Personaje, Celda> enemigos = inicializarEnemigosDeLaTierra();
		this.guerreroZ = new Jugador(guerrerosZ, enemigos, tablero, "Guerreros Z");
		this.guerreroZ.guardarImagen(IMAGEN_GUERREROS);
		this.enemigoTierra = new Jugador(enemigos, guerrerosZ, tablero, "Enemigos de la Tierra");
		this.enemigoTierra.guardarImagen(IMAGEN_ENEMIGOS);
	}
	
	private Hashtable <Personaje, Celda> inicializarGuerrerosZ(){
		Hashtable <Personaje, Celda> personajes = new Hashtable <Personaje, Celda>();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Equipo equipo = new Equipo();
		equipo.add(goku);
		equipo.add(gohan);
		equipo.add(piccolo);
		goku.agregarAliados(equipo);
		gohan.agregarAliados(equipo);
		piccolo.agregarAliados(equipo);
		Celda celdaPiccolo = this.tablero.obtenerCelda(1, 9);
		Celda celdaGoku = this.tablero.obtenerCelda(1, 5);
		Celda celdaGohan = this.tablero.obtenerCelda(1,1);
		this.tablero.agregarPersonaje(celdaGoku, goku);
		this.tablero.agregarPersonaje(celdaGohan, gohan);
		this.tablero.agregarPersonaje(celdaPiccolo, piccolo);
		personajes.put(goku, celdaGoku);
		personajes.put(gohan, celdaGohan);
		personajes.put(piccolo, celdaPiccolo);
		return personajes;
	}

	private Hashtable <Personaje, Celda> inicializarEnemigosDeLaTierra(){
		Hashtable <Personaje, Celda> personajes = new Hashtable <Personaje, Celda>();
		Freezer freezer = new Freezer();
		MajinBoo boo = new MajinBoo();
		Cell cell = new Cell();
		Equipo equipo = new Equipo();
		equipo.add(freezer);
		equipo.add(cell);
		equipo.add(boo);
		freezer.agregarAliados(equipo);
		cell.agregarAliados(equipo);
		boo.agregarAliados(equipo);
		Celda celdaCell = this.tablero.obtenerCelda(9,1);
		Celda celdaFreezer = this.tablero.obtenerCelda(9,5);
		Celda celdaBoo = this.tablero.obtenerCelda(9,9);
		this.tablero.agregarPersonaje(celdaFreezer, freezer);
		this.tablero.agregarPersonaje(celdaBoo, boo);
		this.tablero.agregarPersonaje(celdaCell, cell);
		personajes.put(freezer, celdaFreezer);
		personajes.put(boo, celdaBoo);
		personajes.put(cell, celdaCell);
		return personajes;
	}
	
	/*public void jugar(){
		//ArrayList <Jugador> jugadores = new ArrayList <Jugador>();
		//jugadores.add(this.guerreroZ);
		//jugadores.add(this.enemigoTierra);
		//implementar turnos random
		Jugador primero = this.guerreroZ;
		Jugador segundo = this.enemigoTierra;
		while(this.guerreroZ.sigueVivo() && this.enemigoTierra.sigueVivo()){
			primero.jugar();
			segundo.jugar();
		}
	}*/
	
	public Tablero obtenerTablero(){
		return this.tablero;
	}
	
	public Jugador obtenerGuerrerosZ(){
		return this.guerreroZ;
	}
	
	public Jugador obtenerEnemigos(){
		return this.enemigoTierra;
	}
}