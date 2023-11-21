package main;

import entity.Entity;
import projectile.Projectile;

public class CollisionChecker {
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityLeftWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		
		case 1:
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if(tileNum1 == 4 || tileNum2 == 4) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		case 2:
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if(tileNum1 == 4 || tileNum2 == 4) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		case 3:
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if(tileNum1 == 4 || tileNum2 == 4) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}

			break;
		case 4:
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if(tileNum1 == 4 || tileNum2 == 4) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}

			break;
		default:
			break;
		}
		
	}
	public void checkHit(Projectile projectile, int index) {

		
		for(int i = 0; i < gp.obj.length; i++) {
			if(gp.obj[i] != null && projectile != null) {
				//get projectile's solidarea position
				projectile.solidArea.x = projectile.worldX + projectile.solidAreaDefaultX;
				projectile.solidArea.y = projectile.worldY + projectile.solidAreaDefaultY;
				
				//get objects solid area position
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				switch(projectile.direction) {
				
				case 1:
					projectile.solidArea.y += projectile.speed;
					if(projectile.solidArea.intersects(gp.obj[i].solidArea) && gp.obj[i].name.equals("Eye")) {
						gp.projM.projectiles[index] = null;
						gp.obj[i] = null;
						gp.ui.showMessage("Nice!");
					}
					break;
				case 2:
					projectile.solidArea.y -= projectile.speed;
					if(projectile.solidArea.intersects(gp.obj[i].solidArea) && gp.obj[i].name.equals("Eye")) {
						gp.projM.projectiles[index] = null;
						gp.obj[i] = null;
						gp.ui.showMessage("Nice!");
					}
					
					break;
				case 3:
					projectile.solidArea.x -= projectile.speed;
					if(projectile.solidArea.intersects(gp.obj[i].solidArea) && gp.obj[i].name.equals("Eye")) {
						gp.projM.projectiles[index] = null;
						gp.obj[i] = null;
						gp.ui.showMessage("Nice!");
					}

					break;
				case 4:
					projectile.solidArea.x += projectile.speed;
					if(projectile.solidArea.intersects(gp.obj[i].solidArea) && gp.obj[i].name.equals("Eye")) {
						gp.projM.projectiles[index] = null;
						gp.obj[i] = null;
						gp.ui.showMessage("Nice!");
					}
				
				}
				if(gp.obj[i] != null && projectile != null) {
					projectile.solidArea.x = projectile.solidAreaDefaultX;
					projectile.solidArea.y = projectile.solidAreaDefaultY;
					gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
					gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
				}
			}
		}
		
	}
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		
		for(int i = 0; i < gp.obj.length; i++) {
			if(gp.obj[i] != null) {
				//get entity's solidarea position
				entity.solidArea.x = entity.worldX + entity.solidAreaDefaultX;
				entity.solidArea.y = entity.worldY + entity.solidAreaDefaultY;
				
				//get objects solid area position
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				switch(entity.direction) {
				
				case 1:
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity == gp.player) {
							index = i;
						}
						if(gp.obj[i].collision == true) {
							
								entity.collisionOn = true;
						}
						
					}
					break;
				case 2:
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity == gp.player) {
							index = i;
						}
						if(gp.obj[i].collision == true) {
							
								entity.collisionOn = true;
						}
						
					}
					
					break;
				case 3:
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity == gp.player) {
							index = i;
						}
						if(gp.obj[i].collision == true) {
							
								entity.collisionOn = true;
						}
						
					}

					break;
				case 4:
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity == gp.player) {
							index = i;
						}
						if(gp.obj[i].collision == true) {
							
								entity.collisionOn = true;
						}
						
					}
				
				}
				
			entity.solidArea.x = entity.solidAreaDefaultX;
			entity.solidArea.y = entity.solidAreaDefaultY;
			gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
			gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		
		return index;
	}
}