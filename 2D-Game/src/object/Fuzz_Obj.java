package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Fuzz_Obj extends SuperObject{
	public Fuzz_Obj() {
		name = "Fuzz";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/fuzz.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
