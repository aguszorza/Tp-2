package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.Excepciones.PersonajeInutilizado;
import fiuba.algo3.ejemplo1.HabilidadesEspeciales.HabilidadEspecial;
import fiuba.algo3.ejemplo1.ModosDePelea.Modo;
import fiuba.algo3.ejemplo1.ModosDePelea.ModoChocolate;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.function.Function;

public class Personaje {
	
	private static final int TURNOS_CHOCOLATE = 3;

	protected int vidaActual;
	protected int vidaMaxima;
	protected String nombre;
	protected int ki;
	protected Modo modoDePelea;
	protected HabilidadEspecial habilidad;
	protected Equipo aliados;
	private Hashtable <String, Consumible> consumiblesActivos;

	public Personaje(int vida, String nombre, Modo modo){
		this.vidaActual = vida;
		this.vidaMaxima = vida;
		this.nombre = nombre;
		this.ki = 0;
		this.modoDePelea = modo;
        this.consumiblesActivos = new  Hashtable <String, Consumible>();
	}
	
	public String obtenerImagen(){
		return this.modoDePelea.obtenerImagen();
	}
	
	public void agregarAliados(Equipo aliados){
		this.aliados = aliados;
	}
	
	public Equipo obtenerAliados(){
		return this.aliados;
	}
	
	public void aumentarKi(){
		this.ki = this.ki + this.modoDePelea.aumentarKi();
	}
	
	public void reducirKi(int costoKi){
		this.ki = this.ki - costoKi;
	}
	
	public void aumentarVida(int cantidad){
		if(this.vidaActual + cantidad > this.vidaMaxima){
			this.vidaActual = this.vidaMaxima;
		}
		else{
			this.vidaActual = this.vidaActual + cantidad;
		}
	}

	public void reducirVida(int cantidad){
		this.vidaActual = this.vidaActual - cantidad;
	}
	
	public int ki(){
		return this.ki;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int obtenerVida(){
		return this.vidaActual;
	}
	
	public int obtenerPorcentajeDeVida(){
		return this.vidaActual * 100/this.vidaMaxima;
	}
	
	public float obtenerPoderDePelea(){
		return this.modoDePelea.obtenerPoderDePelea();
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.modoDePelea.obtenerDistanciaDeAtaque();
	}
	
	public int obtenerVelocidad(){
		return this.modoDePelea.obtenerVelocidad();
	}
	
	public Boolean transformar(){
		Modo modoNuevo = this.modoDePelea.transformar(this);
		if (modoNuevo == null){
			return false;
		}
		this.modoDePelea = modoNuevo;
		this.ki = this.ki - modoNuevo.obtenerCostoDeKi();
		return true;
	}
	
	public void transformarEnChocolate(){
		this.modoDePelea = new ModoChocolate (this.modoDePelea, TURNOS_CHOCOLATE );
	}

	public void recuperarModoDePelea(){
		this.modoDePelea = this.modoDePelea.recuperarModoDePelea();
	}

	public void pasarTurno(){
		Function <Consumible, Void> funcion;
		funcion = (Consumible consumible) -> {
		consumible.pasarTurno();
		return null;};
		actualizarConsumibles(funcion);
		this.modoDePelea.pasarTurno();
		this.recuperarModoDePelea();
	}
	
	public float obtenerDanioDeAtaque(Personaje enemigo){
		return this.modoDePelea.obtenerDanioDeAtaque(enemigo);
	}
	
	private Boolean ataque(Personaje enemigo, Function <Personaje, Float> ataque){
		try{
			float danio = ataque.apply(this);
			if(danio < 0){
				return false;
			}
			enemigo.reducirVida((int)danio);
			Function <Consumible, Void> funcion;
			funcion = (Consumible consumible) -> {
			consumible.atacar();
			return null;};
			actualizarConsumibles(funcion);
			return true;
		}
		catch (PersonajeInutilizado e){
			return false;
		}
	}
	
	public Boolean atacar(Personaje enemigo){
		Function <Personaje, Float> funcion;
		funcion = (Personaje personaje)-> personaje.obtenerDanioDeAtaque(enemigo);
		return ataque(enemigo, funcion);
	}
	
	public Boolean lanzarHabilidadEspecial(Personaje enemigo){
		Function <Personaje, Float> funcion;
		funcion = (Personaje personaje)-> personaje.habilidad.lanzarHabilidad(enemigo);
		return ataque(enemigo, funcion);
	}

	public void consumir(Consumible consumible) {
		this.consumiblesActivos.put(consumible.obtenerNombre(), consumible);
		consumible.afectar(this);
		consumible.afectar(modoDePelea);
		this.aliados.consumir(consumible);
	}

	public void actualizarConsumibles(Function <Consumible, Void> funcion) {
		Iterator <Consumible> iterador = this.consumiblesActivos.values().iterator();
		// Uso el Consumible y remuevo los caducados.
		while(iterador.hasNext()){
			Consumible consumible = iterador.next();
			funcion.apply(consumible);
			if(consumible.caducoEfecto()){
				consumible.desafectar(this.modoDePelea);
				iterador.remove();
			}
		}
	}
	
	public int cantidadEsferas(){
		return this.aliados.cantidadEsferas();
	}
}
