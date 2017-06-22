package fiuba.algo3.Vista;

import java.io.File;
import java.util.Iterator;

import fiuba.algo3.ejemplo1.juego.Juego;
import fiuba.algo3.ejemplo1.juego.Jugador;
import fiuba.algo3.ejemplo1.juego.Turno;
import fiuba.algo3.ejemplo1.tablero.Celda;
import fiuba.algo3.ejemplo1.tablero.Tablero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Aplicacion  extends Application{

	String CANCION_MENU_PRINCIPAL = "src/fiuba/algo3/Musica/Opening.mp3";
	static MediaPlayer mediaPlayer;
	double TRANSPARENCIA = 0.9;
	DatosPersonajes datos;
	
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
		GridPane general = new GridPane();
		
		Image imagen = new Image("file:src/fiuba/algo3/ImagenesMenu/fondoPrincipal.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        general.setBackground(new Background(imagenDeFondo));
		
		Scene scene = new Scene(general, 300, 250);
		
		MenuPrincipal menu = new MenuPrincipal(stage, scene);
		Scene menuPrincipal = new Scene(menu, 640, 480);
		stage.setScene(menuPrincipal);
		
		this.datos = new DatosPersonajes(guerreros.obtenerPersonajesAliados(), enemigos.obtenerPersonajesAliados());
		general.add(datos, 0, 1);
		
		GridPane casilleros = new GridPane();
		casilleros.setAlignment(Pos.CENTER);
		general.setHgap(5);
		general.add(casilleros, 1, 1);
		
		casilleros.setOpacity(TRANSPARENCIA);
		
		Label lbl = new Label("Turno de "+turno.obtenerJugador().obtenerNombre());
		lbl.setTextFill(Color.BEIGE);
		lbl.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
		general.add(lbl, 1, 0);
		
		Button boton = new Button("Pasar Turno");
		boton.setOpacity(TRANSPARENCIA);
		boton.setOnAction(new BotonPasarTurnoHandler(this.datos, casilleros, turno, lbl));
		general.add(boton, 2, 0);
		
		for (int i = 1; i <= 9; i++){
			for(int j=1; j<= 9;j++){
				Celda celda = tablero.obtenerCelda(i, j);
				BotonCasillero toggle = new BotonCasillero(celda);
				casilleros.add(toggle, j, i);
				EventHandler<ActionEvent> event = new botonCasilla(turno, celda, general, lbl);
				toggle.setOnAction(event);
				toggle.actualizarImagen();
			}
		}
		stage.setFullScreen(true);
		Aplicacion.reproducirMusica(CANCION_MENU_PRINCIPAL);
		//stage.setScene(scene);
		stage.show();
	}
	
	private static void actualizarLabel(Turno turno, Label label){
		label.setText("Turno de " + turno.obtenerJugador().obtenerNombre());
	}
	
	public static void actualizarVista(DatosPersonajes datos, GridPane grid, Turno turno, Label label){
		datos.actualizar();
		actualizarLabel(turno, label);
		Iterator <Node> iter = grid.getChildren().iterator();
		while(iter.hasNext()){
			BotonCasillero boton = (BotonCasillero) iter.next();
			boton.actualizarImagen();
		}
	}
	
	public static void reproducirMusica(String cancion){
		String path = new File(cancion).getAbsolutePath();
		Media musicFile = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(musicFile);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setAutoPlay(true);
	}
	
	public static void cambiarCancion(String cancion){
		mediaPlayer.stop();
		String path = new File(cancion).getAbsolutePath();
		Media musicFile = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(musicFile);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setAutoPlay(true);
	}
}