package fiuba.algo3.Vista;

import fiuba.algo3.ejemplo1.Consumibles.NubeVoladora;
import fiuba.algo3.ejemplo1.Consumibles.SemillaErmitanio;
import fiuba.algo3.ejemplo1.Personaje.Freezer;
import fiuba.algo3.ejemplo1.Personaje.Goku;
import fiuba.algo3.ejemplo1.Personaje.MajinBoo;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class VistaTablero extends Application{

	public static void main(String[] args) {
        launch(args);
    }
	
	/*@Override
    public void start(Stage stage) throws Exception {
		Tablero tablero = new Tablero(5);
		Button botonMover = new Button();
		botonMover.setText("Mover");
		GridPane casilla = new GridPane();
		System.out.println(casilla.getChildren().size());
		System.out.println(casilla.getChildren().size());
		casilla.getRowConstraints().add(new RowConstraints(5));
		casilla.getColumnConstraints().add(new ColumnConstraints(5));
		System.out.println(casilla.getChildren().size());
		casilla.setAlignment(Pos.CENTER);
		casilla.setHgap(10);
		casilla.setVgap(10);
		GridPane general = new GridPane();
		general.setHgap(30);
		general.add(casilla, 1, 1);
		general.add(botonMover, 3, 1);
		//general.getChildren().add(botonMover);
		//general.getChildren().addAll(new Label("Search:"), null, botonMover);
		Scene scene = new Scene(general, 300, 250);
		Goku goku = new Goku();
		Freezer freezer = new Freezer();
		tablero.agregarPersonaje(tablero.obtenerCelda(1, 3), goku);
		tablero.agregarPersonaje(tablero.obtenerCelda(5, 3), freezer);
		for (int i = 1; i <= 5; i++){
			for(int j=1; j<=5;j++){
				ToggleButton toggle = new ToggleButton();
				toggle.setMinSize(100, 100); toggle.setMaxSize(100,100);
				casilla.add(toggle, j, i);
				Celda celda = tablero.obtenerCelda(i, j);
				EventHandler<ActionEvent> event = new botonCasilla(tablero, celda,general);
				toggle.setOnAction(event);
				if(celda.estaVacia()){
					continue;
				}
				ImageView imv = new ImageView();
				Image image = new Image(celda.obtenerPersonaje().obtenerImagen());
				imv.setImage(image);
				toggle.setGraphic(imv);
			}
		}
		stage.setScene(scene);
		stage.show();
	}*/

	@Override
    public void start(Stage stage) throws Exception {
		Tablero tablero = new Tablero(10);
		GridPane casilla = new GridPane();
		casilla.setAlignment(Pos.CENTER);
		//casilla.setHgap(10);
		//casilla.setVgap(10);
		GridPane general = new GridPane();
		general.setHgap(30);
		general.add(casilla, 1, 1);
		Scene scene = new Scene(general, 300, 250);
		SemillaErmitanio semilla = new SemillaErmitanio();
		Goku goku = new Goku();
		Freezer freezer = new Freezer();
		MajinBoo majin = new MajinBoo();
		tablero.agregarPersonaje(tablero.obtenerCelda(1, 3), goku);
		tablero.agregarPersonaje(tablero.obtenerCelda(10, 3), majin);
		tablero.agregarPersonaje(tablero.obtenerCelda(5, 3), freezer);
		tablero.agregarConsumible(tablero.obtenerCelda(1, 4), semilla);
		for (int i = 1; i <= 10; i++){
			for(int j=1; j<= 10;j++){
				Celda celda = tablero.obtenerCelda(i, j);
				BotonCasillero toggle = new BotonCasillero(celda);
				toggle.setMinSize(70, 70);
				toggle.setMaxSize(70,70);
				casilla.add(toggle, j, i);
				EventHandler<ActionEvent> event = new botonCasilla(tablero, celda, general);
				toggle.setOnAction(event);
				toggle.actualizarImagen();
			}
		}
		//Button boton = new Button();
		//casilla.add(boton,3,1);
		//boton.setMinSize(70, 70);
		//boton.setVisible(false);
		//boton.setBlendMode(BlendMode.BLUE);
		stage.setScene(scene);
		stage.show();
	}

}
