package fiuba.algo3.ejemplo1.Personaje;

import fiuba.algo3.ejemplo1.Consumibles.Consumible;
import fiuba.algo3.ejemplo1.HabilidadEspecial;

import java.util.ArrayList;

public class Personaje {

	protected int vida;
	protected int vidaMaxima;
	protected String nombre;
	protected int ki;
	protected Modo modoDePelea;
	protected HabilidadEspecial habilidad;
	private ArrayList<Consumible> consumiblesActivos;

	public Personaje(int vida, String nombre, Modo modo){
		this.vida = vida;
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
		if(this.vida + cantidad > this.vidaMaxima){
			this.vida = this.vidaMaxima;
		}
		else{
			this.vida = this.vida + cantidad;
		}
	}
	//ver que hacer cuando llega a cero
	public void reducirVida(int cantidad){
		this.vida = this.vida - cantidad;
	}
	
	public int ki(){
		return this.ki;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int obtenerVida(){
		return this.vida;
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
	
	public void transformar(Modo modo, int costoKi){
		if (this.ki() < costoKi){
			throw new KiInsuficiente();
		}
		this.modoDePelea = modo;
		this.ki = this.ki - costoKi;
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
