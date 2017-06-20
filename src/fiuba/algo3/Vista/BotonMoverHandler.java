package fiuba.algo3.Vista;

import fiuba.algo3.ejemplo1.Excepciones.PosicionFueraDelTablero;
import fiuba.algo3.ejemplo1.juego.Turno;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class BotonMoverHandler implements EventHandler<ActionEvent>{

	private int X;
	private int Y;
	private Turno turno;
	private Celda celda;
	
	
	public BotonMoverHandler(int x, int y, Turno turno, Celda celda){
		this.X = x;
		this.Y = y;
		this.turno = turno;
		this.celda = celda;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		int fila = this.celda.obtenerFila();
		int columna = this.celda.obtenerColumna();
		try{
			Celda celdaFinal = new Celda(fila + this.X, columna + this.Y);
			this.turno.mover(this.celda.obtenerPersonaje(), celdaFinal);
			//ToggleButton toggleinicio = (ToggleButton) ((GridPane)grid.getChildren().get(0)).getChildren().get(5*(fila-1)+columna-1);
			//ToggleButton togglefin = (ToggleButton) ((GridPane)grid.getChildren().get(0)).getChildren().get(5*(fila-1)+columna);
			//togglefin.setGraphic(toggleinicio.getGraphic());
			//toggleinicio.setGraphic(null);
		}
		catch (PosicionFueraDelTablero e){
			System.out.println("No se puede mover");
		}
	}
}
