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
        
        alert.setTitle("Reglas del juego");
        alert.setHeaderText("Reglas del juego");
        String mensaje = "1) Seleccionar un personaje del jugador.\n"
        		+ "2) Seleccionar un comando.\n\n"
        		+ "El movimiento se realiza de a una casilla a la vez.\n\n"
        		+ "Datos importantes:\n "
        		+ "	-La velocidad del personaje determina la cantidad\n"
        		+ "	de casillas que puede moverse.\n"
        		+ "	-La distancia de ataque determina el rango de ataque del personaje.\n\n"
        		+ "Transformaciones:\n"
        		+ "	-Goku KaioKen: 20 de ki.\n"
        		+ "	-Goku SSJ: 50 de ki\n"
        		+ "	-Gohan SSJ: 10 de ki\n"
        		+ "	-Gohan SSJ2: 30 de ki y los aliados deben tener menos del 30% de vida\n"
        		+ "	-Piccolo fortalecido: 20 de ki\n"
        		+ "	-Piccolo protector: Gohan debe tener menos del 20% de vida\n"
        		+ "	-Cell Semi-Perfecto: 4 absorciones\n"
        		+ "	-Cel Perfecto: 8 absorciones\n"
        		+ "	-Freezer segunda forma: 20 de ki\n"
        		+ "	-Freezer definitivo: 50 de ki\n"
        		+ "	-Majin Boo malo: 20 de ki\n"
        		+ "	-Majin Boo original: 50 de ki.\n\n"
        		+ "Habilidades especiales:\n"
        		+ "	-Goku: 20 de ki. Hace un 50% mas de daño que el ataque basico\n"
        		+ "	-Gohan: 10 de ki. Hace un 25% mas de daño que el ataque basico\n"
        		+ "	-Piccolo: 10 de ki. Hace un 25% mas de daño que el ataque basico\n"
        		+ "	-Cell: 5 de ki. Mismo daño que el ataque basico pero cura el daño hecho\n"
        		+ "	-Freezer: 20 de ki. Hace un 50% mas de daño que el ataque basico\n"
        		+ "	-MajinBoo: 30 de ki. Inutiliza por 3 turnos al personaje enemigo";
        TextArea textArea = new TextArea(mensaje);
        textArea.setEditable(false);
        alert.getDialogPane().setContent(textArea);
        //alert.(textArea);
        alert.show();
    }
}
