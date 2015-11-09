/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.apache.log4j.chainsaw.Main;

/**
 *
 * @author mnikiforov
 */
public class WavTest {

    private static File soundFile;

    public static void main(String[] args) {
	playSound("src/main/resources/Client.wav");
    }

    public static synchronized void playSound(final String filename) {
	new Thread(new Runnable() {
	    // The wrapper thread is unnecessary, unless it blocks on the
	    // Clip finishing; see comments.
	    @Override
	    public void run() {
		try {
		    try {
			soundFile = new File(filename);
		    } catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		    }

		    Clip clip = AudioSystem.getClip();
		    AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
		    clip.open(inputStream);
		    clip.start();
		} catch (Exception e) {
		    System.err.println(e.getMessage());
		}
	    }
	}).start();
    }
}
