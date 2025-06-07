package modelo;

import java.awt.Image;
import java.awt.Graphics;

import interfaces.IDibujable;

public class Background extends Dibujo implements IDibujable{

	

	public Background(int posEjeX, int posEjeY, int anchura, int altura, Image imagen) {
		super(0, 0, anchura, altura, imagen); ///posEjeX y posEjeY se setean en la coordenada (0,0) de la pantalla
		///es decir, la imagen se ubica en la coordenada de pixeles (0,0). 
		this.altura = altura;
		this.anchura = anchura;
		this.imagen = imagen;
	}

	@Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null);
    }

}
