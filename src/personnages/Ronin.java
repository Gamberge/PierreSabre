package personnages;

public class Ronin extends Humain {
	private int honneur;
	public Ronin(String boissonPreferee, String nom, int argent) {
		super(boissonPreferee, nom, argent);
		this.honneur = 1;
	}
	
	public void donner(Commercant beneficiaire) {
		int argentActuel = getArgent();
		int argentDonne = argentActuel / 10;
		setArgent(argentActuel - argentDonne);
		parler(beneficiaire.getNom() + " prend ces " + argentDonne + " sous.");
		beneficiaire.recevoir(argentDonne);
	}
}
