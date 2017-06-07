package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.Personaje.Modo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;


public class NubeVoladora extends Consumible {

    private static final int DURACION = 2;

    protected NubeVoladora() {
        super(DURACION);
    }


    @Override
    public void afectar(Personaje personaje) { }

    @Override
    public void afectar(Modo modo) {
        modo.incrementarVelocidad(50);
    }

    @Override
    public void desafectar(Personaje personaje) { }

    @Override
    public void desafectar(Modo modo) {
        modo.actualizarVelocidadOriginal();
    }
}
