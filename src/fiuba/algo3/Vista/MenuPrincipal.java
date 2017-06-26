package fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuPrincipal extends VBox {
	
	Stage stage;
	
	public MenuPrincipal(Stage stage, Scene partida){

		super();

		this.stage = stage;

		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
 
		Image imagen = new Image("file:src/fiuba/algo3/ImagenesMenu/Menu9.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));

		Button botonJugar = new Button();
		botonJugar.setText("Jugar");
		botonJugar.setOpacity(0.8);

		BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, partida);
		botonJugar.setOnAction(botonJugarHandler);
		this.getChildren().add(botonJugar);
	}
}