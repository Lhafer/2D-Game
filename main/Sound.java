package main;


import java.net.URL;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sound/battery.wav");
		soundURL[1] = getClass().getResource("/sound/goupta_bug.wav");
		soundURL[2] = getClass().getResource("/sound/game_music.wav");
	}
	
	public void setFile(int i){
		        try {
		        	
		        		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);

			            clip = AudioSystem.getClip();
			            
			            clip.open(audioInputStream);
		        	
		        }catch (Exception e) {
		            e.printStackTrace();
		        }
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volumeControl.setValue(-12.0f);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void stop() {
		clip.stop();
	}
}
