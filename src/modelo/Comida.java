package modelo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import interfaces.IDibujable;
public class Comida extends Dibujo implements IDibujable {
	private int velocidadX;
	

	    public Comida(int posEjeX, int posEjeY, int ancho, int alto, Image imagen) {
	        super(posEjeX, posEjeY, ancho, alto, imagen);
	        this.velocidadX = velocidadX;
	    }

	    @Override
	    public void dibujar(Graphics g) {
	        g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null);
	    }
	    
	   
	    public void setPosicion(int x, int y) {
	        this.posEjeX = x;
	        this.posEjeY = y;
	    }

	    
	}



