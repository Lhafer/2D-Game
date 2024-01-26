package main;

import object.Eye_Obj;
import object.Heart_Obj;
import object.Goupta_Obj;
import object.Fuzz_Obj;
import entity.NPC_1;
import object.Battery_Obj;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new Eye_Obj();
		gp.obj[0].worldPos.x = 51 * gp.tileSize;
		gp.obj[0].worldPos.y = 51 * gp.tileSize;
		
		gp.obj[1] = new Heart_Obj();
		gp.obj[1].worldPos.x = 50 * gp.tileSize;
		gp.obj[1].worldPos.y = 50 * gp.tileSize;
	
		
		gp.obj[2] = new Goupta_Obj();
		gp.obj[2].worldPos.x = 40 * gp.tileSize;
		gp.obj[2].worldPos.y = 40 * gp.tileSize;
		
		gp.obj[3] = new Battery_Obj();
		gp.obj[3].worldPos.x = 80 * gp.tileSize;
		gp.obj[3].worldPos.y = 50 * gp.tileSize;
		
		gp.obj[4] = new Fuzz_Obj();
		gp.obj[4].worldPos.x = 90 * gp.tileSize;
		gp.obj[4].worldPos.y = 50 * gp.tileSize;
		
		
	}
	
	public void setNPC() {
		gp.npc[0] = new NPC_1(gp, 0);

		gp.npc[0].worldPos.x = 52 * gp.tileSize;
		gp.npc[0].worldPos.y = 52 * gp.tileSize;
		
	}
	
}
