package fiuba.algo3.Vista;

import fiuba.algo3.ejemplo1.tablero.Celda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonCasillero extends ToggleButton{

	//double TRANSPARENCIA = 0.9;
	
	private Celda celda;
	
	public BotonCasillero(Celda celda){
		this.celda = celda;	
		//this.setOpacity(TRANSPARENCIA);
		this.setMinSize(70, 70);
		this.setMaxSize(70,70);
	}
	
	public void actualizarImagen(){
		/*if(this.celda.estaVacia()){
			this.setGraphic(null);
			return;
		}*/
		if(!this.celda.estaVacia() || this.celda.hayConsumible()){
			ImageView imv = new ImageView();
			Image image = new Image(this.celda.obtenerImagen());
			imv.setImage(image);
			this.setGraphic(imv);
		}
		else{
			this.setGraphic(null);
		}
	}
}
