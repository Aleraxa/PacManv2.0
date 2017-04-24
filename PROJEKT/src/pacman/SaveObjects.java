package pacman;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;


public class SaveObjects {

	public static void main(String[] args) {
		
		Frame a = new Frame ("Tytul okna do zachowania w pliku");
		a.setBounds(20,20,400,500);
		a.setVisible(true);
		a.getGraphics().drawString("Ten napis nie zostanie zapisany razem z oknem...", 50, 100);
		
		FileOutputStream ostream = null;
		try {
			ostream = new FileOutputStream("obiekty.sav");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectOutputStream p = null;
		try {
			p = new ObjectOutputStream(ostream);
		    p.writeInt(1);
			p.writeObject("Tekst do zapisania");
			p.writeObject(new Date());
			p.writeObject(a);
			p.flush();
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		a.dispose();
	}

}