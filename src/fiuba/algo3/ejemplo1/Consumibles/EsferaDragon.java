package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.Personaje.Modo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;


public class EsferaDragon extends Consumible {

    private static final int DURACION = 2;

    protected EsferaDragon() {
        super(DURACION);
    }

    @Override
    public void afectar(Personaje personaje) {
        //if( this.esPrimerUso() ) { personaje.getEquipo().ganarEsferaDragon(); }
    }

    @Override
    public void afectar(Modo modo) {
        modo.incrementarPoderPelea(25);
    }

    @Override
    public void desafectar(Personaje personaje) { }

    @Override
    public void desafectar(Modo modo) {
        modo.actualizarPoderPeleaOriginal();
    }
}
