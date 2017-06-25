package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.ModosDePelea.Modo;
import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;


public class SemillaErmitanio extends Consumible {

    private static final int DURACION = 1;

    public SemillaErmitanio() {
        super(DURACION, "Semilla del ermitanio");
        this.guardarDireccion("file:src/fiuba/algo3/Imagenes/semilla.png");
    }

    @Override
    public void afectar(Personaje personaje) {
        personaje.aumentarVida(100);
    }

    @Override
    public void afectar(Modo modo) { }

    @Override
    public void desafectar(Modo modo) { }
    
    public void pasarTurno() {
    	this.duracionRestante -= 1;
    }
    
    public void atacar(){
    }
    
    public int afectar(Equipo equipo){
    	return 0;
    }
    
    public Consumible obtenerCopia(){
    	return new SemillaErmitanio();
    }
}
