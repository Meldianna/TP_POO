package modelo;

import java.awt.Image;
import java.awt.Graphics;

import interfaces.IDibujable;

public class Pajaro extends Dibujo implements IDibujable{
	
	 private int anchuraPajaro = 34;
	 private int alturaPajaro = 24;


	 public Pajaro(int x, int y, int anchura, int altura, Image img) {
	        super(x, y, anchura, altura, img);
	    }


	 
	 public Pajaro(int x, int y, Image img) {
	        super(x, y, img);
	        this.anchura = anchuraPajaro;
	        this.altura = alturaPajaro;
	        
	 }
	 public int getAnchuraPajaro() {
		return anchuraPajaro;
	}


	public void setAnchuraPajaro(int anchuraPajaro) {
		this.anchuraPajaro = anchuraPajaro;
	}


	public int getAlturaPajaro() {
		return alturaPajaro;
	}


	public void setAlturaPajaro(int alturaPajaro) {
		this.alturaPajaro = alturaPajaro;
	}


	@Override
	public void dibujar(Graphics g) {
		g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null);
		
	}

}

	
