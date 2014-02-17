package se.nackademin.vhs_store_ultra;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI_User ug = new GUI_User();
        ug.initialize();
        
        Database db = new Database();
        db.init();
        
        Music2 ms = new Music2();
        ms.playMusic();

	}

}
