package modelo;
import java.awt.Graphics;
import java.awt.Image;

<<<<<<< HEAD
///Se hace esta clase Dibujo para quitarle la tarea al GamePanel de dibujar cada imagen y hacerlo más prolijo 
///ahora no le importa cómo se dibuja cada elemento.
public abstract class Dibujo{
=======
import java.awt.Image;

public abstract class Dibujo {
>>>>>>> dc424ba (juego refactorizado y funcional)
	protected int posEjeX;
	protected int posEjeY;
	protected int anchura;
	protected int altura;
<<<<<<< HEAD
	protected Image imagen; //imagen a dibujar (usada en GamePanel)

	public Dibujo(int posEjeX, int posEjeY, int anchura, int altura, Image imagen) {
=======
	protected Image imagen;
	
	
	public Dibujo(int posEjeX, int posEjeY, int anchura, int altura, Image img) {
>>>>>>> dc424ba (juego refactorizado y funcional)
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
		this.anchura = anchura;
		this.altura = altura;
<<<<<<< HEAD
		this.imagen = imagen;
	}

=======
		this.imagen = img;
	}

	//mejor usar este, porque sabemos que la anchura y altura se "hard-codean"
	public Dibujo(int posEjeX, int posEjeY, Image img) {
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
		this.imagen = img;
	}
	public Dibujo(int posEjeX, int posEjeY) {
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
		this.imagen = imagen;

	}


>>>>>>> dc424ba (juego refactorizado y funcional)
	public int getPosEjeX() {
		return posEjeX;
	}


	public void setPosEjeX(int posEjeX) {
		this.posEjeX = posEjeX;
	}


	public int getPosEjeY() {
		return posEjeY;
	}


	public void setPosEjeY(int posEjeY) {
		this.posEjeY = posEjeY;
	}


	public int getAnchura() {
		return anchura;
	}


	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	
}
