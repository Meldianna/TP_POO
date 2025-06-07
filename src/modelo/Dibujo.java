package modelo;

public abstract class Dibujo {
	protected int posEjeX;
	protected int posEjeY;
	
	protected int anchura;
	protected int altura;
	
	
	public Dibujo(int posEjeX, int posEjeY, int anchura, int altura) {
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
		this.anchura = anchura;
		this.altura = altura;
	}

	//mejor usar este, porque sabemos que la anchura y altura del dibujo es una sola
	public Dibujo(int posEjeX, int posEjeY) {
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
		this.anchura = anchura;
		this.altura = altura;
	}


	public int getPosEjeX() {
		return posEjeX;
	}


	public void setPosEjeX(int posEjeX) {
		this.posEjeX = posEjeX;
	}


	public int getPosEjeY() {
		return posEjeY;
	}


	public void setPosEjeY(int posEjeY) {
		this.posEjeY = posEjeY;
	}


	public int getAnchura() {
		return anchura;
	}


	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	
}
