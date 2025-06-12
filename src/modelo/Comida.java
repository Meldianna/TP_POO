package modelo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import interfaces.IDibujable;
public abstract class Comida extends Dibujo implements IDibujable {

		private boolean isVisible;
		
	   

		public Comida(int posEjeX, int posEjeY, int ancho, int alto, Image imagen) {
	        super(posEjeX, posEjeY, ancho, alto, imagen);  
	        this.isVisible = false;
	    }

	    @Override
	    public void dibujar(Graphics g) {
	        if (isVisible) {
	            g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null);
	        }
	    }
		
	  //cuando este método se invoca, quiere decir que la manzana es consumida
	    public abstract void aplicarEfecto(GamePanel gp); //tipo objeto porque cada manzana modifica uno distinto
	    
	    
	    
	    public void setPosicion(int x, int y) {
	        this.posEjeX = x;
	        this.posEjeY = y;
	    }

	    public boolean isVisible() {
			return isVisible;
		}

		public void setVisible(boolean isVisible) {
			this.isVisible = isVisible;
		}

		public Rectangle getBounds() {
			
				return new Rectangle(posEjeX, posEjeY, anchura, altura);
		}
	}





