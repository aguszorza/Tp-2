package fiuba.algo3.Vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene partida;

    public BotonJugarEventHandler(Stage stage, Scene PartidaDelJuego) {
        this.stage = stage;
        this.partida = PartidaDelJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(partida);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
