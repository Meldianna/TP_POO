package modelo;
import java.awt.Image;
import java.awt.Graphics;
import interfaces.IDibujable;

public class Tuberia extends Dibujo implements IDibujable{
	
	private boolean passed = false;
<<<<<<< HEAD
=======
	public static final int ANCHURA_TUBERIA = 64; 
    public static final int ALTURA_TUBERIA = 512; 
>>>>>>> dc424ba (juego refactorizado y funcional)
	//para evitar bugs a la hora de sumar puntos por cada tubería pasada.
	///pensaba esto:
	///tuberia.setPassed(true); --> en GamePanel dentro del método move()
	///se tendría que modificar el método. 
	
<<<<<<< HEAD
	public Tuberia(int posEjeX, int posEjeY, int anchura, int altura, Image imagen) {
		super(posEjeX, posEjeY, anchura, altura, imagen);

		// TODO Auto-generated constructor stub
	}
=======
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
>>>>>>> dc424ba (juego refactorizado y funcional)

	@Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, posEjeX, posEjeY, anchura, altura, null); ///drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
    }
<<<<<<< HEAD

=======
	
>>>>>>> dc424ba (juego refactorizado y funcional)
	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	
	
	
	

}
