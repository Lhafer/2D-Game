package entity;

import java.awt.Rectangle;

import main.GamePanel;

public class NPC_1 extends Entity{

	
	
	
	public NPC_1(GamePanel gp) {
		super(gp);
		speed = 1;
		direction = 0;
		solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize);
		getNPCImage();
		setDefault();
		
		
	}
	
	public void setDefault() {
		
		solidAreaDefaultX = 0;
		solidAreaDefaultY = 0;
	}
	
	
	
	
	public void getNPCImage() {

		down1 = setupImg("/npc/oldman_down_1.png");
		down2 = setupImg("/npc/oldman_down_2.png");
		up1 = setupImg("/npc/oldman_down_1.png");
		up2 = setupImg("/npc/oldman_down_2.png");
		left1 = setupImg("/npc/oldman_down_1.png");
		left2 = setupImg("/npc/oldman_down_2.png");
		right1 = setupImg("/npc/oldman_down_1.png");
		right2 = setupImg("/npc/oldman_down_2.png");
		idle = setupImg("/npc/oldman_down_1.png");
	
	}
	
	

}
