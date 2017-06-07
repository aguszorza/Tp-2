package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.Personaje.Modo;
import fiuba.algo3.ejemplo1.Personaje.Personaje;

public abstract class Consumible {

    private int duracionTotalEfecto;
    protected int duracionRestante;

    protected Consumible(int duracionEfecto) {
        this.duracionTotalEfecto = duracionEfecto;
        this.duracionRestante = duracionEfecto;
    }

    public abstract void afectar(Personaje personaje);
    public abstract void afectar(Modo modo);

    public abstract void desafectar(Personaje personaje);
    public abstract void desafectar(Modo modo);

    protected boolean esPrimerUso() {
        return this.duracionRestante == this.duracionTotalEfecto;
    }

    public void usarConsumible() {
        this.duracionRestante -= 1;
    }
    public boolean caducoEfecto() {
        return this.duracionRestante == 0;
    }
}
