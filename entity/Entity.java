package entity;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;
import main.Vector2D;


public class Entity {
	GamePanel gp;
	public Vector2D worldPos = new Vector2D();
	public Vector2D directVect = new Vector2D();
	public int speed;
	public int counter = 0;
	public boolean isPlayer;
	

	public int index;
	
	public BufferedImage idle, up1, up2, down1, down2, left1, left2, right1, right2;
	public int direction;
	
	public boolean collisionOn = false;
	public Rectangle solidArea;
	
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	int imgSwitch = 0;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	Random rand = new Random();
	
	
	
	
	public BufferedImage setupImg(String imgPath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imgPath));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public void update(Player player) {
		collisionOn = false;
		
		
		
		imgSwitch++;
		if(Math.abs( player.worldPos.sub(worldPos).magnitude()) < 200.0) {
			
			directVect = worldPos.sub(player.worldPos);
			directVect.x = -directVect.x;
			directVect.y = -directVect.y;
		} else {
		//System.out.println(trackingVect.sub(worldPos).magnitude());
			
			 if(imgSwitch >= 180) {
				imgSwitch = 0;
				counter = rand.nextInt(100)+1;
			 }
			
				if(counter <= 100) {
					
					directVect.y = 1;
					directVect.x = 0;
					direction = 2;
				}
				/*
				if(counter <= 175) {
					directVect.x = -1;
					directVect.y = -1;
					direction = 5;
				}
				if(counter <= 150) {
					directVect.x = 1;
					direction = 6;
				}
				
				if(counter <= 75) {
					directVect.x = 0;
					directVect.y = -1;
					direction = 2;
				}
				if(counter <= 100) {
					directVect.x = -1;
					directVect.y = 1;
					direction = 7;
				}
				*/
				if(counter <= 75) {
					directVect.x = 0;
					directVect.y = -1;
					direction = 1;
				}
				if(counter <= 50) {
					directVect.x = -1;
					directVect.y = 0;
					direction = 3;
				}
				if(counter <= 25) {
					directVect.x = 1;
					directVect.y = 0;
					direction = 4;
					
				}
			
		 
		}
			gp.colCheck.checkTile(this);
			gp.colCheck.checkObject(this, false);
			if(!isPlayer) {
				gp.colCheck.checkNPCHit(this);
			}
			
			if(collisionOn == false) {
				worldPos.move(this, directVect);
				
			}
	
		
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch(direction) {
		case 0:
			image = idle;
			break;
		case 1:
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case 5:
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case 6:
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case 2:
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case 7:
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case 8:
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case 3:
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case 4:
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;

		}
		
		int screenX = (int) (worldPos.x - gp.player.worldPos.x + gp.player.screenX);
		int screenY = (int) (worldPos.y - gp.player.worldPos.y + gp.player.screenY);
		if(worldPos.x < gp.player.worldPos.x + gp.player.screenX + gp.tileSize
			&& worldPos.x > gp.player.worldPos.x - gp.player.screenX - gp.tileSize
			&& worldPos.y > gp.player.worldPos.y - gp.player.screenY - gp.tileSize
			&& worldPos.y < gp.player.worldPos.y + gp.player.screenY + gp.tileSize) { //check that the tiles we 
																	//are drawing are within
																	//our screen so that we dont draw
																	//tiles we cant see to save on processing power
			
			
			g2.drawImage(image, screenX, screenY, null);
			
		}
	}
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
}