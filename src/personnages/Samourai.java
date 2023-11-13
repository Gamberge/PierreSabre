package personnages;

public class Samourai extends Humain {
	
	private String seigneur;
	
	public Samourai(String seigneur, String boissonPreferee, String nom, int argent) {
        super(boissonPreferee, nom, argent);
        this.seigneur = seigneur;
    }
	
	@Override
	 public void direBonjour() {
		 super.direBonjour();
	     parler("Je suis fier de servir le seigneur " + seigneur + ".");
	 }

	// surcharge
	public void boire(String boisson) {
		this.parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson + ".");
	}
}
