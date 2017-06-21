package fiuba.algo3.Vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MenuPrincipal extends VBox {
	
	Stage stage;
	
	public MenuPrincipal(Stage stage, Scene partida){

	 super();

     this.stage = stage;

     this.setAlignment(Pos.CENTER);
     this.setSpacing(20);
     this.setPadding(new Insets(25));
     Image imagen = new Image("file:src/fiuba/algo3/ImagenesMenu/Menu.gif");
     ImageView imageView = new ImageView();
     imageView.setImage(imagen);
     
     Toolkit t = Toolkit.getDefaultToolkit();
     Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
     
     imageView.setFitHeight(tamanioPantalla.height - 50);
     imageView.setFitWidth(tamanioPantalla.width);
     
    //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, null, null, null, null);
    //this.setBackground(new Background(imagenDeFondo));

     Button botonEntrar = new Button();
     botonEntrar.setText("Jugar");

     BotonJugarEventHandler botonEntrarHandler = new BotonJugarEventHandler(stage, partida);
     botonEntrar.setOnAction(botonEntrarHandler);

     this.getChildren().addAll(imageView,botonEntrar);
	}
}