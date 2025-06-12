package modelo;
import java.awt.Image;
import java.awt.Graphics;
import interfaces.IDibujable;

public class Tuberia extends Dibujo implements IDibujable{
	
	private boolean passed = false;

	public static final int ANCHURA_TUBERIA = 64; 
    public static final int ALTURA_TUBERIA = 512; 

	//para evitar bugs a la hora de sumar puntos por cada tubería pasada.
	///pensaba esto:
	///tuberia.setPassed(true); --> en GamePanel dentro del método move()
	///se tendría que modificar el método. 
	

	public Tuberia(int posEjeX, int posEjeY, int anchura, int altura, Image imagen) {
		super(posEjeX, posEjeY, anchura, altura, imagen);

		// TODO Auto-generated constructor stub
	}

	public Tuberia(int posEjeX, int posEjeY, Image img) {
		super(posEjeX, posEjeY, img);
		this.altura = ALTURA_TUBERIA;
		this.anchura = ANCHURA_TUBERIA;
		this.imagen = img;


		// TODO Auto-generated constructor stub
	}
	public Tuberia(int posEjeX, int posEjeY) {
		super(posEjeX, posEjeY);
		this.altura = ALTURA_TUBERIA;
		this.anchura = ANCHURA_TUBERIA;
		this.imagen = imagen;


		// TODO Auto-generated constructor stub
	}

	public int getAnchuraTuberia() {
		return ANCHURA_TUBERIA;
	}


	public int getAlturaTuberia() {
		return ALTURA_TUBERIA;
	}

	
	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
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
