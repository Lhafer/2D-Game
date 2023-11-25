package object;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import main.GamePanel;

public class Eye_Obj extends SuperObject{
	int spriteCounter = 0;
	int spriteNum = 0;
	BufferedImage image2;
	BufferedImage image3;
	public Eye_Obj() {
		collision = true;
		name = "Eye";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/eye_open.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/eye_mid.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/eye_closed.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void drawObjects(Graphics2D g2, GamePanel gp) {
		
		solidArea.width = gp.tileSize;
		solidArea.height = gp.tileSize;
		int screenX = worldPos.x - gp.player.worldPos.x + gp.player.screenX;
		int screenY = worldPos.y - gp.player.worldPos.y + gp.player.screenY;
		if(worldPos.x < gp.player.worldPos.x + gp.player.screenX + gp.tileSize
			&& worldPos.x > gp.player.worldPos.x - gp.player.screenX - gp.tileSize
			&& worldPos.y > gp.player.worldPos.y - gp.player.screenY - gp.tileSize
			&& worldPos.y < gp.player.worldPos.y + gp.player.screenY + gp.tileSize) { //check that the tiles we 
																	//are drawing are within
																	//our screen so that we dont draw
																	//tiles we cant see to save on processing power
			spriteCounter++;
			if(spriteCounter > 40) {
				if(spriteNum == 0) {
					spriteNum = 1;
				}else if(spriteNum == 1) {
					spriteNum = 2;
				} else {
					spriteNum = 0;
				}
				spriteCounter = 0;

			}												
			switch(spriteNum){
			case 0:
				g2.drawImage(image3, screenX, screenY, gp.tileSize, gp.tileSize, null);
				break;
			case 1:
				g2.drawImage(image2, screenX, screenY, gp.tileSize, gp.tileSize, null);
				break;
			case 2:
				g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				break;
		}
			
		
	}
	}
	
}
