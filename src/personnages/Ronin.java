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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int argentPossede = getArgent();
		int force = honneur * 2;
		int reputationAdverse = adversaire.getReputation();
		if (force >= reputationAdverse ) {
			parler("Je t’ai eu petit yakusa!");
			int argentGagne = adversaire.perdre();
			int argentTotal = argentPossede + argentGagne;
			setArgent(argentTotal);
			honneur++;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argentPossede);
			setArgent(0);
			honneur--;

		}
	}
}
