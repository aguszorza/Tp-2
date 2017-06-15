package fiuba.algo3.ejemplo1.juego;

import fiuba.algo3.ejemplo1.Personaje.Personaje;

public class Atacar extends Accion {
	
	public void realizar(Personaje atacante){
		Personaje enemigo = this.controlador.seleccionarPersonajeEnemigo() ;
		this.controlador.verificarAtaque(atacante,enemigo);
		atacante.atacar(enemigo);
	}
	
}
