package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Battery_Obj extends SuperObject{
	public Battery_Obj() {
		name = "Battery";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/battery.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
