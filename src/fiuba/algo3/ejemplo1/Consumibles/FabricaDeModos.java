package fiuba.algo3.ejemplo1.Consumibles;

import fiuba.algo3.ejemplo1.Personaje.Modo;

public class FabricaDeModos {

	
	public Modo gokuNormal(){
		Modo goku = new Modo (20, 2, 2);
		return goku;
	}
	
	public Modo gokuKaioKen(){
		Modo kaioKen = new Modo (40, 4, 3);
		return kaioKen;
	}
	
	public Modo gokuSuperSaiyajin(){
		Modo superSaiyajin = new Modo (60, 4, 5);
		return superSaiyajin;
	}
	
	public Modo gohanNormal(){
		Modo gohan = new Modo (15, 2, 2);
		return gohan;
	}
	
	public Modo gohanSuperSaiyajin(){
		Modo superSaiyajin = new Modo (30, 4, 3);
		return superSaiyajin;
	}
	
	public Modo gohanSuperSaiyajin2(){
		Modo superSaiyajin2 = new Modo (100, 4, 3);
		return superSaiyajin2;
	}
	
	public Modo piccoloNormal(){
		Modo piccolo = new Modo (20, 2, 2);
		return piccolo;
	}
	
	public Modo piccoloFortalecido(){
		Modo piccolo = new Modo (40, 4, 3);
		return piccolo;
	}
	
	public Modo piccoloProtector(){
		Modo piccolo = new Modo (60, 6, 4);
		return piccolo;
	}
	
	public Modo cellNormal(){
		Modo cell = new Modo (20, 3, 2);
		return cell;
	}
	
	public Modo cellSemiPerfecto(){
		Modo cell = new Modo (40, 4, 3);
		return cell;
	}
	
	public Modo cellPerfecto(){
		Modo cell = new Modo (80, 4, 4);
		return cell;
	}
	
	public Modo freezerNormal(){
		Modo freezer = new Modo (20, 2, 4);
		return freezer;
	}
	
	public Modo freezerSegundaForma(){
		Modo freezer = new Modo (40, 3, 4);
		return freezer;
	}
	
	public Modo freezerDefinitivo(){
		Modo freezer = new Modo (50, 3, 6);
		return freezer;
	}
	
	public Modo majinBooNormal(){
		Modo majin = new Modo (30, 2, 2);
		return majin;
	}
	
	public Modo majinBooMalo(){
		Modo majin = new Modo (50, 2, 3);
		return majin;
	}
	
	public Modo majinBooOriginal(){
		Modo majin = new Modo (60, 3, 4);
		return majin;
	}
	
	//agregar la imposibilidad de ganar ki
	public Modo chocolate(){
		Modo chocolate = new Modo(0, 0, 0);
		return chocolate;
	}
}
