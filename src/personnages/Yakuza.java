package personnages;

public class Yakuza extends Humain {
	
	private String clan;
    private int reputation;

    public Yakuza(String boissonPreferee, String nom, int argent, String clan) {
        super(boissonPreferee, nom, argent);
        this.clan = clan;
        this.reputation = 0;
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
}
