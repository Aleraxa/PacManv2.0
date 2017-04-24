package pacman;
import java.io.BufferedReader;
import java.io.FileReader;

public class LoadObjects {

		private static String pobierzWyniki(){
			StringBuilder sb = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader("Configurations\\highscores.xml"))){
				String currentLine;
				while ((currentLine = br.readLine()) != null) {
					sb.append(currentLine);
				}
			}
			catch (Exception e){

			}
			return sb.toString();
		}





}