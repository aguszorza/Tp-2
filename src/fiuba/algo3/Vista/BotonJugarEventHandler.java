package fiuba.algo3.Vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene partida;
    String CANCION_DE_FONDO = "src/fiuba/algo3/Musica/SonidoDeFondo.mp3";

    public BotonJugarEventHandler(Stage stage, Scene PartidaDelJuego) {
        this.stage = stage;
        this.partida = PartidaDelJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(partida);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        Aplicacion.cambiarCancion(CANCION_DE_FONDO);
    }
}
