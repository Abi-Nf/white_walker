package white.walker;

import java.util.ArrayList;
import java.util.List;

public class Marcheur {
  private final String nom;

  public Marcheur(String nom) {
    this.nom = nom;
  }

  public List<Lieu> marche(Carte carte, Lieu depart, Lieu destination){
    List<Lieu> lieux = new ArrayList<>();
    lieux.add(depart);

    var rues = carte.lesRues();
    while(!lieux.getLast().equals(destination)){
      var dernierAjoute = lieux.getLast();
      var rueConnecte = rues
        .stream()
        .filter(rue -> rue.aCeLieu(dernierAjoute))
        .toList();
      int indexAleatoire = (int) Math.floor(Math.random() * (rueConnecte.size() - 1));
      if(indexAleatoire == -1) continue;
      var rueAleatoire = rueConnecte.get(indexAleatoire);
      var lieuAAller = lieuAAller(rueAleatoire, dernierAjoute);
      lieux.add(lieuAAller);
      carte.verifierUnCulDeSac(rueAleatoire, lieuAAller, destination);
    }
    return lieux;
  }

  private static Lieu lieuAAller(Rue rueAleatoire, Lieu dernierAjoute) {
    if (rueAleatoire.getLieuA().equals(dernierAjoute)) {
      return rueAleatoire.getLieuB();
    }
    return rueAleatoire.getLieuA();
  }

  @Override
  public String toString() {
    return nom;
  }
}
