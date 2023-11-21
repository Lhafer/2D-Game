package object;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import main.GamePanel;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public int worldX, worldY;
	public boolean collision = false;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultY = 0;
	public int solidAreaDefaultX = 0;
	
	
	public void drawObjects(Graphics2D g2, GamePanel gp) {
		solidArea.width = gp.tileSize;
		solidArea.height = gp.tileSize;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		if(worldX < gp.player.worldX + gp.player.screenX + gp.tileSize
			&& worldX > gp.player.worldX - gp.player.screenX - gp.tileSize
			&& worldY > gp.player.worldY - gp.player.screenY - gp.tileSize
			&& worldY < gp.player.worldY + gp.player.screenY + gp.tileSize) { //check that the tiles we 
																	//are drawing are within
																	//our screen so that we dont draw
																	//tiles we cant see to save on processing power
			
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}
	}
}
