package projectile;

import java.awt.Graphics2D;

import main.GamePanel;

public class ProjectileManager {
	GamePanel gp;
	public Projectile[] projectiles;
	double drawInterval = 1000000000/2;
	double delta = 0;
	long lastTime = System.nanoTime();
	long currentTime;
	int count = 0;


	public ProjectileManager(GamePanel gp) {
		projectiles = new Projectile[10];
		this.gp = gp;
	}
	
	public void newProjectile() {
		currentTime = System.nanoTime();

		delta += (currentTime - lastTime) / drawInterval;
		lastTime = currentTime;

			if(delta > 1) {
				
				projectiles[count] = new Projectile(gp);
				count++;
				delta--;
			}
			if(count < 9) count = 0;
		
	}
	public void update() {
		if(projectiles != null) {
			for(int i = 0; i < projectiles.length; i++) {
				gp.colCheck.checkHit(projectiles[i], i);
				if(projectiles[i] != null) {
					switch(projectiles[i].direction) {
					case 0:
						projectiles[i].worldY += projectiles[i].speed;
						break;
					case 1:
						projectiles[i].worldY += projectiles[i].speed;
						break;
					case 2:
						projectiles[i].worldY -= projectiles[i].speed;
						break;
					case 3:
						projectiles[i].worldX -= projectiles[i].speed;
						break;
					case 4:
						projectiles[i].worldX += projectiles[i].speed;
						break;
					default:
						break;
					}
				}
			}
		}
	}
	
	public void draw(Graphics2D g2) {

			for(int i = 0; i < projectiles.length; i++) {
				if(projectiles[i] != null) {
					int screenX = projectiles[i].worldX - gp.player.worldX + gp.player.screenX;
					int screenY = projectiles[i].worldY - gp.player.worldY + gp.player.screenY;
					
						g2.drawImage(projectiles[i].image, screenX, screenY, 24, 24, null);
				}
					
			}
	}
	
}
