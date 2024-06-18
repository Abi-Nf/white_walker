package white.walker;

import java.util.*;

public class Marcheur {
  private final String nom;

  public Marcheur(String nom) {
    this.nom = nom;
  }

  public List<Lieu> marche(Lieu depart, Lieu destination){
    List<Lieu> itineraire = new ArrayList<>();
    itineraire.add(depart);

    while (!itineraire.getLast().equals(destination)){
      var dernierLieuDeLItineraire = itineraire.getLast();
      var routes = dernierLieuDeLItineraire
        .lesRuesPossible()
        .stream()
        .toList();
      if (routes.isEmpty()) break;
      var indexAleatoire = (int) Math.floor(Math.random() * routes.size());
      var routeAleatoire = routes.get(indexAleatoire);
      var lieuAAller = lieuAAller(routeAleatoire, dernierLieuDeLItineraire);
      itineraire.add(lieuAAller);
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
