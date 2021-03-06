package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.ModosDePelea.Modo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;


public class EsferaDragon extends Consumible {

    private static final int DURACION = 2;

    public EsferaDragon() {
        super(DURACION, "Esfera del dragon");
        this.guardarDireccion("file:src/fiuba/algo3/Imagenes/esfera_del_dragon.png");
    }

    @Override
    public void afectar(Personaje personaje) {
        //if( this.esPrimerUso() ) { personaje.getEquipo().ganarEsferaDragon(); }
    }

    @Override
    public void afectar(Modo modo) {
        modo.incrementarPoderPelea((float)1.25);
    }

    @Override
    public void desafectar(Personaje personaje) { }

    @Override
    public void desafectar(Modo modo) {
        modo.actualizarPoderPeleaOriginal();
    }
    
    public void pasarTurno() {
    }
    
    public void atacar(){
		this.duracionRestante -= 1;
    }
}
