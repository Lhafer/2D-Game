package entity;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldX, worldY;
	public int speed;

	public BufferedImage idle, up1, up2, down1, down2, left1, left2, right1, right2;
	public int direction;

	public boolean collisionOn = false;
	public Rectangle solidArea;
	
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}