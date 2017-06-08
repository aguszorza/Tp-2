package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.HabilidadEspecial;

import java.util.ArrayList;

public class Personaje {

	protected int vidaActual;
	protected int vidaMaxima;
	protected String nombre;
	protected int ki;
	protected Modo modoDePelea;
	protected HabilidadEspecial habilidad;
	private ArrayList<Consumible> consumiblesActivos;

	public Personaje(int vida, String nombre, Modo modo){
		this.vidaActual = vida;
		this.vidaMaxima = vida;
		this.nombre = nombre;
		this.ki = 0;
		this.modoDePelea = modo;
        this.consumiblesActivos = new ArrayList<>();
	}
	
	public void aumentarKi(){
		this.ki = this.ki + 5;
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
	//ver que hacer cuando llega a cero
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
	
	public float obtenerPoderDePelea(){
		return this.modoDePelea.obtenerPoderDePelea();
	}
	
	public int obtenerDistanciaDeAtaque(){
		return this.modoDePelea.obtenerDistanciaDeAtaque();
	}
	
	public int obtenerVelocidad(){
		return this.modoDePelea.obtenerVelocidad();
	}
	
	public void transformar(Modo modo){
		if (this.ki() < modo.obtenerCostoDeKi()){
			throw new KiInsuficiente();
		}
		this.modoDePelea = modo;
		this.ki = this.ki - modo.obtenerCostoDeKi();
	}
	
	public void atacar(Personaje enemigo){
		float danio = this.obtenerPoderDePelea();
		if(enemigo.obtenerPoderDePelea() > danio)
			danio = danio * (float)0.8;
		enemigo.reducirVida((int)danio);
	}
	
	public void lanzarHabilidadEspecial(Personaje enemigo){
		float danio = this.habilidad.lanzarHabilidad();
		if(enemigo.obtenerPoderDePelea() > this.obtenerPoderDePelea())
			danio = danio * (float)0.8;
		enemigo.reducirVida((int)danio);
	}

    public void consumir(Consumible consumible) {
        this.consumiblesActivos.add(consumible);
        consumible.afectar(this);
        consumible.afectar(modoDePelea);
    }

    public void actualizarConsumibles() {
        ArrayList<Consumible> consumiblesCaducados = new ArrayList<>();
        // Uso el Consumible y Guardo los caducados.
        for(int i = 0; i <= this.consumiblesActivos.size(); i++) {
            Consumible consumible = this.consumiblesActivos.get(i);
            consumible.usarConsumible();
            if( consumible.caducoEfecto() ) {
                consumible.desafectar(this);
                consumible.desafectar(this.modoDePelea);
                consumiblesCaducados.add(consumible);
            }
        }
        // Elimino de los Activos los caducados.
        for(int i = 0; i <= consumiblesCaducados.size(); i++) {
            this.consumiblesActivos.remove(consumiblesCaducados.get(i));
        }
    }
}
