package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;

import javax.swing.JPanel;

import object.SuperObject;
import projectile.ProjectileManager;
import entity.Entity;
import entity.Player;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{

	
	// SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 2;

	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 60;
	public final int maxScreenRow = 30;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;


	int FPS = 60;

	
	//SYSTEM
	KeyHandler keyH = new KeyHandler();
	public TileManager tileM = new TileManager(this);
	public CollisionChecker colCheck = new CollisionChecker(this);
	public ProjectileManager projM = new ProjectileManager(this);
	public Sound sound = new Sound();
	public Sound se = new Sound();
	public UI ui = new UI(this);
	Thread gameThread;
	
	//ENTITY AND OBJECT
	public SuperObject obj[] = new SuperObject[15];
	public AssetSetter assSet = new AssetSetter(this);
	public Player player = new Player(this,keyH);
	public Entity npc[] = new Entity[10];
	
	
	public GamePanel () {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void gameSetup() {
		
		assSet.setObject();
		assSet.setNPC();
		playMusic(2);
		
	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}


	@Override
	public void run() {

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;

			if(delta >= 1) {

			update();
			repaint();
			delta--;

			}

			
		}
	}
	public void update() {

		player.update();
		projM.update();
		for(int i = 0; i < npc.length; i++) {
			if(npc[i]!= null) npc[i].update(player);
		}
		

	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		tileM.draw(g2);
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) obj[i].drawObjects(g2, this);
		}
		for(int i = 0; i < npc.length; i++) {
			if(npc[i] != null) npc[i].draw(g2);
		}
		
		
		for (int i = 0; i < projM.projectiles.length; i++) {
			projM.draw(g2, projM.projectiles[i]);
		}
		player.draw(g2);
		ui.draw(g2);
		
		g2.dispose();
	}
	
	
	public void playMusic(int i) {

		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	public void stopMusic() {
		sound.stop();
	}
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}