package modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
<<<<<<< HEAD
import java.awt.Image;

import interfaces.IDibujable;
public class Puntaje extends Dibujo implements IDibujable{
=======

import interfaces.IDibujable;
public class Puntaje implements IDibujable{ //puntaje no hereda de Dibujo porque no comparte atributos. Sólo implementa el método de la interfaz
>>>>>>> dc424ba (juego refactorizado y funcional)
	//No dibuja una imagen, sino texto. el método dibujar() cambia.
	
	//Puntaje necesita saber si el juego ha terminado para poder cambiar la forma en que se dibuja el texto (de "12" a "Game Over: 12").
	private boolean gameOver = false;
	private int puntajeActual = 0;
<<<<<<< HEAD

	
	public Puntaje(int posEjeX, int posEjeY) {
		super(posEjeX, posEjeY, 0, 0, null);//no necesita ancho ni alto (valores en 0) y tampoco una imagen(valor null)
=======
	private int posEjeX;
	private int posEjeY;
	

	
	public Puntaje(int posEjeX, int posEjeY) {
		this.posEjeX = posEjeX;
		this.posEjeY = posEjeY;
>>>>>>> dc424ba (juego refactorizado y funcional)
		//gameOver y puntaleActual ya se inicializan antes
	}

	@Override
    public void dibujar(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        
        String texto;
        if (gameOver) {
            texto = "Game Over: " + puntajeActual;
        } else {//(*)
            texto = String.valueOf(puntajeActual);
        }
        g.drawString(texto, posEjeX, posEjeY); //drawString(String str, int x, int y)
    }

	//(*) a. `puntajeActual`: Es un número entero (int). En nuestro ejemplo, su valor es 5.
    // b. `String.valueOf(...)`: Es una función de Java que convierte un número en texto.
    //    ¿Por qué? Porque el método para dibujar en pantalla (`drawString`) solo acepta texto (String),
    //    no puede dibujar un número directamente.
    // c. `texto = ...`: El resultado de la conversión (el texto "5") se guarda en la variable `texto`.
    //    Ahora, la variable 'texto' contiene el valor "5".
     
	//es importante conoceer el estado del juego dependiendo del estado de gameOver y poder dibujar el texto correcto
	///a su vez, pensaba que GamePanel tenga una variable score y luego se la pase como parametro a puntaje mediante el metodo actualizar():
	///score += 0.5; // Se suma 0.5 por cada tubería (superior e inferior)
    public void actualizar(int puntaje, boolean gameOver) {
        this.puntajeActual = puntaje;
        this.gameOver = gameOver;
    }

    
	
<<<<<<< HEAD
}
=======
}
>>>>>>> dc424ba (juego refactorizado y funcional)
