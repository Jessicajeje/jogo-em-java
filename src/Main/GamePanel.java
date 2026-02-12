package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entidade.Player;

public class GamePanel extends JPanel implements Runnable{
//config de tela
	//determinação de variáveis
	final int originalTileSize = 16;
	final int escala = 3;
	public final int tileSize = originalTileSize * escala;//48x48
	
	final int maxColunas = 20;
	final int maxLinhas = 16;
	final int telaWidth = tileSize * maxColunas;//960
	final int telaHeight = tileSize * maxLinhas;//
	
	Teclado tec = new Teclado();
	Thread gameThread;
	Player player = new Player(this,tec);
	
	//colocar posição do player
	int playerX = 450;
	int playerY = 300;
	int playerSpeed = 4;
	
	//FPS
	final int FPS = 60;
	
	//construtores
	public GamePanel() {
		this.setPreferredSize(new Dimension(telaWidth, telaHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(tec);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
	 gameThread = new Thread(this);
	 gameThread.start();
	 this.requestFocusInWindow();
	}

	@Override
	public void run() {
		 double drawInterval = 1000000000 / FPS; // 0.01666 segundos
		    double delta = 0;
		    long lastTime = System.nanoTime();
		    long currentTime;

		    while(gameThread != null) {
		        currentTime = System.nanoTime();
		        
		        // Calcula quanto tempo passou desde o último frame
		        delta += (currentTime - lastTime) / drawInterval;
		        lastTime = currentTime;

		        if(delta >= 1) {
		            update();
		            repaint();
		            delta--; // "Consome" o tempo processado
		}
		    }
		
	}
	public void update() {
		player.update();
	}
	public void paintComponent(Graphics g) {
		//player caracther
		super.paintComponent(g);//não entendi o que isso faz
		
		Graphics2D g2 = (Graphics2D)g;
		
		
		player.draw(g2);
		g2.dispose();
		
	}
	
}
