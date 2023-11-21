package object;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Heart_Obj extends SuperObject{
	
	public Heart_Obj() {
		name = "Heart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/heart.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
