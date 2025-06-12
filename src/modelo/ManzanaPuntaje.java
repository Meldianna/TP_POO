package modelo;

import java.awt.Image;

public class ManzanaPuntaje extends Comida{

	public ManzanaPuntaje(int posEjeX, int posEjeY, int ancho, int alto, Image imagen) {
		super(posEjeX, posEjeY, ancho, alto, imagen);
		
	}

	@Override
	public void aplicarEfecto(GamePanel gp) { //suma 1 al puntaje
		gp.score +=1;
		this.setVisible(false); // Desaparece después de ser consumida
		
	}
	
	

}
