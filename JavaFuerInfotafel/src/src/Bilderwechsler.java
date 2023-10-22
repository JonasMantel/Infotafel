package src;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Bilderwechsler{
	
	private ArrayList<String> meineBilder = new ArrayList<String>();
	
	private int anzahlBilder = 0;
	
	private String dateiname;
	
	private boolean wechseln;
	//Zählvariable für while-Schleife
	private int i = 0;
	private Path pfad;
	
	private String bilderOrdnerPfad = "H:/Jonas/Unterricht/Systembetreuung/Java_Infotafel/";
	
	private Path bilderNamenPfad = Paths.get("H:/Jonas/Unterricht/Systembetreuung/Java_Infotafel/Bildernamen.txt");
	//git repository: C:/users/jonas/git/repository/JavaFuerInfotafel/
	
	public Bilderwechsler(String speicherOrtInfoDatei) {
		dateiname = speicherOrtInfoDatei;
		pfad = Paths.get(dateiname);
		wechseln = true;
		BildernamenEinlesen();
				//Hier müssten die bisherigen Bilder aus der XML File geldaden werden und das Bilderwechseln gestartet werden
	}
	

	public void BildHinzufuegen(String Titel) {
		meineBilder.add(Titel);
		anzahlBilder ++;
		BildernamenSchreiben(Titel);
		//In Datei schreiben
		
	}
	
	public void BilderWechseln() {
		
		//hier while schleife benötigt; Zählvariable muss immer wieder zurückgesetzt werden
		while(wechseln) {
			
			String bildername = meineBilder.get(i);
			
			DateiSpeichern(bildername);
			//In Datei speichern
			//Warten 1 minute und
			
			i++;
			if(i >= anzahlBilder) {
				i = 0;
			}
			try {
				Thread.sleep(60000);
				System.out.println("Jetzt habe ich gewechselt");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		
		}//end while
	}
	
		
	public boolean DateiLoeschen() {
		 
		try {
			Files.delete(pfad);
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean DateiSpeichern(String bildername) {
		Path pfad = Paths.get(dateiname);
		// inhalt für Verwaltungsnetz 
		//String inhalt = "<img src=\"/gym-plan/Vertretung/info/" + bildername + "\" style= \"width:100%; height:100%;\">";
		String inhalt = "<img src=\"H:/Jonas/Unterricht/Systembetreuung/Java_Infotafel/" + bildername + "\" style= \"width:100%; height:100%;\">";
		byte[] byteEingabe = inhalt.getBytes();
		try {
			Files.write(pfad, byteEingabe);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void setDateiname(String neuerDateiname) {
		dateiname = neuerDateiname;
	}
	
	public void setWechseln(boolean wechsel) {
		if(wechsel) {
			wechseln = true;
		}else {
			wechseln = false;
		}
	}
	
	public void BildernamenEinlesen() {
		try {
			
			List<String> bilderNamen = Files.readAllLines(bilderNamenPfad);
			for(String name : bilderNamen) {
				meineBilder.add(name);
				System.out.println("Das ist der eingelesene name: " + name);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void BildernamenSchreiben(String neuerBildername) {
		//byte[] byteArray = neuerBildername.getBytes();
		neuerBildername = "\r\n" + neuerBildername;
		try {
			//Files.write(bilderNamenPfad, byteArray, StandardOpenOption.APPEND);
			Files.writeString(bilderNamenPfad, neuerBildername, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getbilderName(int stelleImArray) {
		return meineBilder.get(stelleImArray);
	}
	
	public int getMeineBilderSize() {
		return meineBilder.size();
	}
	
	public void bildLoeschen(String nameBild) {
		//Aus der ArrayList löschen
		meineBilder.remove(nameBild);
		
		
		//aus der .txt Datei löschen
		try {
			List<String> bilderNamenLoeschen = Files.readAllLines(bilderNamenPfad);
			
			System.out.println("Größe der Liste mit den Bildernamen aus der txt. Datei: " + bilderNamenLoeschen.size());
			for(int i = 0; i < bilderNamenLoeschen.size(); i++) {
				if(bilderNamenLoeschen.get(i).equals(nameBild)) {
					bilderNamenLoeschen.remove(nameBild);
				}
			}
			
			//for(String nameAktuellesBild : bilderNamenLoeschen) {
			//	System.out.println("Das ist das Bild aus der Textdatei, das gerade bearbeitet wird: " + nameAktuellesBild);
			//	if(nameAktuellesBild.equals(nameBild)) {
			//		bilderNamenLoeschen.remove(nameAktuellesBild);
			//	}
			//}
			
			String bild = bilderNamenLoeschen.get(0);
			Files.writeString(bilderNamenPfad, bild);
			for(int i = 1; i < bilderNamenLoeschen.size(); i++) {
				String bildEinfuegen = "\r\n" +bilderNamenLoeschen.get(i);
				Files.writeString(bilderNamenPfad, bildEinfuegen, StandardOpenOption.APPEND);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//aus dem Ordner löschen
		Path loeschPfad = Paths.get(bilderOrdnerPfad + nameBild);
		try {
			Files.deleteIfExists(loeschPfad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public boolean getWechseln() {
		return wechseln;
	}
	
	public String getBestimmtesBild(int i) {
		return meineBilder.get(i);
	}
	
	public int getAnzahlBilder() {
		return meineBilder.size();
	}
	
	
	
	
	
	
}
