package white.walker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Marcheur {
  private final String nom;

  public Marcheur(String nom) {
    this.nom = nom;
  }

  public List<Lieu> marche(Carte carte, Lieu depart, Lieu destination){
    List<Lieu> itineraire = new ArrayList<>();
    Set<Lieu> visites = new HashSet<>();

    List<Lieu> lieuAVisite = new ArrayList<>();
    Map<Lieu, Lieu> sensDeLItineraire = new HashMap<>();

    lieuAVisite.add(depart);
    visites.add(depart);

    while (!lieuAVisite.isEmpty()) {
      Lieu lieuCourant = lieuAVisite.removeFirst();

      if (lieuCourant.equals(destination)) {
        while (lieuCourant != null) {
          itineraire.addFirst(lieuCourant);
          lieuCourant = sensDeLItineraire.get(lieuCourant);
        }
        return itineraire;
      }

      for (Rue rue : carte.lesRues()) {
        if (rue.aCeLieu(lieuCourant)) {
          var lieuAuVoisinage = lieuAAller(rue, lieuCourant);
          if (!visites.contains(lieuAuVoisinage)) {
            visites.add(lieuAuVoisinage);
            lieuAVisite.add(lieuAuVoisinage);
            sensDeLItineraire.put(lieuAuVoisinage, lieuCourant);
          }
        }
      }
    }

    return itineraire;
  }

  private static Lieu lieuAAller(Rue rue, Lieu pointDeRepere) {
    if (rue.getLieuA().equals(pointDeRepere)) return rue.getLieuB();
    return rue.getLieuA();
  }

  @Override
  public String toString() {
    return nom;
  }
}
