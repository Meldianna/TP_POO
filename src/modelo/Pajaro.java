package modelo;

import java.awt.*;

public class Pajaro extends Dibujo{
	
	 private int anchuraPajaro = 34;
	 private int alturaPajaro = 24;
	 Image imagen;

	public Pajaro(int posEjeX, int posEjeY, Imagen imagen) {
		super(posEjeX, posEjeY);
		this.alturaPajaro = alturaPajaro;
		this.anchuraPajaro = anchuraPajaro;
		this.imagen = imagen;
		
		// TODO Auto-generated constructor stub
	}
}
/*
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
   

    public Pajaro(anchuraPantalla, alturaPantalla) {
        int  = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;
    }*/
	

