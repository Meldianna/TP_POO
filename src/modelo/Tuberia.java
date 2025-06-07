package modelo;
import java.awt.Image;
import java.awt.Graphics;
import interfaces.IDibujable;

public class Tuberia extends Dibujo implements IDibujable{
	
	private boolean passed = false;
	//para evitar bugs a la hora de sumar puntos por cada tubería pasada.
	///pensaba esto:
	///tuberia.setPassed(true); --> en GamePanel dentro del método move()
	///se tendría que modificar el método. 
	
	public Tuberia(int posEjeX, int posEjeY, int anchura, int altura, Image imagen) {
		super(posEjeX, posEjeY, anchura, altura, imagen);

		// TODO Auto-generated constructor stub
	}

	@Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null); ///drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
    }

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	
	
	
	

}
