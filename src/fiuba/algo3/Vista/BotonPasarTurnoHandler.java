package fiuba.algo3.Vista;

import fiuba.algo3.ejemplo1.juego.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BotonPasarTurnoHandler implements EventHandler<ActionEvent>{

	private Turno turno;
	private Label label;
	private GridPane grid;
	
	public BotonPasarTurnoHandler(GridPane grid, Turno turno, Label lbl){
		this.turno = turno;
		this.label = lbl;
		this.grid = grid;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		this.turno.pasarTurno();
		//this.label.setText("Turno de "+turno.obtenerJugador().obtenerNombre());
		Aplicacion.actualizarVista(grid, turno, label);
	}
}
