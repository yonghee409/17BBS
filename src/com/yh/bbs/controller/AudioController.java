package com.yh.bbs.controller;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioController {
	
	public static void play(String strAudio) {
		
		File fAudio = new File(strAudio);
		String fName = strAudio.substring(strAudio.lastIndexOf("\\")-1);
		try {
			AudioInputStream audioin = AudioSystem.getAudioInputStream(fAudio);
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioin);
			
			if (clip.isOpen()) {
				System.out.println("[Action]"+fName+" 열기 완료.");
				clip.start();
				System.out.println("[Action]"+fName+" 재생 완료.");
				
				Thread.sleep(clip.getMicrosecondLength()/1000);
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
