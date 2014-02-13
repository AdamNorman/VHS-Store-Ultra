package se.nackademin.vhs_store_ultra;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Music implements Runnable {

	//
	private void playMusic() {
		try {
			File f = new File("Audio/EscapeFromNewYork.wav");
			AudioInputStream audio = AudioSystem.getAudioInputStream(f);
			AudioFormat format;
			format = audio.getFormat();
			SourceDataLine auline;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
			auline.start();
			int nBytesRead = 0;
			byte[] abData = new byte[524288];
			while (nBytesRead != -1) {
				nBytesRead = audio.read(abData, 0, abData.length);
				if (nBytesRead >= 0) {
					auline.write(abData, 0, nBytesRead);
				}
			}
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		playMusic();
	}
}
