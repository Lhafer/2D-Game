package projectile;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

import java.awt.Rectangle;
public class Projectile {
	BufferedImage image;
	public int speed;
	public int dmg = 4;
	public Rectangle solidArea = new Rectangle(12, 12, 24 , 24);
	public int worldX;
	public int worldY;
	public int direction;
	public int solidAreaDefaultX = 12;
	public int solidAreaDefaultY = 12;
	
	public Projectile(GamePanel gp) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/eye_open.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		speed = gp.player.projSpeed; 
		direction = gp.player.direction;
		
		switch(direction) {
		case 0:
			worldX = gp.player.worldX;
			worldY = gp.player.worldY + gp.tileSize;
			break;
		case 2:
			worldX = gp.player.worldX;
			worldY = gp.player.worldY - gp.tileSize;
			break;
		case 1:
			worldX = gp.player.worldX;
			worldY = gp.player.worldY + gp.tileSize;
			break;
		case 3:
			worldX = gp.player.worldX - gp.tileSize;
			worldY = gp.player.worldY;
			break;
		case 4:
			worldX = gp.player.worldX + gp.tileSize;
			worldY = gp.player.worldY;
			break;
		}
		
	}

}


