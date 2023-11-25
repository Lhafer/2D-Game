package projectile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.Vector2D;
import javax.imageio.ImageIO;

import main.GamePanel;

import java.awt.Rectangle;
public class Projectile {
	BufferedImage image;
	public int speed;
	public int dmg = 4;
	public Rectangle solidArea = new Rectangle(12, 12, 24 , 24);
	public Vector2D worldPos = new Vector2D();
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
			worldPos.x = gp.player.worldPos.x;
			worldPos.y = gp.player.worldPos.y + gp.tileSize;
			break;
		case 2:
			worldPos.x = gp.player.worldPos.x;
			worldPos.y = gp.player.worldPos.y - gp.tileSize;
			break;
		case 1:
			worldPos.x = gp.player.worldPos.x;
			worldPos.y = gp.player.worldPos.y + gp.tileSize;
			break;
		case 3:
			worldPos.x = gp.player.worldPos.x - gp.tileSize;
			worldPos.y = gp.player.worldPos.y;
			break;
		case 4:
			worldPos.x = gp.player.worldPos.x + gp.tileSize;
			worldPos.y = gp.player.worldPos.y;
			break;
		}
		
	}

}


