package se.nackademin.vhs_store_ultra;

public class Main {

	public static void main(String[] args) {
		GUI_User ug = new GUI_User();
        ug.initialize();
        
        Music ms = new Music();
        ms.playMusic();
	}

}
