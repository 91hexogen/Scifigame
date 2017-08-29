package cimcraft3;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//"System in" ist für den Input
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		// Random-Generator für zufällige Zahlen
		Random rand = new Random();
		
		
		// Spiel Variablen
		String[] gegner = {"Lutz", "Lord Sievers", "Manuel", "Mikail", "Wagler"};
		int maxGegnerLeben = 5;
		int gegnerSchaden = 25;
		
		
		// Spieler Variablen
		int leben = 100;
		int schaden = 50;
		int numHeilTrank = 3;
		int heilTrankHeilung = 30;
		int heilTrankDropChance = 50; // Prozentzahl
		
		boolean laufen = true;
		
		System.out.println("Willkommen bei Cimcraft III - Legacy of Sievers!");
		
		SPIEL:
			while(laufen) {
				System.out.println("---------------------------------------------------------");
				
				//Gegner Leben und Spawn (Zufall)
				int gegnerLeben = /*rand.nextInt*/maxGegnerLeben;
				int gegnerNr = rand.nextInt(gegner.length);
				String feind = gegner[gegnerNr];
				System.out.println("\t# " + feind + " ist plötzlich im Klassenzimmer aufgetaucht! #\n");
				
				while(gegnerLeben > 0) {
					System.out.println("\tDeine HP: " + leben);
					System.out.println("\t" + feind + "'s HP: " + gegnerLeben);
					System.out.println("\n\tWas willst du tun?");
					System.out.println("\t1. Angreifen!");
					System.out.println("\t2. Heilbier saufen!");
					System.out.println("\t3. Flüchten!");
					
					String input = in.nextLine();
					
					if(input.equals("1")) {
						int schadenMachen = rand.nextInt(schaden);
						int schadenNehmen = rand.nextInt(gegnerSchaden);
						
						gegnerLeben -= schadenMachen;
						leben -= schadenNehmen;
						
						// ------ Gegner stirbt für immer ------
						
						
						
						System.out.println("\t> Du triffst " + feind + " für " + schadenMachen + " Schaden!");
						System.out.println("\t> Du nimmst " + schadenNehmen + " Schaden!");
						
						if(leben < 1) {
							System.out.println("\t> Du hast zuviel Schaden genommen, "
									+ " und bist zu schwach um weiter zu machen!");
							break;
						}								
					}
					// HEILTRÄNKE
					else if(input.equals("2")) {
						if(numHeilTrank > 0) {
							leben += heilTrankHeilung;
							numHeilTrank--;
							System.out.println("\t> Du trinkst einen Heilbier, das dich um " + heilTrankHeilung + " HP heilt!"
									+ "\n\t> Du hast jetzt " + leben + " HP!"
									+ "\n\t> Du hast noch " + numHeilTrank + " Heilbiere übrig!");	
						}
						else {
						System.out.println("\t> Du hast kein Heilbier mehr übrig! "
								+ "Töte ein paar Gegner. Manchmal lassen sie ein Heilbier fallen!\n");
						}
					}
					// FLÜCHTEN
					else if(input.equals("3")) {
						System.out.println("\tDu bist vor " + feind + " abgehauen du Pfeife!");
					}
					// UNBEKANNTER BEFEHL
					else {
						System.out.println("\tUnbekannter Befehl. Eingabe Wiederholen!.");
					}
				}
				
				if(leben < 1) {
					System.out.println("\tDu wurdest von " + feind + " zerstückelt.\n\n\t\t DU BIST TOT!\n");
					break;
				}
				
				System.out.println("---------------------------------------------------------");
				System.out.println(" ###### " + feind + " ist K.O.! ###### ");
				
				// Gegner stirbt
				String[] gegner_temp = new String[gegner.length-1]; //gegner_temp = {"", "", "", "", ""};
				int i = 0;
				for(int x=0; x <= gegner.length -1; x++) {
					if(gegnerNr != x) {
						gegner_temp[i] = gegner[x];
						i++;
					}
				}
				
				gegner = gegner_temp;
				
				//Liste von verbleibenden Gegnern wird angezeigt
				System.out.println("\n# Folgende Gegner sind noch im Haus: #");
				for(int x=0; x <= gegner.length -1; x++) {
					System.out.println("\n\t>" + gegner[x] + "\n");
				}
				
				
				
				System.out.println(" # Du hast noch " + leben + " HP übrig! # ");
				if(rand.nextInt(100) < heilTrankDropChance) {
					numHeilTrank++;
					System.out.println(" # " + feind + " hat ein Heilbier fallen lassen! #");
					System.out.println(" # Du besitzt nun " + numHeilTrank + " Heilbiere(s). # ");
				}
				System.out.println("---------------------------------------------------------");
				System.out.println("Was möchtest du jetzt tun?");
				System.out.println("1. Weiter kämpfen!");
				System.out.println("2. Ich habe Angst, ich höre auf.");
				
				String input = in.nextLine();
				
				while(!input.equals("1") && !input.equals("2")) {
					System.out.println("Unbekannter Befehl!");
					input = in.nextLine();
				}
				if(input.equals("1")) {
					System.out.println("Du setzt das Spiel fort!");
				}
				else {
					System.out.println("Du hast Cimdata verlassen!\n");
					break;
				}
				
			}
		
		System.out.println("###########################################################");
		System.out.println("################# DANKE FÜR'S SPIELEN! ####################");
		System.out.println("###########################################################");
		
		

	}

}
