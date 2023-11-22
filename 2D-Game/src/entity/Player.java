package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Rectangle;
public class Player extends Entity{

GamePanel gp;
KeyHandler keyH;

public final int screenX;
public final int screenY;


public int hasKey = 0;
public int projSpeed = 20;
public int deathCount = -1;
int shotCount = 0;
public Player(GamePanel gp, KeyHandler keyH) {

	this.gp = gp;
	this.keyH = keyH;
	

	
	screenX = gp.screenWidth/2 - gp.tileSize/2;
	screenY = gp.screenHeight/2 - gp.tileSize/2;
	
	int solidScaleX = gp.tileSize/4;
	int solidScaleY = gp.tileSize/3;
	int solidScale = (int) (gp.tileSize/1.5);
	solidArea = new Rectangle(solidScaleX,solidScaleY,solidScale,solidScale);
	
	solidAreaDefaultX = solidArea.x;
	solidAreaDefaultY = solidArea.y;
	
	setDefaultValues();
	getPlayerImage();
	}

	public void setDefaultValues() {
		deathCount++;
		hasKey = 0;
		worldX = (104 * gp.tileSize)/2;
		worldY = (104 * gp.tileSize)/2;
		speed = 4;
		direction = 0;
	}
	public void getPlayerImage() {

		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/player/dude_front1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/dude_front2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/dude_back1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/dude_back2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/dude_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/dude_left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/dude_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/dude_right2.png"));
			idle = ImageIO.read(getClass().getResourceAsStream("/player/dude_idle.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void update( ) {
		collisionOn = false;
		if(shotCount >= 30) {
			
			if(keyH.spacePressed == true) {
				gp.projM.newProjectile();
				shotCount = 0;
			}
		} else {
			shotCount++;
		}
		if(!keyH.directKeysPressed == true) {
			direction = 0;
		} else {
			
				if(keyH.upPressed == true) {
					direction = 2;
				}
				if(keyH.downPressed == true) {
					direction = 1;
				}
				if(keyH.leftPressed == true) {
					direction = 3;
				}
				if(keyH.rightPressed == true) {
					direction = 4;
				}
				
		
		gp.colCheck.checkTile(this);
		int objIndex = gp.colCheck.checkObject(this, true);
		if (objIndex != 999) {
			pickUpObject(objIndex);
		}
		
		
		if(collisionOn == false) {

			
			switch(direction) {
			case 1:
				worldY += speed;
				break;
			case 2:
				worldY -= speed;
				break;
			case 3:
				worldX -= speed;
				break;
			case 4:
				worldX += speed;
				break;
			default:
				break;
			}
		}
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


		
	}
	
	public void pickUpObject(int i) {
		
			
			String objectName = gp.obj[i].name;
			switch(objectName) {
			case "Eye":
				//take dmg;
				break;
			case "Heart":
				gp.ui.showMessage("+1");
				hasKey++;
				gp.obj[i] = null;
				break;
			case "Battery":
				gp.playSE(0);
				projSpeed += 10;
				speed+=2;
				gp.obj[i] = null;
				break;
			case "Fuzz":
				break;
			case "Goupta":
				if(hasKey > 0) {
					hasKey--;
					gp.obj[i] = null;
				}
				break;
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
		case 2:
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
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}