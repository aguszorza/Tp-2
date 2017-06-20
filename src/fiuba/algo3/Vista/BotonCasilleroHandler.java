package fiuba.algo3.Vista;

import java.util.Iterator;

import fiuba.algo3.ejemplo1.Excepciones.PosicionFueraDelTablero;
import fiuba.algo3.ejemplo1.juego.Turno;
import fiuba.algo3.ejemplo1.tablero.Celda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BotonCasilleroHandler implements EventHandler<ActionEvent>{
	
	private Turno turno;
	private Celda celda;
	private GridPane grid;
	
	public BotonCasilleroHandler(Turno turno,Celda celda, GridPane grid){
		this.turno = turno;
		this.celda = celda;
		this.grid = grid;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		if(this.celda.estaVacia())
			return;
		Button botonDer = new Button("Derecha");
		botonDer.setMinSize(70, 70);
		int fila = celda.obtenerFila();
		int columna = celda.obtenerColumna();
		this.grid.add(botonDer, columna + 1, fila);
		botonDer.setOnAction(value->{
			try{
				Celda celdaFinal = new Celda(fila, columna + 1);
				this.turno.mover(this.celda.obtenerPersonaje(), celdaFinal);
				//this.tablero.moverPersonaje(this.celda.obtenerPersonaje(), this.celda, celdaFinal);
				//ToggleButton toggleinicio = (ToggleButton) ((GridPane)grid.getChildren().get(0)).getChildren().get(5*(fila-1)+columna-1);
				//ToggleButton togglefin = (ToggleButton) ((GridPane)grid.getChildren().get(0)).getChildren().get(5*(fila-1)+columna);
				//togglefin.setGraphic(toggleinicio.getGraphic());
				//toggleinicio.setGraphic(null);
			}
			catch (PosicionFueraDelTablero e){
				System.out.println("No se puede mover");
			}
			grid.getChildren().remove(botonDer);
			this.actualizarVista();
		});
	}
	
	public void actualizarVista(){
		Iterator <Node> iter = this.grid.getChildren().iterator();
		while(iter.hasNext()){
			BotonCasillero boton = (BotonCasillero) iter.next();
			boton.actualizarImagen();
		}
	}
}
