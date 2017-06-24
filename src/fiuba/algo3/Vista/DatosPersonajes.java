package fiuba.algo3.Vista;

import java.util.ArrayList;
import java.util.Enumeration;

import fiuba.algo3.ejemplo1.Personaje.Personaje;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DatosPersonajes extends GridPane{

	double TRANSPARENCIA = 0.9;
	int TAMANIO = 70;
	
	private ArrayList <Personaje> personajes;
	String IMAGEN_GUERREROS = "file:src/fiuba/algo3/Imagenes/Guerreros.png";
	String IMAGEN_ENEMIGOS = "file:src/fiuba/algo3/Imagenes/Enemigos.png";
	
	public DatosPersonajes(Enumeration<Personaje> equipo1, Enumeration<Personaje> equipo2){
		this.personajes = new ArrayList <Personaje>();
		agregarEquipo(equipo1);
		agregarEquipo(equipo2);
		this.crear();
		this.setOpacity(0.9);
		this.setVgap(5);
	}
	
	private void agregarEquipo(Enumeration<Personaje> equipo){
		while(equipo.hasMoreElements()){
			this.personajes.add(equipo.nextElement());
		}
	}
	
	private void crear(){
		for (int i = 0; i < this.personajes.size(); i ++){
			Personaje personaje = this.personajes.get(i);
			ToggleButton boton = new ToggleButton();
			boton.setOnAction(value-> boton.setSelected(false));
			Label label = new Label();
			boton.setOpacity(TRANSPARENCIA);
			boton.setMinSize(70, 70);
			boton.setMaxSize(70,70);
			ImageView imv = new ImageView();
			Image image = new Image(personaje.obtenerImagen());
			imv.setImage(image);
			boton.setGraphic(imv);
			label.setText(obtenerDatos(personaje));
			label.setTextFill(Color.BEIGE);
			label.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
			this.add(boton, 0, i);
			this.add(label, 1, i);
		}
		agregarDatosEsfera(this.personajes.size(),IMAGEN_GUERREROS,this.personajes.get(0));
		agregarDatosEsfera(this.personajes.size() + 1,IMAGEN_ENEMIGOS,this.personajes.get(this.personajes.size() - 1));
	}
	
	private void agregarDatosEsfera(int fila, String imagen, Personaje personaje){
		ToggleButton boton = new ToggleButton();
		Label label = new Label();
		boton.setOpacity(TRANSPARENCIA);
		boton.setMinSize(70, 70);
		boton.setMaxSize(70,70);
		ImageView imv = new ImageView();
		Image image = new Image(imagen);
		imv.setImage(image);
		boton.setGraphic(imv);
		label.setText(String.valueOf(personaje.cantidadEsferas()));
		label.setTextFill(Color.BEIGE);
		label.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
		this.add(boton, 0, fila);
		this.add(label, 1, fila);
	}
	
	private String obtenerDatos(Personaje personaje){
		String Datos = "Vida: " + personaje.obtenerVida() + "\n";
		Datos += "Ki: " + personaje.ki() + "\n";
		Datos += "Daño: " + (int)personaje.obtenerPoderDePelea() + "\n";
		try{
			Datos += "Distancia: " + personaje.obtenerDistanciaDeAtaque() + "\n";
		}
		catch(Exception e){
			Datos += "Distancia: 0\n";
		}
		try{
			Datos += "Velocidad: " + personaje.obtenerVelocidad();
		}
		catch(Exception e){
			Datos += "Velocidad: 0\n";
		}
		return Datos;
	}
	
	public void actualizar(){
		ObservableList <Node> lista = this.getChildren();
		int posicionPersonajes = 0;
		int posicionLista = 1;
		while (posicionLista < this.personajes.size() * 2){
			Label label = (Label)lista.get(posicionLista);
			Personaje personaje = this.personajes.get(posicionPersonajes);
			String datos = obtenerDatos(personaje);
			label.setText(datos);
			posicionPersonajes ++;
			posicionLista += 2;
		}
		Label label = (Label)lista.get(posicionLista);
		label.setText(String.valueOf(this.personajes.get(0).cantidadEsferas()));
		posicionLista += 2;
		label = (Label)lista.get(posicionLista);
		label.setText(String.valueOf(this.personajes.get(posicionPersonajes - 1).cantidadEsferas()));
	}
}
