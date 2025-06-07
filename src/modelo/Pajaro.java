package modelo;

import java.awt.Image;
import java.awt.Graphics;

import interfaces.IDibujable;

public class Pajaro extends Dibujo implements IDibujable{
	
	 private int anchuraPajaro = 34;
	 private int alturaPajaro = 24;
	 Image imagen;

	 public Pajaro(int x, int y, int anchura, int altura, Image img) {
	        super(x, y, anchura, altura, img);
	    }

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null);
		
	}

}

	

