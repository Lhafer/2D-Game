package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class UI {
	GamePanel gp;
	Font arial_25;
	BufferedImage image;
	boolean messageOn = false;
	String message;
	int messageCounter = 0;
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_25 = new Font("Arial", Font.PLAIN, 25);
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMessage(String text) {
		messageOn = true;
		message = text;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_25);
		g2.setColor(Color.white);
		g2.drawImage(image, gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
		g2.drawString(" = " + gp.player.hasKey, gp.tileSize*2 + 2, gp.tileSize*2 - 5);
		
		
		g2.drawString("Deaths = " + gp.player.deathCount, gp.tileSize*50, gp.tileSize*2 - 5);
		if(messageOn == true) {
			g2.drawString(message, gp.tileSize*2, gp.tileSize*10 - messageCounter);
			messageCounter++;
			if(messageCounter > 90) {
				messageOn = false;
				messageCounter = 0;
			}
		}
	}
	
}
