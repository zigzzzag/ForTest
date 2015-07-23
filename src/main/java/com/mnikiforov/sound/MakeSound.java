package com.mnikiforov.sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MakeSound {

    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;

    public static void main(String[] args) {
	MakeSound makeSound = new MakeSound();
//	makeSound.playSound("src/main/resources/Клиент.wav");

	makeSound.ConvertFileToAIFF("src/main/resources/Клиент.wav", "src/main/resources/target.wav");
    }

    /**
     * @param filename the name of the file that is going to be played
     */
    public void playSound(String filename) {

	String strFilename = filename;

	try {
	    soundFile = new File(strFilename);
	} catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	}

	try {
	    audioStream = AudioSystem.getAudioInputStream(soundFile);
	} catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	}

	audioFormat = audioStream.getFormat();

	DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	try {
	    sourceLine = (SourceDataLine) AudioSystem.getLine(info);
	    sourceLine.open(audioFormat);
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	    System.exit(1);
	} catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	}

	sourceLine.start();

	int nBytesRead = 0;
	byte[] abData = new byte[BUFFER_SIZE];
	while (nBytesRead != -1) {
	    try {
		nBytesRead = audioStream.read(abData, 0, abData.length);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    if (nBytesRead >= 0) {
		@SuppressWarnings("unused")
		int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
	    }
	}

	sourceLine.drain();
	sourceLine.close();
    }

    public void ConvertFileToAIFF(String inputPath, String outputPath) {
	AudioFileFormat inFileFormat;
	File inFile;
	File outFile;
	try {
	    inFile = new File(inputPath);
	    outFile = new File(outputPath);
	} catch (NullPointerException ex) {
	    System.out.println("Error: one of the ConvertFileToAIFF" + " parameters is null!");
	    return;
	}
	try {
	    // query file type
	    inFileFormat = AudioSystem.getAudioFileFormat(inFile);
	    if (inFileFormat.getType() != AudioFileFormat.Type.AIFF) {
		// inFile is not AIFF, so let's try to convert it.
		AudioInputStream inFileAIS = AudioSystem.getAudioInputStream(inFile);
		inFileAIS.reset(); // rewind
		if (AudioSystem.isFileTypeSupported(AudioFileFormat.Type.AIFF, inFileAIS)) {
		    // inFileAIS can be converted to AIFF. 
		    // so write the AudioInputStream to the
		    // output file.
		    AudioSystem.write(inFileAIS,
			    AudioFileFormat.Type.AIFF, outFile);
		    System.out.println("Successfully made AIFF file, "
			    + outFile.getPath() + ", from "
			    + inFileFormat.getType() + " file, "
			    + inFile.getPath() + ".");
		    inFileAIS.close();
		    return; // All done now
		} else {
		    System.out.println("Warning: AIFF conversion of " + inFile.getPath() + " is not currently supported by AudioSystem.");
		}
	    } else {
		System.out.println("Input file " + inFile.getPath()
			+ " is AIFF." + " Conversion is unnecessary.");
	    }
	} catch (UnsupportedAudioFileException e) {
	    System.out.println("Error: " + inFile.getPath()
		    + " is not a supported audio file type!");
	    return;
	} catch (IOException e) {
	    System.out.println("Error: failure attempting to read " + inFile.getPath() + "!");
	    return;
	}
    }
}
