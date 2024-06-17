package white.walker;

import java.util.ArrayList;
import java.util.List;

public class Marcheur {
  public static List<Lieu> marche(Carte carte, Lieu départ, Lieu destination){
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
      var rueAléatoire = rueConnecté.get(indexAléatoire);
      if (rueAléatoire.getLieuA().equals(dernierAjouté)) {
        lieux.add(rueAléatoire.getLieuB());
      }else {
        lieux.add(rueAléatoire.getLieuA());
      }
    }

    return lieux;
  }
}
