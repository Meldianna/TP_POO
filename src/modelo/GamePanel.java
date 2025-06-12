package modelo;
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
  

    //atributos de GamePanel. Accedidos únicamente por esta clase
    public int boardWidth = 360; //pixeles de la pantalla donde se pondrán los elementos
    public int boardHeight = 640;
    private int velocidadTuberiasX = -4; //velocidad que mueve las tuberías a la izquierda para simular avance del pájaro, sobre eje X
    private int velocidadPajaroY = 0; //velocidad en la que sube o baja el pájaro sobre el eje Y
    private int gravedadPajaro= 1; //fuerza con la que cae hacia abajo
    private int openingSpace = boardHeight / 4; //espacio constante entre tubos
    //private boolean manzanaFueTocada = false;
    //private final int VELOCIDAD_NORMAL = -2;
    
    private Pajaro pajaro;
    private Puntaje puntaje;
   // private ManzanaVelocidad manzanaV;
    private ManzanaPuntaje manzanaP;
    ///si esto es muy IA, entonces podemos validar dentro de la colisión si la manzana es de un tipo u otra
    ///y aplicar el efecto

    private Background bkg;
    private ArrayList<Tuberia> tuberias; //GamePanel o Tuberia?
    private Random random = new Random(); //usado para dibujar nuevas tuberías con alturas variables

    private Timer gameLoop; //
    private Timer posTuberiasTimer; 
    //private Timer slowMotionTimer;//por cuánto tiempo se aplica el efecto slowMotion de las tuberías
    boolean gameOver = false;
    double score = 0;
    
    //cargando imágenes en atributos declarados en el constructor
    Image backgroundImg = new ImageIcon(getClass().getResource("flappybirdbg.png")).getImage();
    Image birdImg = new ImageIcon(getClass().getResource("flappybird.png")).getImage();
    Image topPipeImg = new ImageIcon(getClass().getResource("toppipe.png")).getImage();
    Image bottomPipeImg = new ImageIcon(getClass().getResource("bottompipe.png")).getImage();
   // Image manzanaVImg = new ImageIcon(getClass().getResource("manzana.png")).getImage();
    Image manzanaPImg = new ImageIcon(getClass().getResource("manzanaVerde.webp")).getImage(); //cambiar imagen
    
    public GamePanel() { //constructor de la clase
    	
    	//características del GamePanel
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

       
        this.pajaro = new Pajaro(boardWidth/8, boardHeight/2, birdImg);
        this.tuberias = new ArrayList<>();
        this.puntaje = new Puntaje(10,35);
        this.bkg = new Background(backgroundImg);
        
        //inicializadas fuera de la pantalla para evitar "nullPointerException" en paintComponent()
        this.manzanaP = new ManzanaPuntaje(-100, -100, 30, 30, manzanaPImg);
       // this.manzanaV = new ManzanaVelocidad(-100, -100, 30, 30, manzanaVImg);
        //place pipes timer
        posTuberiasTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              placePipes();
            }
        });
        posTuberiasTimer.start();
        
       
       
		//game timer
		gameLoop = new Timer(1000/60, this); //how long it takes to start timer, milliseconds gone between frames 
        gameLoop.start();
        
        
        /*timer
        slowMotionTimer = new Timer(5000, new ActionListener() { // 5000 ms = 5 segundos
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando el tiempo acaba, volvemos a la velocidad normal.
                velocidadTuberiasX = VELOCIDAD_NORMAL; 
            }
        });
        slowMotionTimer.setRepeats(false); // Muy importante: para que no se repita cada 5 seg.
    }*/
    }

    
    
   public void placePipes() {
        //(0-1) * pipeHeight/2. -> (numRandom * 512/2). Cada tubería tiene un alto de 256 px, multiplicado al número random
        
    	/*a pipeY se restan dos cosas: un valor fijo -> pipeHeight; y un numero random
    	 * Valor fijo: el tubo "comienza" en el borde superior de la pantalla hasta el número fijo, siendo 128 px
    	 * Valor random: se vuelve a restar para, esta vez, bajar más el tubo de manera aleatoria
    	 */
    	
    	
    	/*Este randomPipeY se usa como posición vertical (Y) del tubo superior.
		Al ser negativa, el tubo comienza fuera del borde superior de la pantalla y baja 
		hasta mostrarse parcialmente, generando un efecto de altura aleatoria.*/
    	
    	int randomPipeY = (int) (0 - Tuberia.ALTURA_TUBERIA/4 - Math.random()*(Tuberia.ALTURA_TUBERIA/2)); //random da un resultado tipo double
    	//(int) es para truncar el resultado double a un entero
    	
        Tuberia topPipe = new Tuberia(boardWidth, 0, topPipeImg);
        topPipe.setPosEjeY(randomPipeY);//pipe.y = randomPipeY;
        tuberias.add(topPipe); 
    
        Tuberia bottomPipe = new Tuberia(boardWidth, 0, bottomPipeImg);
        bottomPipe.setPosEjeY(topPipe.getPosEjeY() + topPipe.getAlturaTuberia() + openingSpace);
        tuberias.add(bottomPipe);
        

     
        if (!manzanaP.isVisible()) {
            
        	 // Calculamos la posición una sola vez
            int manzanaX = topPipe.getPosEjeX() + (topPipe.getAnchura() / 2) - (30 / 2); // Usamos 30 como ancho
            int centroHuecoY = topPipe.getPosEjeY() + topPipe.getAlturaTuberia() + (openingSpace / 2);
            int manzanaY = centroHuecoY - (30 / 2); // Usamos 30 como alto

                manzanaP.setPosicion(manzanaX, manzanaY);
                manzanaP.setVisible(true);
        }
        
        
       
    }


