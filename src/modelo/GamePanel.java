package modelo;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360; //pixeles de la pantalla donde se pondrán los elementos
    int boardHeight = 640;

    //images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;
    
    //bird class
    //mismos comentarios que con la clase tubería
    /*
     * CLASE BIRD */
    
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;  //scaled by 1/6
    int pipeHeight = 512;
  // estos atributos pueden ir en la clase tubería

    /*CLASE TUBERÍA*/
    class Pipe {
        int x = pipeX; //refactorizarse a tuberiaX = boardWidth
        int y = pipeY; //refactorizarse a tuberiaY = 0 --> indica que la imagen comienza en el borde superior de la pantalla
        int width = pipeWidth;  //refactorizarse a anchuraTuberia = numero
        int height = pipeHeight; //refactorizarse a alturaTuberia = numero. 
        //Hay que pensar que para asignar el alto de la tuberia, 
        //tenemos que definir cuánto espacio hay para que pase el pájaro
        Image img;
        boolean passed = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    //game logic
    /*atributos de GamePanel
     * */
    Bird bird;
    int velocityX = -2; //move pipes to the left speed (simulates bird moving right
    int velocityY = 0; //move bird up/down speed.
    int gravity = 1; //fuerza con la que cae hacia abajo

    ArrayList<Pipe> pipes; //GamePanel o Tuberia?
    Random random = new Random();

    Timer gameLoop;
    Timer placePipeTimer;
    boolean gameOver = false;
    double score = 0;

    GamePanel() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("bottompipe.png")).getImage();

        
        //puede ser simplemente 
        //Bird bird = new Bird(birdImg) y ArrayList<Pipe> pipes = new ArrayList<Pipe>;
        bird = new Bird(birdImg);
        pipes = new ArrayList<Pipe>();

        //place pipes timer
        placePipeTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // Code to be executed
              placePipes();
            }
        });
        placePipeTimer.start();
        
		//game timer
		gameLoop = new Timer(1000/60, this); //how long it takes to start timer, milliseconds gone between frames 
        gameLoop.start();
	}
    
    //método de clase Tuberia
    void placePipes() {
        //(0-1) * pipeHeight/2. -> (numRandom * 512/2). Cada tubería tiene un alto de 256 px, multiplicado al número random
        
    	/*a pipeY se restan dos cosas: un valor fijo -> pipeHeight; y un numero random
    	 * Valor fijo: el tubo "comienza" en el borde superior de la pantalla hasta el número fijo, siendo 128 px
    	 * Valor random: se vuelve a restar para, esta vez, bajar más el tubo de manera aleatoria
    	 */
    	
    	
    	/*Este randomPipeY se usa como posición vertical (Y) del tubo superior.
		Al ser negativa, el tubo comienza fuera del borde superior de la pantalla y baja 
		hasta mostrarse parcialmente, generando un efecto de altura aleatoria.*/
    	
    	int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2)); //random da un resultado tipo double
    	//(int) es para truncar el resultado double a un entero
    	
        int openingSpace = boardHeight/4; //espacio entre tubos, constante
    
        
        
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe); 
    
        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y  + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }
    
//interfaz drawable
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
        //background
        g.drawImage(backgroundImg, 0, 0, this.boardWidth, this.boardHeight, null);

        //bird
        g.drawImage(birdImg, bird.x, bird.y, bird.width, bird.height, null);

        //pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        //score
        g.setColor(Color.white);

        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
        }
        else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
        
	}

    public void move() {
        //bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0); //apply gravity to current bird.y, limit the bird.y to top of the canvas

        //pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;

            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                score += 0.5; //0.5 because there are 2 pipes! so 0.5*2 = 1, 1 for each set of pipes
                pipe.passed = true;
            }

            if (collision(bird, pipe)) {
                gameOver = true;
            }
        }

        if (bird.y > boardHeight) {
            gameOver = true;
        }
    }

    boolean collision(Bird a, Pipe b) {
        return a.x < b.x + b.width &&   //a's top left corner doesn't reach b's top right corner
               a.x + a.width > b.x &&   //a's top right corner passes b's top left corner
               a.y < b.y + b.height &&  //a's top left corner doesn't reach b's bottom left corner
               a.y + a.height > b.y;    //a's bottom left corner passes b's top left corner
    }

    @Override
    public void actionPerformed(ActionEvent e) { //called every x milliseconds by gameLoop timer
        move();
        repaint();
        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }  

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // System.out.println("JUMP!");
            velocityY = -9; //con cada tecla apretada, el pajaro sube 9 unidades

            if (gameOver) {
                //restart game by resetting conditions
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                gameOver = false;
                score = 0;
                gameLoop.start();
                placePipeTimer.start();
            }
        }
    }

    //not needed
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
