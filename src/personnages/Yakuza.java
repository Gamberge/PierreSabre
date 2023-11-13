package personnages;

public class Yakuza extends Humain {
	
	private String clan;
    private int reputation;

    public Yakuza(String boissonPreferee, String nom, int argent, String clan) {
        super(boissonPreferee, nom, argent);
        this.clan = clan;
        this.reputation = 0;
    }
    
    public int getReputation() {
    	return reputation;
    }
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.seFaireExtorquer();
		int argentActuel = getArgent();
		int nouveauArgentActuel = argentActuel + argentExtorque;
	    setArgent(nouveauArgentActuel);
	    reputation++;
	    parler("J’ai piqué les " + argentExtorque + " sous de " + victime.getNom() + ", ce qui me fait " + nouveauArgentActuel + " sous dans ma poche. Hi ! Hi !");
	}
	
	public int perdre() {
		int argentPerdu = getArgent();
		setArgent(0);
		reputation--;
		parler("J’ai perdu mon duel et mes " + argentPerdu + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		return argentPerdu;
	}
	
	 public void gagner(int gain) {
		 int argentPossede = getArgent();
		 argentPossede += gain;
		 setArgent(argentPossede);
		 reputation++;
		 parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
	 }
	 
	 @Override
	 public void direBonjour() {
		 super.direBonjour();
	     parler("Mon clan est celui de " + clan + ".");
	 }
}
