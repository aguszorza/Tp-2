package fiuba.algo3.ejemplo1.Excepciones;

public class PosicionFueraDelTablero extends RuntimeException{

	public PosicionFueraDelTablero(String mensaje){
		super(mensaje);
	}
}
