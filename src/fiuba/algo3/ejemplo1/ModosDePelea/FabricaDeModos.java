package fiuba.algo3.ejemplo1.ModosDePelea;

import java.util.function.Function;

import fiuba.algo3.ejemplo1.Excepciones.TransformacionInexistente;
import fiuba.algo3.ejemplo1.juego.Ataque;

public class FabricaDeModos {
	
	public Modo transformacionInvalida(){
		throw new TransformacionInexistente();
	}
	
	public Modo gokuNormal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.gokuKaioKen();};
		Ataque ataque = new Ataque(20, 2);
		Modo goku = new Modo (ataque, 2, 0, transformacion);
		goku.guardarDireccion("file:src/fiuba/algo3/Imagenes/Goku_normal.png");
		return goku;
	}
	
	public Modo gokuKaioKen(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.gokuSuperSaiyajin();};
		Ataque ataque = new Ataque(40, 4);
		Modo kaioKen = new Modo (ataque, 3, 20, transformacion);
		kaioKen.guardarDireccion("file:src/fiuba/algo3/Imagenes/Goku_kaioken.png");
		return kaioKen;
	}
	
	public Modo gokuSuperSaiyajin(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.transformacionInvalida();};
		Ataque ataque = new Ataque(60, 4);
		Modo superSaiyajin = new Modo (ataque, 5, 50, transformacion);
		superSaiyajin.guardarDireccion("file:src/fiuba/algo3/Imagenes/Goku_ssj.png");
		return superSaiyajin;
	}
	
	public Modo gohanNormal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.gohanSuperSaiyajin();};
		Ataque ataque = new Ataque(15, 2);
		Modo gohan = new Modo (ataque, 2, 0, transformacion);
		gohan.guardarDireccion("file:src/fiuba/algo3/Imagenes/Gohan.png");
		return gohan;
	}
	
	public Modo gohanSuperSaiyajin(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.gohanSuperSaiyajin2();};
		Ataque ataque = new Ataque(30, 2);
		Modo superSaiyajin = new Modo (ataque, 2, 10, transformacion);
		superSaiyajin.guardarDireccion("file:src/fiuba/algo3/Imagenes/Gohan_SSJ.png");
		return superSaiyajin;
	}
	
	//falta verificar la vida de los aliados
	public Modo gohanSuperSaiyajin2(){
		Modo superSaiyajin2 = new GohanSSJ2 ();
		return superSaiyajin2;
	}
	
	public Modo piccoloNormal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.piccoloFortalecido();};
		Ataque ataque = new Ataque(20, 2);
		Modo piccolo = new Modo (ataque, 2, 0, transformacion);
		piccolo.guardarDireccion("file:src/fiuba/algo3/Imagenes/Piccolo.png");
		return piccolo;
	}
	
	public Modo piccoloFortalecido(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.piccoloProtector();};
		Ataque ataque = new Ataque(40, 4);
		Modo piccolo = new Modo (ataque, 3, 20, transformacion);
		piccolo.guardarDireccion("file:src/fiuba/algo3/Imagenes/Piccolo_fortalecido.png");
		return piccolo;
	}
	
	//falta verificar la vida de Gohan
	public Modo piccoloProtector(){
		Modo piccolo = new PiccoloProtector ();
		return piccolo;
	}
	
	public Modo cellNormal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.cellSemiPerfecto();};
		Ataque ataque = new Ataque(20, 3);
		Modo cell = new Modo (ataque, 2, 0, transformacion);
		cell.guardarDireccion("file:src/fiuba/algo3/Imagenes/cell.png");
		return cell;
	}
	
	//falta verificar las absorciones
	public Modo cellSemiPerfecto(){
		CellSemiPerfecto cell = new CellSemiPerfecto();
		return cell;
	}
	
	//falta verificar las absorciones
	public Modo cellPerfecto(){
		CellPerfecto cell = new CellPerfecto ();
		return cell;
	}
	
	public Modo freezerNormal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.freezerSegundaForma();};
		Ataque ataque = new Ataque(20, 2);
		Modo freezer = new Modo (ataque, 4, 0, transformacion);
		freezer.guardarDireccion("file:src/fiuba/algo3/Imagenes/Freezer.png");
		return freezer;
	}
	
	public Modo freezerSegundaForma(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.freezerDefinitivo();};
		Ataque ataque = new Ataque(40, 3);
		Modo freezer = new Modo (ataque, 4, 20, transformacion);
		freezer.guardarDireccion("file:src/fiuba/algo3/Imagenes/Freezer_segunda_forma.png");
		return freezer;
	}
	
	public Modo freezerDefinitivo(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.transformacionInvalida();};
		Ataque ataque = new Ataque(50, 3);
		Modo freezer = new Modo (ataque, 6, 50, transformacion);
		freezer.guardarDireccion("file:src/fiuba/algo3/Imagenes/Freezer_Definitivo.png");
		return freezer;
	}
	
	public Modo majinBooNormal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.majinBooMalo();};
		Ataque ataque = new Ataque(30, 2);
		Modo majin = new Modo (ataque, 2, 0, transformacion);
		majin.guardarDireccion("file:src/fiuba/algo3/Imagenes/majin_boo.png");
		return majin;
	}
	
	public Modo majinBooMalo(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.majinBooOriginal();};
		Ataque ataque = new Ataque(50, 2);
		Modo majin = new Modo (ataque, 3, 20, transformacion);
		majin.guardarDireccion("file:src/fiuba/algo3/Imagenes/majin_boo_malo.png");
		return majin;
	}
	
	public Modo majinBooOriginal(){
		Function <FabricaDeModos, Modo> transformacion;
		transformacion = (FabricaDeModos fabrica) -> 
		{return fabrica.transformacionInvalida();};
		Ataque ataque = new Ataque(60, 3);
		Modo majin = new Modo (ataque, 4, 50, transformacion);
		majin.guardarDireccion("file:src/fiuba/algo3/Imagenes/majin_boo_original.png");
		return majin;
	}
	
	//agregar la imposibilidad de ganar ki
	/*public Modo chocolate(){
		Modo chocolate = new Modo(0, 0, 0, 0);
		return chocolate;
	}*/
}
