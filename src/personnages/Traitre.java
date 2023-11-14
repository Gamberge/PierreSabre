package personnages;
import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise;
	
	public Traitre(String seigneur, String boissonPreferee, String nom, int argent) {
		super(seigneur, boissonPreferee, nom, argent);
		this.niveauTraitrise = 0;
	}
	
	@Override
	 public void direBonjour() {
		 super.direBonjour();
	     parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut ! ");
	 }
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconne = (argentCommercant * 2) / 10;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconne + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			niveauTraitrise++;
		} else {
			parler("Mince je ne peux plus ranconner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			Random random = new Random();
			int nbAmi = random.nextInt(nbConnaissance);
			int don = getArgent() / 20;
			Humain ami = memoire[nbAmi];
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			ami.parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}
	}
}
