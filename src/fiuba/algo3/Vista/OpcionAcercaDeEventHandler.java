package fiuba.algo3.Vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Reglas del juego");
        String mensaje = "1) Seleccionar un personaje del jugador.\n"
        		+ "2) Seleccionar un comando.\n\n"
        		+ "El movimiento se realiza de a una casilla a la vez.\n"
        		+ "Datos importantes:\n -La velocidad del personaje determina la cantidad\n"
        		+ "de casillas que puede moverse.\n -La distancia de ataque determina el rango"
        		+ "de ataque del personaje.";
        TextArea textArea = new TextArea(mensaje);
        alert.getDialogPane().setContent(textArea);
        //alert.(textArea);
        alert.show();
    }
}
