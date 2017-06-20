package fiuba.algo3.Vista;

import fiuba.algo3.ejemplo1.juego.Juego;
import fiuba.algo3.ejemplo1.juego.Jugador;
import fiuba.algo3.ejemplo1.juego.Turno;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Aplicacion  extends Application{

	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(Stage stage) throws Exception {
		Juego juego = new Juego();
		Jugador guerreros = juego.obtenerGuerrerosZ();
		Jugador enemigos = juego.obtenerEnemigos();
		Tablero tablero = juego.obtenerTablero(); 
		Turno turno = new Turno(guerreros, enemigos);
		
		GridPane casilleros = new GridPane();
		casilleros.setAlignment(Pos.CENTER);
		GridPane general = new GridPane();
		general.setHgap(10);
		general.add(casilleros, 1, 1);
		Scene scene = new Scene(general, 300, 250);
		
		Label lbl = new Label("Turno de "+turno.obtenerJugador().obtenerNombre());
		general.add(lbl, 1, 0);
		
		Button boton = new Button("Pasar Turno");
		boton.setOnAction(new BotonPasarTurnoHandler(turno, lbl));
		general.add(boton, 2, 0);
		
		for (int i = 1; i <= 9; i++){
			for(int j=1; j<= 9;j++){
				Celda celda = tablero.obtenerCelda(i, j);
				BotonCasillero toggle = new BotonCasillero(celda);
				toggle.setMinSize(70, 70);
				toggle.setMaxSize(70,70);
				casilleros.add(toggle, j, i);
				EventHandler<ActionEvent> event = new BotonCasilleroHandler(turno, celda, casilleros);
				toggle.setOnAction(event);
				toggle.actualizarImagen();
			}
		}
		stage.setScene(scene);
		stage.show();

	}
}