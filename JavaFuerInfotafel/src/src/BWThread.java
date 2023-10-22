package src;

public class BWThread extends Thread{
	
	private Bilderwechsler meinBilderwechsler;
	private int i = 0;

	public BWThread(Bilderwechsler BW) {
		meinBilderwechsler = BW;
	}
	
	public void BilderWechseln() {
		
		//hier while schleife benötigt; Zählvariable muss immer wieder zurückgesetzt werden
		while(meinBilderwechsler.getWechseln()) {
			
			String bildername = meinBilderwechsler.getBestimmtesBild(i);   
			
			meinBilderwechsler.DateiSpeichern(bildername);
			//In Datei speichern
			//Warten 1 minute und
			
			i++;
			if(i >= meinBilderwechsler.getAnzahlBilder()) {
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

	@Override public void run() {
		meinBilderwechsler.setWechseln(true);
		BilderWechseln();
	}
}
