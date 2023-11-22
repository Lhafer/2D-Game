package projectile;

import java.awt.Graphics2D;

import main.GamePanel;

public class ProjectileManager {
	GamePanel gp;
	public Projectile[] projectiles;
	long currentTime;
	int count = 0;


	public ProjectileManager(GamePanel gp) {
		projectiles = new Projectile[10];
		this.gp = gp;
	}
	
	public void newProjectile() {
				if(count == 10) count = 0;
				projectiles[count] = new Projectile(gp);
				count++;
				System.out.println(count);
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
					}
				}
			}
		}
	}
	
	public void draw(Graphics2D g2, Projectile projectile) {

			if(projectile != null) {
					int screenX = projectile.worldX - gp.player.worldX + gp.player.screenX;
					int screenY = projectile.worldY - gp.player.worldY + gp.player.screenY;
						g2.drawImage(projectile.image, screenX, screenY, 24, 24, null);
			}
	}
					
			

	
}