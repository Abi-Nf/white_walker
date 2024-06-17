package white.walker;

import java.util.ArrayList;
import java.util.List;

public class Marcheur {
  private final String nom;

  public Marcheur(String nom) {
    this.nom = nom;
  }

  public List<Lieu> marche(Carte carte, Lieu départ, Lieu destination){
    List<Lieu> lieux = new ArrayList<>();
    lieux.add(départ);

    var rues = carte.lesRues();
    while(!lieux.getLast().equals(destination)){
      var dernierAjouté = lieux.getLast();
      var rueConnecté = rues
        .stream()
        .filter(rue -> rue.aCeLieu(dernierAjouté))
        .toList();
      int indexAléatoire = (int) Math.floor(Math.random() * (rueConnecté.size() - 1));
      if(indexAléatoire == -1) continue;
      var rueAléatoire = rueConnecté.get(indexAléatoire);
      var lieuAAller = lieuAAller(rueAléatoire, dernierAjouté, lieux);
      lieux.add(lieuAAller);
      carte.verifierUnCulDeSac(rueAléatoire, lieuAAller, destination);
    }
    return lieux;
  }

  private static Lieu lieuAAller(Rue rueAléatoire, Lieu dernierAjouté, List<Lieu> lieux) {
    if (rueAléatoire.getLieuA().equals(dernierAjouté)) {
      return rueAléatoire.getLieuB();
    }
    return rueAléatoire.getLieuA();
  }

  @Override
  public String toString() {
    return nom;
  }
}
