package fiuba.algo3.Vista;

import java.util.Iterator;

import fiuba.algo3.ejemplo1.Excepciones.PosicionFueraDelTablero;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;

public class botonCasilla implements EventHandler<ActionEvent>{
	private Tablero tablero;
	private Celda celda;
	private GridPane grid;
	private Button botonDerecha;
	private Button botonIzquierda;
	private Button botonArriba;
	private Button botonAbajo;
	
	
	public botonCasilla(Tablero tablero, Celda celda, GridPane grid){
		this.tablero = tablero;
		this.celda = celda;
		this.grid = grid;
		this.botonDerecha = new Button("Derecha");
		this.botonIzquierda = new Button("Izquierda");
		this.botonAbajo = new Button("Abajo");
		this.botonArriba = new Button("Arriba");
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.grid.add(botonDerecha, 3, 1);
		this.grid.add(botonIzquierda, 4, 1);
		this.grid.add(botonAbajo, 5, 1);
		this.grid.add(botonArriba, 2, 1);
		this.setearAccionBoton(botonDerecha,1,0);
		this.setearAccionBoton(botonIzquierda,-1,0);
		this.setearAccionBoton(botonArriba,0,-1);
		this.setearAccionBoton(botonAbajo,0,1);
	}
	
	private void limpiarBotones(Button botonDerecha, Button botonIzquierda, Button botonArriba, Button botonAbajo) {
		grid.getChildren().remove(botonDerecha);
		grid.getChildren().remove(botonIzquierda);
		grid.getChildren().remove(botonArriba);
		grid.getChildren().remove(botonAbajo);
		
	}

	void setearAccionBoton(Button boton, int x, int y){
		boton.setOnAction(value->{
			int fila = this.celda.obtenerFila();
			int columna = this.celda.obtenerColumna();
			try{
				Celda celdaFinal = new Celda(fila  + y , columna + x);
				this.tablero.moverPersonaje(this.celda.obtenerPersonaje(), this.celda, celdaFinal);
			}
			catch (PosicionFueraDelTablero e){
				System.out.println("No se puede mover");
			}
			this.limpiarBotones(botonDerecha,botonIzquierda,botonArriba,botonAbajo);
			this.actualizarVista();
		});
		
	}
	
	
	public void actualizarVista(){
		Iterator <Node> iter = ((GridPane)this.grid.getChildren().get(0)).getChildren().iterator();
		while(iter.hasNext()){
			BotonCasillero boton = (BotonCasillero) iter.next();
			boton.actualizarImagen();
		}
	}
}