//interfaz drawable
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bkg.dibujar(g);         // Primero el fondo
	    for (Tuberia t : tuberias) {
	        t.dibujar(g);       // Luego las tuberías (array)
	    }
	    pajaro.dibujar(g);      // Luego el pájaro
	    puntaje.dibujar(g);
	    
	    //para evitar conflictos o "nullPointerExceptions"
	    
         //manzanaV.dibujar(g);
         manzanaP.dibujar(g);
            
        }

    
    public void move() {
        // --- Movimiento del Pájaro y las Tuberías (sin cambios) ---
        velocidadPajaroY += gravedadPajaro;
        pajaro.setPosEjeY(pajaro.getPosEjeY() + velocidadPajaroY);
        pajaro.setPosEjeY(Math.max(pajaro.getPosEjeY(), 0));

        for (Tuberia pipe : tuberias) {
            pipe.setPosEjeX(pipe.getPosEjeX() + velocidadTuberiasX);

            if (!pipe.isPassed() && pajaro.getPosEjeX() > pipe.getPosEjeX() + pipe.getAnchura()) {
                score += 0.5;
                pipe.setPassed(true);
            }

            if (collision(pajaro, pipe)) {
                gameOver = true;
            }
        }

        // --- LÓGICA DE MOVIMIENTO Y COLISIÓN PARA CADA MANZANA POR SEPARADO ---

        // 1. Lógica para la Manzana de Puntos (manzanaP)
        if (manzanaP.isVisible()) {
            // Mover la manzana
            manzanaP.setPosEjeX(manzanaP.getPosEjeX() + velocidadTuberiasX);

            // Comprobar colisión con el pájaro
            if (pajaro.getBounds().intersects(manzanaP.getBounds())) {
                // Aplicar el efecto específico de la manzana de puntos
                manzanaP.aplicarEfecto(this); 
            }
            
            // Comprobar si salió de la pantalla
            if (manzanaP.getPosEjeX() < -manzanaP.getAnchura()) {
                manzanaP.setVisible(false);
            }
        }

    }
   /* public void move() {
        //bird
        velocidadPajaroY += gravedadPajaro;
        pajaro.setPosEjeY(pajaro.getPosEjeY() + velocidadPajaroY);
       
        pajaro.setPosEjeY(Math.max(pajaro.getPosEjeY(), 0)); //apply gravity to current bird.y, limit the bird.y to top of the canvas

        //pipes
        for (int i = 0; i < tuberias.size(); i++) {
            Tuberia pipe = tuberias.get(i);
            pipe.setPosEjeX(pipe.getPosEjeX() + velocidadTuberiasX);
;

            if (!pipe.isPassed() && pajaro.getPosEjeX() > pipe.getPosEjeX() + pipe.anchura) {
                score += 0.5; //0.5 because there are 2 pipes! so 0.5*2 = 1, 1 for each set of pipes
                pipe.setPassed(true);
            }

            if (collision(pajaro, pipe)) {
                gameOver = true;
            }
        }

        if (pajaro.getPosEjeY() > boardHeight) {
            gameOver = true;
        }
        
        
        
    }*/
    


    boolean collision(Pajaro p, Tuberia t) {
        return p.getPosEjeX() < t.getPosEjeX()+ t.anchura &&   //a's top left corner doesn't reach b's top right corner
        		p.getPosEjeX() + p.getAnchura() > t.getPosEjeX() &&   //a's top right corner passes b's top left corner
               p.getPosEjeY() < t.getPosEjeY() + t.getAltura() &&  //a's top left corner doesn't reach b's bottom left corner
               p.getPosEjeY() + p.getAltura() > t.getPosEjeY();    //a's bottom left corner passes b's top left corner
    }

    @Override
    public void actionPerformed(ActionEvent e) { //called every x milliseconds by gameLoop timer
        move();
        puntaje.actualizar((int) score, gameOver); // Update the score object
        repaint();
        if (gameOver) {
            posTuberiasTimer.stop();
            gameLoop.stop();
           
           

        }
    } 
    

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocidadPajaroY = -9; //con cada tecla apretada, el pajaro sube 9 unidades

            if (gameOver) {
                //restart game by resetting conditions
                pajaro.setPosEjeY(boardHeight/2);
                velocidadPajaroY = 0;
                tuberias.clear();
                gameOver = false;
                score = 0;
                gameLoop.start();
                posTuberiasTimer.start();
               
                manzanaP.setVisible(false);
              
            }
        }
    }

//no son necesarias pero tienen que estar porque GamePanel implementa KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
