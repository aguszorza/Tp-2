package fiuba.algo3.ejemplo1.Personaje;

public class FabricaDeModos {

	private int obtenerConsumoDeKi(Modo modoActual, int nuevoAtaque, int costoKi){
		if(modoActual.obtenerPoderDePelea() < nuevoAtaque)
			return costoKi;
		return 0;
	}
	
	public Modo gokuNormal(){
		Modo goku = new Modo (20, 2, 2, 0);
		return goku;
	}
	
	public Modo gokuKaioKen(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 40, 20);
		Modo kaioKen = new Modo (40, 4, 3, costoKi);
		return kaioKen;
	}
	
	public Modo gokuSuperSaiyajin(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 60, 50);
		Modo superSaiyajin = new Modo (60, 4, 5, costoKi);
		return superSaiyajin;
	}
	
	public Modo gohanNormal(){
		Modo gohan = new Modo (15, 2, 2, 0);
		return gohan;
	}
	
	public Modo gohanSuperSaiyajin(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 30, 10);
		Modo superSaiyajin = new Modo (30, 2, 2, costoKi);
		return superSaiyajin;
	}
	
	//falta verificar la vida de los aliados
	public Modo gohanSuperSaiyajin2(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 100, 30);
		Modo superSaiyajin2 = new Modo (100, 4, 3, costoKi);
		return superSaiyajin2;
	}
	
	public Modo piccoloNormal(){
		Modo piccolo = new Modo (20, 2, 2, 0);
		return piccolo;
	}
	
	public Modo piccoloFortalecido(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 40, 20);
		Modo piccolo = new Modo (40, 4, 3, costoKi);
		return piccolo;
	}
	
	//falta verificar la vida de Gohan
	public Modo piccoloProtector(){
		Modo piccolo = new Modo (60, 6, 4, 0);
		return piccolo;
	}
	
	public Modo cellNormal(){
		Modo cell = new Modo (20, 3, 2, 0);
		return cell;
	}
	
	//falta verificar las absorciones
	public Modo cellSemiPerfecto(){
		Modo cell = new Modo (40, 4, 3, 0);
		return cell;
	}
	
	//falta verificar las absorciones
	public Modo cellPerfecto(){
		Modo cell = new Modo (80, 4, 4, 0);
		return cell;
	}
	
	public Modo freezerNormal(){
		Modo freezer = new Modo (20, 2, 4, 0);
		return freezer;
	}
	
	public Modo freezerSegundaForma(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 40, 20);
		Modo freezer = new Modo (40, 3, 4, costoKi);
		return freezer;
	}
	
	public Modo freezerDefinitivo(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 50, 50);
		Modo freezer = new Modo (50, 3, 6, costoKi);
		return freezer;
	}
	
	public Modo majinBooNormal(){
		Modo majin = new Modo (30, 2, 2, 0);
		return majin;
	}
	
	public Modo majinBooMalo(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 50, 20);
		Modo majin = new Modo (50, 2, 3, costoKi);
		return majin;
	}
	
	public Modo majinBooOriginal(Modo modoActual){
		int costoKi = this.obtenerConsumoDeKi(modoActual, 60, 50);
		Modo majin = new Modo (60, 3, 4, costoKi);
		return majin;
	}
	
	//agregar la imposibilidad de ganar ki
	public Modo chocolate(){
		Modo chocolate = new Modo(0, 0, 0, 0);
		return chocolate;
	}
}
