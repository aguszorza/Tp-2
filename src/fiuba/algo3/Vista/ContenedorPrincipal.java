package fiuba.algo3.Vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{

	 BarraDeMenu menuBar;
	 
	 
	 public ContenedorPrincipal(Stage stage) {
	        this.setMenu(stage);	       
	    }
	 
	 private void setMenu(Stage stage) {
	        this.menuBar = new BarraDeMenu(stage);
	        this.setTop(menuBar);
	 }
	 
	 public BarraDeMenu getBarraDeMenu() {
	        return menuBar;
    }
	
}
