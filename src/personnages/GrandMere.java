package personnages;

import java.util.Random;

public class GrandMere extends Humain {
    private enum TypeHumain {
        Commercant,
        GrandMere,
        Ronin,
        Samourai,
        Habitant,
        Traitre,
        Yakuza
    }

    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);
        this.memoire = new Humain[5];
    }

    @Override
    public void memoriser(Humain humain) {
        if (nbConnaissance == memoire.length) {
            parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
        } else {
            super.memoriser(humain);
        }
    }

    private String humainHasard() {
        Random random = new Random();
        TypeHumain[] types = TypeHumain.values();
        TypeHumain type = types[random.nextInt(types.length)];
        String nom = "";
        switch (type) {
            case Commercant:
                nom = "un commercant";
                break;
            case GrandMere:
                nom = "une grand-mère";
                break;
            case Ronin:
                nom = "un ronin";
                break;
            case Samourai:
                nom = " un samourai";
                break;
            case Habitant:
                nom = "un habitant";
                break;
            case Traitre:
                nom = "un traitre";
                break;
            case Yakuza:
                nom = "un yakuza";
                break;
        }
        return nom;
    }

    public void ragoter() {
        for (int i = 0; i < memoire.length; i++) {
            if (memoire[i] != null) {
                if (memoire[i] instanceof Traitre) {
                    parler("Je sais que " + memoire[i].getNom() + " est un traître. Petit chenapan !");
                } else {
                    String nom = humainHasard();
                    parler("Je crois que " + memoire[i].getNom() + " est " + nom + ".");
                }
            }
        }
    }
}