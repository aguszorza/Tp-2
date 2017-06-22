package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.ModosDePelea.Modo;
import fiuba.algo3.ejemplo1.Personaje.Equipo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;


public class NubeVoladora extends Consumible {

    private static final int DURACION = 2;

    public NubeVoladora() {
        super(DURACION, "Nube voladora");
        this.guardarDireccion("file:src/fiuba/algo3/Imagenes/nube_voladora.png");
    }


    @Override
    public void afectar(Personaje personaje) { }

    @Override
    public void afectar(Modo modo) {
        modo.incrementarVelocidad(2);
    }

    @Override
    public void desafectar(Personaje personaje) { }

    @Override
    public void desafectar(Modo modo) {
        modo.actualizarVelocidadOriginal();
    }
    
    public void pasarTurno() {
    	this.duracionRestante -= 1;
    }
    
    public void atacar(){
    }
    
    public int afectar(Equipo equipo){
    	return 0;
    }
}
