package Entidade;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.GamePanel;
import Main.Teclado;

public class Player extends Entidade{
	GamePanel gp;
	Teclado tec;
	
	public Player(GamePanel gp, Teclado tec) {// não entendi
		this.gp = gp;
		this.tec = tec;
		
		setDefaultValue();
	}

	public void setDefaultValue() {
		x = 100;
		y = 100;
		speed = 4;
	}
	public void  update() {
		if(tec.cima == true) {
			y -= speed;
		}
		else if(tec.baixo == true) {
			y += speed;
		}
		else if(tec.esquerda == true) {
			x -= speed;
		}
		else if(tec.direita == true) {
			x += speed;
		}
	}
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x,y, gp.tileSize, gp.tileSize);
	}
}
