package fiuba.algo3.Vista;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import fiuba.algo3.ejemplo1.juego.Turno;
import fiuba.algo3.ejemplo1.tablero.Celda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonCasilleroHandler implements EventHandler<ActionEvent>{
	
	double TRANSPARENCIA = 0.9;
	String SONIDO_ERROR = "src/fiuba/algo3/Musica/error.mp3";
	String SONIDO_MOVIMIENTO = "src/fiuba/algo3/Musica/movimiento.mp3";
	String SONIDO_GOLPE = "src/fiuba/algo3/Musica/punch.mp3";
	String SONIDO_HABILIDAD = "src/fiuba/algo3/Musica/candyattack.mp3";
	String SONIDO_TRANSFORMACION = "src/fiuba/algo3/Musica/aura.mp3"; 
	private Turno turno;
	private Celda celda;
	private GridPane grid;
	private Label labelTurno;
	private Button botonDerecha;
	private Button botonIzquierda;
	private Button botonArriba;
	private Button botonAbajo;
	private Button botonCancelar;
	private Button botonAtacar;
	private Button botonHabilidad;
	private Button botonTransformar;
	private ToggleButton toggle;
	private GridPane botonera;
	
	private ArrayList <ToggleButton> botonesEnemigos;
	
	
	public BotonCasilleroHandler(Turno turno, Celda celda, GridPane grid, Label labelTurno, ToggleButton toggle){
		this.botonesEnemigos = new ArrayList <ToggleButton>();
		this.turno = turno;
		this.celda = celda;
		this.grid = grid;
		this.labelTurno = labelTurno;
		this.botonDerecha = new Button("Derecha");
		this.botonDerecha.setOpacity(TRANSPARENCIA);
		this.botonIzquierda = new Button("Izquierda");
		this.botonIzquierda.setOpacity(TRANSPARENCIA);
		this.botonAbajo = new Button("Abajo");
		this.botonAbajo.setOpacity(TRANSPARENCIA);
		this.botonArriba = new Button("Arriba");
		this.botonArriba.setOpacity(TRANSPARENCIA);
		this.botonCancelar = new Button("Cancelar");
		this.botonCancelar.setOpacity(TRANSPARENCIA);
		this.botonAtacar = new Button ("Atacar");
		this.botonAtacar.setOpacity(TRANSPARENCIA);
		this.botonHabilidad = new Button ("Habilidad\nEspecial");
		this.botonHabilidad.setOpacity(TRANSPARENCIA);
		this.botonTransformar = new Button ("Transformar");
		this.botonTransformar.setOpacity(TRANSPARENCIA);
		this.toggle = toggle;
		this.botonera = new GridPane();
		this.botonDerecha.setMinSize(100, 70);
		this.botonDerecha.setMaxSize(100, 70);
		this.botonIzquierda.setMinSize(100, 70);
		this.botonIzquierda.setMaxSize(100, 70);
		this.botonAbajo.setMinSize(100, 70);
		this.botonAbajo.setMaxSize(100, 70);
		this.botonArriba.setMinSize(100, 70);
		this.botonArriba.setMaxSize(100, 70);
		this.botonCancelar.setMinSize(100, 70);
		this.botonCancelar.setMaxSize(100, 70);
		this.botonAtacar.setMinSize(100, 70);
		this.botonAtacar.setMaxSize(100, 70);
		this.botonHabilidad.setMinSize(100, 70);
		this.botonHabilidad.setMaxSize(100, 70);
		this.botonTransformar.setMinSize(100, 70);
		this.botonTransformar.setMaxSize(100, 70);
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		limpiarBotones();
		if (!this.celda.estaVacia() && this.turno.existePersonaje(this.celda.obtenerPersonaje())){
			this.grid.add(this.botonera, 2, 1);
			this.botonera.setAlignment(Pos.CENTER);
			this.botonera.add(botonDerecha, 2, 3);
			this.botonera.add(botonIzquierda, 3, 3);
			this.botonera.add(botonAbajo, 4, 3);
			this.botonera.add(botonArriba, 1, 3);
			this.botonera.add(botonCancelar, 1, 2);
			this.botonera.add(botonAtacar, 1, 4);
			this.botonera.add(botonHabilidad, 1, 5);
			this.botonera.add(botonTransformar, 1, 6);
			this.setearAccionBoton(botonDerecha,1,0);
			this.setearAccionBoton(botonIzquierda,-1,0);
			this.setearAccionBoton(botonArriba,0,-1);
			this.setearAccionBoton(botonAbajo,0,1);
			this.setearBotonCancelar();
			this.setearBotonAtacar();
			this.setearBotonHabilidad();
			this.setearBotonTransformar();
		}
		else{
			this.toggle.setSelected(false);
		}
	}

	private void limpiarBotones() {
		grid.getChildren().remove(this.botonera);
		this.botonera.getChildren().remove(botonDerecha);
		this.botonera.getChildren().remove(botonIzquierda);
		this.botonera.getChildren().remove(botonArriba);
		this.botonera.getChildren().remove(botonAbajo);
		this.botonera.getChildren().remove(botonCancelar);
		this.botonera.getChildren().remove(botonAtacar);
		this.botonera.getChildren().remove(botonHabilidad);
		this.botonera.getChildren().remove(botonTransformar);
		for(int i = 0; i < botonesEnemigos.size(); i++){
			this.botonera.getChildren().remove(botonesEnemigos.get(i));
		}
		/*grid.getChildren().remove(botonDerecha);
		grid.getChildren().remove(botonIzquierda);
		grid.getChildren().remove(botonArriba);
		grid.getChildren().remove(botonAbajo);
		grid.getChildren().remove(botonCancelar);
		grid.getChildren().remove(botonAtacar);
		grid.getChildren().remove(botonHabilidad);
		grid.getChildren().remove(botonTransformar);
		for(int i = 0; i < botonesEnemigos.size(); i++){
			grid.getChildren().remove(botonesEnemigos.get(i));
		}*/
	}
	
	private void setearBotonTransformar(){
		this.botonTransformar.setOnAction(value->{
			if(this.turno.transformar(this.celda.obtenerPersonaje())){
				this.reproducirSonido(SONIDO_TRANSFORMACION);
			}
			else{
				this.reproducirSonido(SONIDO_ERROR);
			}
			this.limpiarBotones();
			this.actualizarVista();
		});
	}
	
	private void setearBotonHabilidad(){
		this.botonHabilidad.setOnAction(value->{
			Enumeration <Personaje> enemigos = turno.obtenerJugador().obtenerPersonajesEnemigos();
			int columna = 2;
			while(enemigos.hasMoreElements()){
				Personaje enemigo = enemigos.nextElement();
				ToggleButton personaje = new ToggleButton();
				personaje.setOpacity(TRANSPARENCIA);
				personaje.setOnAction(value2->{
					if(this.turno.lanzarHablidad(this.celda.obtenerPersonaje(), enemigo)){
						this.reproducirSonido(SONIDO_HABILIDAD);
					}
					else{
						this.reproducirSonido(SONIDO_ERROR);
					}
					this.limpiarBotones();
					this.actualizarVista();
					this.hayGanador();
				});
				personaje.setMinSize(70, 70);
				personaje.setMaxSize(70, 70);
				this.botonesEnemigos.add(personaje);
				ImageView imv = new ImageView();
				Image image = new Image(enemigo.obtenerImagen());
				imv.setImage(image);
				personaje.setGraphic(imv);
				this.botonera.add(personaje, columna, 4);
				columna++;
			}
		});
	}
	
	private void setearBotonAtacar(){
		this.botonAtacar.setOnAction(value->{
		Enumeration <Personaje> enemigos = turno.obtenerJugador().obtenerPersonajesEnemigos();
		int columna = 2;
		while(enemigos.hasMoreElements()){
			Personaje enemigo = enemigos.nextElement();
			ToggleButton personaje = new ToggleButton();
			personaje.setOpacity(TRANSPARENCIA);
			personaje.setOnAction(value2->{
				if(this.turno.atacar(this.celda.obtenerPersonaje(), enemigo)){
					this.reproducirSonido(SONIDO_GOLPE);
				}
				else{
					this.reproducirSonido(SONIDO_ERROR);
				}
				this.limpiarBotones();
				this.actualizarVista();
				this.hayGanador();
			});
			personaje.setMinSize(70, 70);
			personaje.setMaxSize(70, 70);
			this.botonesEnemigos.add(personaje);
			ImageView imv = new ImageView();
			Image image = new Image(enemigo.obtenerImagen());
			imv.setImage(image);
			personaje.setGraphic(imv);
			this.botonera.add(personaje, columna, 4);
			columna++;
		}
		});
	}
	
	private void setearBotonCancelar(){
		this.botonCancelar.setOnAction(value->{
			this.limpiarBotones();
			this.actualizarVista();
		});
	}

	private void setearAccionBoton(Button boton, int x, int y){
		boton.setOnAction(value->{
			int fila = this.celda.obtenerFila();
			int columna = this.celda.obtenerColumna();
			Celda celdaFinal = new Celda(fila  + y , columna + x);
			if(this.turno.mover(this.celda.obtenerPersonaje(), celdaFinal)){
				this.reproducirSonido(SONIDO_MOVIMIENTO);
			}
			else{
				this.reproducirSonido(SONIDO_ERROR);
			}
			this.limpiarBotones();
			this.actualizarVista();
			this.hayGanador();
		});
	}
	
	public void reproducirSonido(String ruta){
		String path = new File(ruta).getAbsolutePath();
		Media musicFile = new Media(new File(path).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(musicFile);
		mediaPlayer.setAutoPlay(true);
	}
	
	public void hayGanador(){
		if(this.turno.obtenerGanador() != null){
			Aplicacion.ganoAlguien(this.turno.obtenerImagen());
		}
	}
	
	public void actualizarVista(){
		DatosPersonajes datos = (DatosPersonajes)this.grid.getChildren().get(0);
		GridPane grid = (GridPane)this.grid.getChildren().get(1);
		this.toggle.setSelected(false);
		Aplicacion.actualizarVista(datos, grid,this.turno,this.labelTurno);
	}
}