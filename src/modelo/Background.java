package modelo;

import java.awt.Image;

import java.awt.Graphics;


import interfaces.IDibujable;

public class Background extends Dibujo implements IDibujable{
	private int anchura;
	private int altura;
	private Image imagen;
	

	public Background(Image imagen) {
		super(0, 0, imagen); ///posEjeX y posEjeY se setean en la coordenada (0,0) de la pantalla
		///es decir, la imagen se ubica en la coordenada de pixeles (0,0). 
		this.altura = 640;
		this.anchura = 360;
		this.imagen = imagen;
	}

	@Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null);
    }

}
