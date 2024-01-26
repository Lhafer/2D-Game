package entity;



import main.GamePanel;
import main.KeyHandler;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Player extends Entity{

KeyHandler keyH;


public final int screenX;
public final int screenY;

public int hasKey = 0;
public int projSpeed = 20;
public int deathCount = -1;
int shotCount = 0;
public Player(GamePanel gp, KeyHandler keyH) {

	super(gp);
	this.keyH = keyH;
	isPlayer = true;
	
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

	public void getPlayerImage() {
	
		down1 = setupImg("/player/dude_front1.png");
		down2 = setupImg("/player/dude_front2.png");
		up1 = setupImg("/player/dude_back1.png");
		up2 = setupImg("/player/dude_back2.png");
		left1 = setupImg("/player/dude_left1.png");
		left2 = setupImg("/player/dude_left2.png");
		right1 = setupImg("/player/dude_right1.png");
		right2 = setupImg("/player/dude_right2.png");
		idle = setupImg("/player/dude_idle.png");
	
	}
	
	public void setDefaultValues() {
		deathCount++;
		hasKey = 0;
		worldPos.x = (104 * gp.tileSize)/2;
		worldPos.y = (104 * gp.tileSize)/2;
		speed = 4;
		direction = 0;
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
					directVect.y = -1;
					directVect.x = 0;
					direction = 1;
					if(keyH.leftPressed == true && keyH.rightPressed == false) {
						directVect.x = -1;
						direction = 5;
					}
					if (keyH.rightPressed == true && keyH.leftPressed == false) {
						directVect.x = 1;
						direction = 6;
					}
				}
				if(keyH.downPressed == true) {
					directVect.y = 1;
					directVect.x = 0;
					direction = 2;
					if(keyH.leftPressed == true && keyH.rightPressed == false) {
						directVect.x = -1;
						direction = 7;
					}
					if (keyH.rightPressed == true && keyH.leftPressed == false) {
						directVect.x = 1;
						direction = 8;
					}
				}
				if(keyH.leftPressed == true && keyH.upPressed == false  && keyH.downPressed == false) {
					direction = 3;
					directVect.y = 0;
					directVect.x = -1;
				}
				if(keyH.rightPressed == true && keyH.downPressed == false && keyH.upPressed == false) {
					direction = 4;
					directVect.y = 0;
					directVect.x = 1;
				}
				
		gp.colCheck.checkTile(this);
		int objIndex = gp.colCheck.checkObject(this, true);
		if (objIndex != 999) {
			pickUpObject(objIndex);
		}
		
		
		if(collisionOn == false) {

			worldPos.move(this, directVect);
			/*
			switch(direction) {
			case 1:
				worldPos.y -= speed;
				break;
			case 5:
				worldPos.y -= speed;
				worldPos.x -= speed;
				break;
			case 6:
				worldPos.y -= speed;
				worldPos.x += speed;
				break;
				
			case 2:
				worldPos.y += speed;
				break;
			case 7:
				worldPos.y += speed;
				worldPos.x -= speed;
				break;
			case 8:
				worldPos.y += speed;
				worldPos.x += speed;
				break;
			case 3:
				worldPos.x -= speed;
				break;
			case 4:
				worldPos.x += speed;
				break;
			default:
				break;
			}
			*/
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
	//check that the tiles we 
																	//are drawing are within
																	//our screen so that we dont draw
																	//tiles we cant see to save on processing power
			
			
			g2.drawImage(image, screenX, screenY, null);
			
		
	}
	
}