package tile;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.awt.Graphics2D;
import main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	int worldMaxX = 100;
	int worldMaxY = 100;
	public  TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[6];
		
		mapTileNum = new int[worldMaxX][worldMaxY];
		
		getTileImage();
		loadMap("/maps/maps.txt");
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick_1.png"));
			tile[0].collision = true;
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor.png"));

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String mapPath) {
		try {
			InputStream is = getClass().getResourceAsStream(mapPath);
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			
			int row = 0;
			int col = 0;
			
			while(col < worldMaxX && row < worldMaxY) {
				String line = br.readLine();
				
				while(col < worldMaxX) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					
					col++;
				}
				if(col == worldMaxX) {
					System.out.println();
					col = 0;
					row++;
				}
			}
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		
		int col = 0;
		int row = 0;
		
		
		while (col < worldMaxX && row < worldMaxY) { //iterate through map
			int tileNum = mapTileNum[col][row];
			
			int x = col * gp.tileSize; //col of map  * size of tiles										  //it relative to the player 
			int y = row * gp.tileSize;
			int screenX = x - gp.player.worldX + gp.player.screenX;
			int screenY = y - gp.player.worldY + gp.player.screenY;
			if(x < gp.player.worldX + gp.player.screenX + gp.tileSize
				&& x > gp.player.worldX - gp.player.screenX - gp.tileSize
				&& y > gp.player.worldY - gp.player.screenY - gp.tileSize
				&& y < gp.player.worldY + gp.player.screenY + gp.tileSize) { //check that the tiles we 
																		//are drawing are within
																		//our screen so that we dont draw
																		//tiles we cant see to save on processing power
				
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				
			}
			col++;
			x += gp.tileSize;
			
			if(col == worldMaxX) {
				col = 0;
				x = 0; 
				row++;
				y+= gp.tileSize;
			}
		}
	}
}
