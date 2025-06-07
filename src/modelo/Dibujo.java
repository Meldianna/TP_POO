package modelo;
import java.awt.Graphics;
import java.awt.Image;

///Se hace esta clase Dibujo para quitarle la tarea al GamePanel de dibujar cada imagen y hacerlo más prolijo 
///ahora no le importa cómo se dibuja cada elemento.
public abstract class Dibujo{
	protected int posEjeX;
	protected int posEjeY;
	protected int anchura;
	protected int altura;
	protected Image imagen; //imagen a dibujar (usada en GamePanel)

	public Dibujo(int posEjeX, int posEjeY, int anchura, int altura, Image imagen) {
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
		this.anchura = anchura;
		this.altura = altura;
		this.imagen = imagen;
	}

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
