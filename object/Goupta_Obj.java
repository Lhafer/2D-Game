package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Goupta_Obj extends SuperObject{
	public Goupta_Obj() {
		name = "Goupta";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/goupta.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
