package main;

import object.Eye_Obj;
import object.Heart_Obj;
import object.Goupta_Obj;
import object.Fuzz_Obj;
import object.Battery_Obj;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new Eye_Obj();
		gp.obj[0].worldX = 51 * gp.tileSize;
		gp.obj[0].worldY = 51 * gp.tileSize;
		
		gp.obj[1] = new Heart_Obj();
		gp.obj[1].worldX = 50 * gp.tileSize;
		gp.obj[1].worldY = 50 * gp.tileSize;
	
		
		gp.obj[2] = new Goupta_Obj();
		gp.obj[2].worldX = 40 * gp.tileSize;
		gp.obj[2].worldY = 40 * gp.tileSize;
		
		gp.obj[3] = new Battery_Obj();
		gp.obj[3].worldX = 80 * gp.tileSize;
		gp.obj[3].worldY = 50 * gp.tileSize;
		
		gp.obj[4] = new Fuzz_Obj();
		gp.obj[4].worldX = 90 * gp.tileSize;
		gp.obj[4].worldY = 50 * gp.tileSize;
		
		
	}
	
}
