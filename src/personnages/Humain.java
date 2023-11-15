package personnages;

public class Humain {
    private String nom;
    private String boissonFavorite;
    private int argent;
    protected int nbConnaissance;
    protected Humain[] memoire;

    public Humain(String nom, String boissonFavorite, int argent) {
        this.nom = nom;
        this.boissonFavorite = boissonFavorite;
        this.argent = argent;
        this.nbConnaissance = 0;
        this.memoire = new Humain[30];
    }

    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public void direBonjour() {
        parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
    }

    public void boire() {
        parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
    }

    public void acheter(String bien, int prix) {
        if (argent >= prix) {
            parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
            argent -= prix;
        } else {
            parler("J'ai " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
        }
    }

    protected void parler(String texte) {
        System.out.println("(" + nom + ") - " + texte);
    }

    protected void gagnerArgent(int gain) {
        argent += gain;
        parler("Chouette ! J'ai gagné " + gain + " sous !");
    }

    protected void perdreArgent(int perte) {
        argent += perte;
        parler("Oh non ! J'ai perdu " + perte + " sous !");
    }

    public void faireConnaissanceAvec(Humain autreHumain) {
        direBonjour();
        autreHumain.repondre(this);
        memoriser(autreHumain);
    }

    private void repondre(Humain humain) {
        direBonjour();
        memoriser(humain);
    }

    public void memoriser(Humain humain) {
        if (nbConnaissance == memoire.length) {
            for (int i = 0; i < memoire.length - 1; i++) {
                memoire[i] = memoire[i + 1];
            }
            memoire[nbConnaissance - 1] = humain;
        }
        if (nbConnaissance < memoire.length) {
            memoire[nbConnaissance] = humain;
            nbConnaissance++;
        }
    }

    public void listerConnaissance() {
        System.out.print("Je connais beaucoup de monde dont: ");
        for (int i = 0; i < nbConnaissance; i++) {
            System.out.print(memoire[i].getNom());

            if (i < nbConnaissance - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(".");
        System.out.println("");
    }
}
