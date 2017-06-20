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
	
	public botonCasilla(Tablero tablero, Celda celda, GridPane grid){
		this.tablero = tablero;
		this.celda = celda;
		this.grid = grid;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Button boton = new Button("Derecha");
		this.grid.add(boton, 3, 1);
		boton.setOnAction(value->{
			int fila = this.celda.obtenerFila();
			int columna = this.celda.obtenerColumna();
			try{
				Celda celdaFinal = new Celda(fila, columna + 1);
				this.tablero.moverPersonaje(this.celda.obtenerPersonaje(), this.celda, celdaFinal);
				//ToggleButton toggleinicio = (ToggleButton) ((GridPane)grid.getChildren().get(0)).getChildren().get(5*(fila-1)+columna-1);
				//ToggleButton togglefin = (ToggleButton) ((GridPane)grid.getChildren().get(0)).getChildren().get(5*(fila-1)+columna);
				//togglefin.setGraphic(toggleinicio.getGraphic());
				//toggleinicio.setGraphic(null);
			}
			catch (PosicionFueraDelTablero e){
				System.out.println("No se puede mover");
			}
			//this.grid.row
			grid.getChildren().remove(boton);
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
