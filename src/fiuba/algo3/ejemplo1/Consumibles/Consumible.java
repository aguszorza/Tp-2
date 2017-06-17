package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.ModosDePelea.Modo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public abstract class Consumible {

    private int duracionTotalEfecto;
    protected int duracionRestante;
    protected String nombre;

    public Consumible(int duracionEfecto, String nombre) {
        this.duracionTotalEfecto = duracionEfecto;
        this.duracionRestante = duracionEfecto;
        this.nombre = nombre;
    }

    public abstract void afectar(Personaje personaje);
    public abstract void afectar(Modo modo);

    public abstract void desafectar(Personaje personaje);
    public abstract void desafectar(Modo modo);
   
    public String obtenerNombre(){
    	return this.nombre;
    }

    protected boolean esPrimerUso() {
		return this.duracionRestante == this.duracionTotalEfecto;
    }
    
    public boolean caducoEfecto() {
    	return this.duracionRestante == 0;
    }
    
    public abstract void pasarTurno();
    public abstract void atacar();
}
