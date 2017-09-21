import java.awt.*;
import java.applet.*;
import java.io.*;
import javax.sound.sampled.*;
import java.net.*;
import javax.swing.*;

public class Music extends Applet
{
	 private Clip clip;
	public Music(String sound)
	{
		File music = new File(sound);
		PlaySound(music);
	}
	public Clip getClip(){return this.clip;}
	public void PlaySound(File Sound)  
	{
		try{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		} catch (UnsupportedAudioFileException e) 	{}
		catch (IOException e) {}
		catch (LineUnavailableException e) {}	
	}
	public void stop()
	{
		clip.stop();
	}
}