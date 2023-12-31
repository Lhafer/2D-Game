package main;

import entity.Entity;
import projectile.Projectile;

public class CollisionChecker {
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	public void checkTile(Entity entity) {
		int entityLeftWorldX= (int) (entity.worldPos.x) + entity.solidArea.x;
		int entityRightWorldX = (int) (entity.worldPos.x) + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = (int) (entity.worldPos.y )+ entity.solidArea.y;
		int entityBottomWorldY = (int) (entity.worldPos.y) + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case 1:
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		case 2:
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		case 7:
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		case 8:
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		
		case 5:
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
					gp.player.setDefaultValues();
					gp.assSet.setObject();
				}
			}
			break;
		case 6:
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
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
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
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
				if((tileNum1 == 4 || tileNum2 == 4) && entity == gp.player) {
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
				projectile.solidArea.x = (int) (projectile.worldPos.x + projectile.solidAreaDefaultX);
				projectile.solidArea.y = (int) (projectile.worldPos.y + projectile.solidAreaDefaultY);
				
				//get objects solid area position
				gp.obj[i].solidArea.x = (int) (gp.obj[i].worldPos.x + gp.obj[i].solidArea.x);
				gp.obj[i].solidArea.y = (int) (gp.obj[i].worldPos.y + gp.obj[i].solidArea.y);
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
				entity.solidArea.x = (int) (entity.worldPos.x + entity.solidAreaDefaultX);
				entity.solidArea.y = (int) (entity.worldPos.y + entity.solidAreaDefaultY);
				
				//get objects solid area position
				gp.obj[i].solidArea.x = (int) (gp.obj[i].worldPos.x + gp.obj[i].solidArea.x);
				gp.obj[i].solidArea.y = (int) (gp.obj[i].worldPos.y + gp.obj[i].solidArea.y);
				switch(entity.direction) {
				
				case 1:
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
				case 5:
					entity.solidArea.y -= entity.speed;
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
				case 6:
					entity.solidArea.y -= entity.speed;
					entity.solidArea.x += entity.speed;
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
				case 7:
					entity.solidArea.y += entity.speed;
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
				case 8:
					entity.solidArea.y += entity.speed;
					entity.solidArea.x += entity.speed;
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