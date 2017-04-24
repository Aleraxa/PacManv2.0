package pacman;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static pacman.Config.getData;


public class Odczytplanszy {

	public String tabela;

	public int[] odczytparametrow() throws IOException{

		int[] parametry = new int[2];

		FileReader fr = new FileReader(getData("plikPoziom"));
		BufferedReader br = new BufferedReader(fr);
		Scanner sc = new Scanner(br);
		parametry[0] = sc.nextInt();
		parametry[1] = sc.nextInt();
		sc.close();
		return parametry;
	}


	public char[][] odczytplanszy() throws IOException {

		int[] szerokoscwysokosc=this.odczytparametrow();
		int wysokosc=szerokoscwysokosc[1];
		int szerokosc=szerokoscwysokosc[0];


		FileReader filer = new FileReader(getData("plikPoziom"));
		BufferedReader buffr = new BufferedReader(filer);

		if(wysokosc<10 && szerokosc<10)
			buffr.skip(6);
		else if((wysokosc>=10 && szerokosc<10) || (wysokosc<10 && szerokosc>=10))
			buffr.skip(7);
		else if(wysokosc>10 && szerokosc>10)
			buffr.skip(8);


		char[][] punkty = new char[szerokosc][wysokosc];

		int i=0;
		int j=0;

		while(j!=wysokosc)
		{
			char temp = (char)buffr.read();
			punkty[i][j] = temp;
			i++;
			if(i==szerokosc)
			{
				buffr.skip(2);
				i=0;
				j++;
			}


		}

		buffr.close();
		return punkty;



	}
}
