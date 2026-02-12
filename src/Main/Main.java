package Main;

import javax.swing.JFrame;

public class Main {
	public static void main (String[] args) {
JFrame tela = new JFrame();
tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
tela.setResizable(false);
tela.setTitle("Azoiaf");

GamePanel gamePanel = new GamePanel();
tela.add(gamePanel);
tela.pack();


tela.setLocationRelativeTo(null);
tela.setVisible(true);

gamePanel.startGameThread();

}
}